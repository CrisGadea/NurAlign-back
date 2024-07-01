//package ar.edu.unlam.nuralign.infrastructure.services;
//
//import com.mercadopago.MercadoPago;
//import com.mercadopago.exceptions.MPException;
//import com.mercadopago.resources.preference.Preference;
//import com.mercadopago.resources.preference.PreferenceItem;
//import com.mercadopago.resources.preference.PreferencePayer;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MercadoPagoService {
//
//    @Value("${mercado_pago.access_token}")
//    private String accessToken;
//
//    public MercadoPagoService() {
//        MercadoPago.SDK.setAccessToken(accessToken);
//    }
//
//    public Preference createPreference(String itemTitle, int quantity, float price) throws MPException {
//        Preference preference = new Preference();
//
//        PreferenceItem item = new PreferenceItem();
//        item.setTitle(itemTitle)
//                .setQuantity(quantity)
//                .setUnitPrice(price);
//
//        preference.appendItem(item);
//        preference.save();
//
//        return preference;
//    }
//}

//package ar.edu.unlam.nuralign.infrastructure.services;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.*;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//public class MercadoPagoService {
//
//    @Value("${mp.access_token}")
//    private String accessToken;
//
//    private final RestTemplate restTemplate;
//
//    public MercadoPagoService(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
//
//    public String createPreference(String itemTitle, int quantity, float price) {
//        String url = "https://api.mercadopago.com/checkout/preferences";
//
//        // Crear el objeto preferencia
//        Map<String, Object> preference = new HashMap<>();
//        Map<String, Object> item = new HashMap<>();
//        item.put("title", itemTitle);
//        item.put("quantity", quantity);
//        item.put("unit_price", price);
//        preference.put("items", new Map[]{item});
//
//        // Configurar la solicitud
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.setBearerAuth(accessToken);
//
//        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(preference, headers);
//
//        // Hacer la solicitud
//        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Map.class);
//
//        // Obtener el URL del checkout
//        if (response.getStatusCode() == HttpStatus.CREATED) {
//            Map<String, Object> responseBody = response.getBody();
//            return responseBody != null ? (String) responseBody.get("init_point") : null;
//        } else {
//            throw new RuntimeException("Error creating Mercado Pago preference: " + response.getStatusCode());
//        }
//    }
//}

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
        backUrls.put("success", "nuralign.com/dashboard");
        backUrls.put("failure", "nuralign.com/payment-failure");
        backUrls.put("pending", "nuralign.com/payment-pending");

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
