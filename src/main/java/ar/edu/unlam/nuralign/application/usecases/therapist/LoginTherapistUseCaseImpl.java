package ar.edu.unlam.nuralign.application.usecases.therapist;

import ar.edu.unlam.nuralign.application.ports.in.therapist.LogintherapistUseCase;
import ar.edu.unlam.nuralign.application.ports.out.TherapistRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.Therapist;

public class LoginTherapistUseCaseImpl implements LogintherapistUseCase {

    private final TherapistRepositoryPort repository;

    public LoginTherapistUseCaseImpl(TherapistRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Therapist login(Therapist user) {
        return repository.login(user.getEmail(), user.getPassword());
    }

}
