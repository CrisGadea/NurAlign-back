package ar.edu.unlam.nuralign.infrastructure.repositories;

import ar.edu.unlam.nuralign.infrastructure.entities.TherapySessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaTherapySessionRepository extends JpaRepository<TherapySessionEntity,Long> {

    List<TherapySessionEntity> findAllByPatientId(Long patientId);

    List<TherapySessionEntity> findAllByTherapistId(Long id);

    TherapySessionEntity findByTherapistIdAndPatientIdAndEffectiveDate(
            Long therapistId, Long patientId, String effectiveDate
    );

    List<TherapySessionEntity> findAllByPatientIdAndTherapistId(
            Long patientId, Long therapistId
    );

}