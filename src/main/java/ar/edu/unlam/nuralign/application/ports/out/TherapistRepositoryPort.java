package ar.edu.unlam.nuralign.application.ports.out;

import ar.edu.unlam.nuralign.domain.models.Therapist;

import java.util.List;
import java.util.Optional;

public interface TherapistRepositoryPort {
    Therapist save(Therapist therapist);
    Optional<Therapist> update(Therapist therapist, Long id);
    Optional<Therapist> findById(Long id);
    List<Therapist> findAll();
    void deleteById(Long id);
    Therapist login(String email, String password);
}
