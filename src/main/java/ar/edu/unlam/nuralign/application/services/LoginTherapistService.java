package ar.edu.unlam.nuralign.application.services;

import ar.edu.unlam.nuralign.application.ports.in.therapist.LogintherapistUseCase;
import ar.edu.unlam.nuralign.domain.models.Therapist;
import ar.edu.unlam.nuralign.infrastructure.dtos.LoginData;

public class LoginTherapistService implements LogintherapistUseCase {

    private final LogintherapistUseCase logintherapistUseCase;

    public LoginTherapistService(LogintherapistUseCase logintherapistUseCase) {
        this.logintherapistUseCase = logintherapistUseCase;
    }

    @Override
    public Therapist login(LoginData user) {
        return logintherapistUseCase.login(user);
    }

}
