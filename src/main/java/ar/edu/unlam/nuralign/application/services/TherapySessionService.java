package ar.edu.unlam.nuralign.application.services;

import ar.edu.unlam.nuralign.application.ports.in.therapySession.CreateTherapySessionUseCase;
import ar.edu.unlam.nuralign.application.ports.in.therapySession.FindAllTherapySessionByPatientIdUseCase;
import ar.edu.unlam.nuralign.application.ports.in.therapySession.FindAllTherapySessionByTherapistIdUseCase;
import ar.edu.unlam.nuralign.application.usecases.therapySession.CreateTherapySessionUseCaseImpl;
import ar.edu.unlam.nuralign.application.usecases.therapySession.FindAllTherapySessionByPatientIdUseCaseImpl;
import ar.edu.unlam.nuralign.application.usecases.therapySession.FindAllTherapySessionByTherapistIdUseCaseImpl;
import ar.edu.unlam.nuralign.domain.models.TherapySession;
import ar.edu.unlam.nuralign.infrastructure.dtos.TherapySessionDto;


import java.util.List;

public class TherapySessionService implements CreateTherapySessionUseCase, FindAllTherapySessionByPatientIdUseCase,
        FindAllTherapySessionByTherapistIdUseCase{

private final CreateTherapySessionUseCase createTherapySessionUseCase;
private final FindAllTherapySessionByPatientIdUseCase findTherapySessionByPatientIdUseCase;
private final FindAllTherapySessionByTherapistIdUseCase findTherapySessionByTherapistIdUseCase;



    public TherapySessionService(CreateTherapySessionUseCase createTherapySessionUseCase,
                                 FindAllTherapySessionByPatientIdUseCase findAllTherapySessionByPatientIdUseCase,
                                 FindAllTherapySessionByTherapistIdUseCase findAllTherapySessionByTherapistIdUseCase) {

        this.createTherapySessionUseCase = createTherapySessionUseCase;
        this.findTherapySessionByPatientIdUseCase=findAllTherapySessionByPatientIdUseCase;
        this.findTherapySessionByTherapistIdUseCase=findAllTherapySessionByTherapistIdUseCase;


    }

    @Override
    public TherapySession createTherapySession(TherapySession therapySession) {

        return createTherapySessionUseCase.createTherapySession(therapySession);
    }

    @Override
    public List<TherapySession> FindAllTherapySessionByPatientId(Long patientId) {
        return findTherapySessionByPatientIdUseCase.FindAllTherapySessionByPatientId(patientId);
    }

    @Override
    public List<TherapySession> FindAllTherapySessionByTherapistId(Long id) {
        return findTherapySessionByTherapistIdUseCase.FindAllTherapySessionByTherapistId(id);
    }
}
