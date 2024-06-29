package ar.edu.unlam.nuralign.application.services;

import ar.edu.unlam.nuralign.application.ports.in.therapist.LogintherapistUseCase;
import ar.edu.unlam.nuralign.domain.models.Therapist;

public class LoginTherapistService implements LogintherapistUseCase {

    private final LogintherapistUseCase logintherapistUseCase;

    public LoginTherapistService(LogintherapistUseCase logintherapistUseCase) {
        this.logintherapistUseCase = logintherapistUseCase;
    }

    @Override
    public Therapist login(Therapist user) {
        return logintherapistUseCase.login(user);
    }

}
