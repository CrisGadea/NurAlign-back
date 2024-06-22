package ar.edu.unlam.nuralign.infrastructure.adapters;

import ar.edu.unlam.nuralign.application.ports.out.TherapySessionRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.TherapySession;
import ar.edu.unlam.nuralign.infrastructure.entities.TherapySessionEntity;
import ar.edu.unlam.nuralign.infrastructure.mappers.TherapySessionMapper;
import ar.edu.unlam.nuralign.infrastructure.repositories.JpaTherapySessionRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JpaTherapySessionAdapter implements TherapySessionRepositoryPort {

    private JpaTherapySessionRepository repository;

    public JpaTherapySessionAdapter( JpaTherapySessionRepository repository ) {
        this.repository = repository;
    }

    @Override
    public TherapySession save(TherapySession therapySession) {

        TherapySessionEntity therapySessionEntity= TherapySessionMapper.toEntity(therapySession);

        return TherapySessionMapper.toModel(repository.save(therapySessionEntity));
    }

    @Override
    public List<TherapySession> findAllByPatientId(Long patientId) {

        List<TherapySessionEntity> entities= repository.findAllByPatientId(patientId);

        if(entities==null)
        {
            return Collections.emptyList();
        }
        return entities.stream().map(TherapySessionMapper::toModel).collect(Collectors.toList());
    }

    @Override
    public List<TherapySession> findAllByTherapistId(Long therapistId) {
       List<TherapySessionEntity> entities= repository.findAllByTherapistId(therapistId);
       if(entities==null)
       {
           return Collections.emptyList();

       }
       return entities.stream().map(TherapySessionMapper::toModel).collect(Collectors.toList());
    }

    @Override
    public TherapySession findBySessionId(Long sessionId) {
        return TherapySessionMapper.toModel(repository.findById(sessionId).get());
    }

    @Override
    public List<TherapySession> findAll() {
        List<TherapySessionEntity> entities= repository.findAll();
        return entities.stream().map(TherapySessionMapper::toModel).collect(Collectors.toList());
    }

    @Override
    public TherapySession update(Long sessionId, TherapySession therapySession) {
        TherapySessionEntity therapySessionEntity= repository.findById(sessionId).get();
        if (therapySession.getSessionFeel() != null) {
            therapySessionEntity.setSessionFeel(therapySession.getSessionFeel());
        }
        if (therapySession.getEffectiveDate() != null) {
            therapySessionEntity.setEffectiveDate(therapySession.getEffectiveDate());
        }
        if (therapySession.getPostSessionNotes() != null) {
            therapySessionEntity.setPostSessionNotes(therapySession.getPostSessionNotes());
        }
        if (therapySession.getPreSessionNotes() != null) {
            therapySessionEntity.setPreSessionNotes(therapySession.getPreSessionNotes());
        }
        if (therapySession.getSessionTime() != null) {
            therapySessionEntity.setSessionTime(therapySession.getSessionTime());
        }

        return TherapySessionMapper.toModel(repository.save(therapySessionEntity));
    }

}
