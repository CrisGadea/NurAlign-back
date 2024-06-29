package ar.edu.unlam.nuralign.infrastructure.controllers;

import ar.edu.unlam.nuralign.application.services.SubscriptionService;
import ar.edu.unlam.nuralign.infrastructure.dtos.SubscriptionRequest;
import ar.edu.unlam.nuralign.infrastructure.mappers.SubscriptionMapper;
import com.mercadopago.exceptions.MPException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subscriptions")
@CrossOrigin(origins = "*")
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping
    public ResponseEntity<String> createSubscription(@RequestBody SubscriptionRequest subscriptionRequest) {
        String preferenceId = String.valueOf(subscriptionService.generate(
                SubscriptionMapper.toModel(subscriptionRequest)
        ));
        String urlPago = "https://www.mercadopago.com/checkout/v1/redirect?pref_id=" + preferenceId;
        return ResponseEntity.ok(urlPago);
        //return ResponseEntity.ok(subscriptionService.generate(SubscriptionMapper.toModel(subscriptionRequest)));
    }
}
