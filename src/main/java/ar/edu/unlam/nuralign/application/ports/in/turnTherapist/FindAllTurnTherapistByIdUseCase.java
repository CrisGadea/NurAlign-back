package ar.edu.unlam.nuralign.application.ports.in.turnTherapist;

import ar.edu.unlam.nuralign.domain.models.TurnTherapist;

import java.util.List;

public interface FindAllTurnTherapistByIdUseCase {
List<TurnTherapist> findByIdTurnTherapist(Long idTurnTherapist);
}
