package ar.edu.unlam.nuralign.application.ports.out;

import ar.edu.unlam.nuralign.domain.models.TurnTherapist;

import java.util.List;

public interface TurnTherapistReposirotyPort {

    TurnTherapist save(TurnTherapist turnTherapist);
    List<TurnTherapist> findAllByIdTurnTherapist(Long id);
    void deleteById(Long Id);
    List<TurnTherapist> findById(Long Id);
}
