package ar.edu.unlam.nuralign.infrastructure.controllers;

import ar.edu.unlam.nuralign.infrastructure.services.MercadoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mercadopago")
@CrossOrigin(origins = "*")
public class MercadoPagoController {

    private final MercadoPagoService mercadoPagoService;

    @Autowired
    public MercadoPagoController(MercadoPagoService mercadoPagoService) {
        this.mercadoPagoService = mercadoPagoService;
    }

    @PostMapping("/createPreference")
    public ResponseEntity<String> createPreference(@RequestParam String title, @RequestParam int quantity, @RequestParam float price) {
        try {
            String checkoutUrl = mercadoPagoService.createPreference(title, quantity, price);
            return ResponseEntity.ok(checkoutUrl);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error creating preference: " + e.getMessage());
        }
    }
}