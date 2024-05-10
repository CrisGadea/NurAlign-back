package ar.edu.unlam.nuralign.application.ports.in;

import ar.edu.unlam.nuralign.domain.models.Therapist;

import java.util.List;

public interface FindAllTherapistsUseCase {
    List<Therapist> findAllTherapists();
}
