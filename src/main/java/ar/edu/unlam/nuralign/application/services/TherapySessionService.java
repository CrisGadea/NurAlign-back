package ar.edu.unlam.nuralign.application.services;

import ar.edu.unlam.nuralign.application.ports.in.therapySession.*;
import ar.edu.unlam.nuralign.domain.models.TherapySession;


import java.util.List;

public class TherapySessionService implements CreateTherapySessionUseCase, FindAllTherapySessionByPatientIdUseCase,
        FindAllTherapySessionByTherapistIdUseCase, FindAllTherapySessionsByPatientIdAndTherapistIdUseCase,FindAllTherapySessionByPatientIdAndRangeDateUseCase,
        UpdateTherapistSessionUseCase, FindTherapySessionByIdUseCase{

private final CreateTherapySessionUseCase createTherapySessionUseCase;
private final FindTherapySessionByIdUseCase findTherapySessionByIdUseCase;
private final FindAllTherapySessionByPatientIdUseCase findTherapySessionByPatientIdUseCase;
private final FindAllTherapySessionByTherapistIdUseCase findTherapySessionByTherapistIdUseCase;
private final UpdateTherapistSessionUseCase updateTherapistSessionUseCase;
private final FindAllTherapySessionsByPatientIdAndTherapistIdUseCase findAllTherapySessionsByPatientIdAndTherapistIdUseCase;
private final FindAllTherapySessionByPatientIdAndRangeDateUseCase findAllTherapySessionByPatientIdAndRangeDateUseCase;


    public TherapySessionService(CreateTherapySessionUseCase createTherapySessionUseCase,
                                 FindTherapySessionByIdUseCase findTherapySessionByIdUseCase,
                                 FindAllTherapySessionByPatientIdUseCase findAllTherapySessionByPatientIdUseCase,
                                 FindAllTherapySessionByTherapistIdUseCase findAllTherapySessionByTherapistIdUseCase,
                                 UpdateTherapistSessionUseCase updateTherapistSessionUseCase,
                                 FindAllTherapySessionsByPatientIdAndTherapistIdUseCase findAllTherapySessionsByPatientIdAndTherapistIdUseCase, FindAllTherapySessionByPatientIdAndRangeDateUseCase findAllTherapySessionByPatientIdAndRangeDateUseCase) {

        this.createTherapySessionUseCase = createTherapySessionUseCase;
        this.findTherapySessionByIdUseCase = findTherapySessionByIdUseCase;
        this.findTherapySessionByPatientIdUseCase=findAllTherapySessionByPatientIdUseCase;
        this.findTherapySessionByTherapistIdUseCase=findAllTherapySessionByTherapistIdUseCase;
        this.updateTherapistSessionUseCase=updateTherapistSessionUseCase;
        this.findAllTherapySessionsByPatientIdAndTherapistIdUseCase=findAllTherapySessionsByPatientIdAndTherapistIdUseCase;
        this.findAllTherapySessionByPatientIdAndRangeDateUseCase = findAllTherapySessionByPatientIdAndRangeDateUseCase;
    }

    @Override
    public TherapySession createTherapySession(TherapySession therapySession) {

        return createTherapySessionUseCase.createTherapySession(therapySession);
    }

    @Override
    public TherapySession FindTherapySessionById(Long Id) {
        return findTherapySessionByIdUseCase.FindTherapySessionById(Id);
    }

    @Override
    public List<TherapySession> FindAllTherapySessionByPatientId(Long patientId) {
        return findTherapySessionByPatientIdUseCase.FindAllTherapySessionByPatientId(patientId);
    }

    @Override
    public List<TherapySession> FindAllTherapySessionByTherapistId(Long id) {
        return findTherapySessionByTherapistIdUseCase.FindAllTherapySessionByTherapistId(id);
    }

    @Override
    public List<TherapySession> findAllTherapySessionsByPatientIdAndTherapistId(Long patientId, Long therapistId) {
        return findAllTherapySessionsByPatientIdAndTherapistIdUseCase.findAllTherapySessionsByPatientIdAndTherapistId(patientId, therapistId);
    }

    @Override
    public TherapySession update(TherapySession therapySession, Long id) {
        return updateTherapistSessionUseCase.update(therapySession,id);
    }

        public List<TherapySession> FindAllTherapySessionByPatientIdAndRangeDate(Long patientId, String fromDate, String toDate)
        {
            return findAllTherapySessionByPatientIdAndRangeDateUseCase.FindAllTherapySessionByPatientIdAndRangeDate(patientId, fromDate, toDate);
        }
}
