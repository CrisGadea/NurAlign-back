package ar.edu.unlam.nuralign.infrastructure.controllers;

import ar.edu.unlam.nuralign.application.services.SubscriptionService;
import ar.edu.unlam.nuralign.domain.models.Subscription;
import ar.edu.unlam.nuralign.infrastructure.dtos.SubscriptionRequest;
import ar.edu.unlam.nuralign.infrastructure.mappers.SubscriptionMapper;
import com.mercadopago.exceptions.MPException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class SubscriptionControllerTest {

//    @Mock
//    private SubscriptionService subscriptionService;
//
//    @InjectMocks
//    private SubscriptionController subscriptionController;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }

//    @Test
//    public void testCreateSubscription() throws MPException {
//        SubscriptionRequest subscriptionRequest = new SubscriptionRequest();
//        Subscription subscription = new Subscription();
//        String expectedUrlPago = "https://www.mercadopago.com/checkout/v1/redirect?pref_id=testPreferenceId" ;
//
//        try (MockedStatic<SubscriptionMapper> mockedMapper = mockStatic(SubscriptionMapper.class)) {
//            mockedMapper.when(() -> SubscriptionMapper.toModel(subscriptionRequest)).thenReturn(subscription); // Replace with appropriate model object
//            when(subscriptionService.generate(any())).thenReturn(subscription);
//
//            ResponseEntity<String> response = subscriptionController.createSubscription(subscriptionRequest);
//
//            assertEquals(HttpStatus.OK, response.getStatusCode());
//            assertEquals(expectedUrlPago, response.getBody());
//            verify(subscriptionService, times(1)).generate(any());
//        }
//    }
}