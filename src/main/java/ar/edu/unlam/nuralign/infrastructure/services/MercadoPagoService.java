package ar.edu.unlam.nuralign.infrastructure.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class MercadoPagoService {

    @Value("${mp.access_token}")
    private String accessToken;

    private final RestTemplate restTemplate;

    public MercadoPagoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String createPreference(String itemTitle, int quantity, float price) {
        String url = "https://api.mercadopago.com/checkout/preferences";

        Map<String, Object> preference = new HashMap<>();
        Map<String, Object> item = new HashMap<>();
        item.put("title", itemTitle);
        item.put("quantity", quantity);
        item.put("unit_price", price);
        preference.put("items", new Map[]{item});

        Map<String, String> backUrls = new HashMap<>();
        backUrls.put("success", "http://nuralign.com/dashboard");
        backUrls.put("failure", "http://nuralign.com/dashboard");
        backUrls.put("pending", "http://nuralign.com/dashboard");

        preference.put("back_urls", backUrls);
        preference.put("auto_return", "approved");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(accessToken);

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(preference, headers);

        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Map.class);

        if (response.getStatusCode() == HttpStatus.CREATED) {
            Map<String, Object> responseBody = response.getBody();
            return responseBody != null ? (String) responseBody.get("init_point") : null;
        } else {
            throw new RuntimeException("Error creating Mercado Pago preference: " + response.getStatusCode());
        }
    }
}
