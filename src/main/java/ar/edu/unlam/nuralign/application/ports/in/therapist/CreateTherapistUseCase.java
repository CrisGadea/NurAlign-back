package ar.edu.unlam.nuralign.application.ports.in.therapist;

import ar.edu.unlam.nuralign.domain.models.Therapist;

public interface CreateTherapistUseCase {
    Therapist createTherapist(Therapist therapist);
}
