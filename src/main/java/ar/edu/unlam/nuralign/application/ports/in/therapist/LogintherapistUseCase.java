package ar.edu.unlam.nuralign.application.ports.in.therapist;

import ar.edu.unlam.nuralign.domain.models.Therapist;
import ar.edu.unlam.nuralign.infrastructure.dtos.LoginData;
import ar.edu.unlam.nuralign.infrastructure.dtos.LoginResponse;

public interface LogintherapistUseCase {
    Therapist login(LoginData data);
}
