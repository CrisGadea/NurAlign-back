package ar.edu.unlam.nuralign.application.services;

import ar.edu.unlam.nuralign.application.ports.in.turnTherapist.CreateTurnTherapistUseCase;
import ar.edu.unlam.nuralign.application.ports.in.turnTherapist.DeleteTurnTherapistByIdUseCase;
import ar.edu.unlam.nuralign.application.ports.in.turnTherapist.FindAllByTherapistIdTurnTherapistUseCase;
import ar.edu.unlam.nuralign.domain.models.TurnTherapist;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class TurnTherapistServiceTest {
    @Mock
    private CreateTurnTherapistUseCase createTurnTherapistUseCase;

    @Mock
    private FindAllByTherapistIdTurnTherapistUseCase findAllByTherapistTurnTherapist;

    @Mock
    private DeleteTurnTherapistByIdUseCase deleteTurnTherapist;

    @InjectMocks
    private TurnTherapistService turnTherapistService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("Should create turn therapist")
    @Test
    void shouldCreateTurnTherapist() {
        TurnTherapist turnTherapist = new TurnTherapist();
        when(createTurnTherapistUseCase.CreateTurnTherapist(turnTherapist)).thenReturn(turnTherapist);

        TurnTherapist result = turnTherapistService.createTurnTherapist(turnTherapist);

        verify(createTurnTherapistUseCase, times(1)).CreateTurnTherapist(turnTherapist);
        assertEquals(turnTherapist, result);
    }

    @DisplayName("Should find all by therapist id")
    @Test
    void shouldFindAllByTherapistId() {
        Long therapistId = 1L;
        List<TurnTherapist> turnTherapists = Collections.singletonList(new TurnTherapist());
        when(findAllByTherapistTurnTherapist.FindallByTherapistIdTurnTherapistUseCase(therapistId)).thenReturn(turnTherapists);

        List<TurnTherapist> result = turnTherapistService.FindAllByTherapistId(therapistId);

        verify(findAllByTherapistTurnTherapist, times(1)).FindallByTherapistIdTurnTherapistUseCase(therapistId);
        assertEquals(turnTherapists, result);
    }
}
