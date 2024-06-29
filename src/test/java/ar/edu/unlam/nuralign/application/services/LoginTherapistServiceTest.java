package ar.edu.unlam.nuralign.application.services;

import ar.edu.unlam.nuralign.application.ports.in.therapist.LogintherapistUseCase;
import ar.edu.unlam.nuralign.domain.models.Therapist;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

public class LoginTherapistServiceTest {
    @Mock
    private LogintherapistUseCase logintherapistUseCase;

    @InjectMocks
    private LoginTherapistService loginTherapistService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Should login therapist successfully")
    @Test
    void shouldLoginTherapistSuccessfully() {
        Therapist therapist = new Therapist();
        when(logintherapistUseCase.login(therapist)).thenReturn(therapist);

        Therapist result = loginTherapistService.login(therapist);

        assertEquals(therapist, result);
    }

    @DisplayName("Should return null when login with null therapist")
    @Test
    void shouldReturnNullWhenLoginWithNullTherapist() {
        when(logintherapistUseCase.login(null)).thenReturn(null);

        Therapist result = loginTherapistService.login(null);

        assertNull(result);
    }
}
