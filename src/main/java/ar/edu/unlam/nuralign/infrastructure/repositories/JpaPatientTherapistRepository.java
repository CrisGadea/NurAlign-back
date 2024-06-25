package ar.edu.unlam.nuralign.infrastructure.repositories;

import ar.edu.unlam.nuralign.infrastructure.entities.PatientTherapistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface JpaPatientTherapistRepository extends JpaRepository<PatientTherapistEntity, Long> {
    List<PatientTherapistEntity> findAllByPatientId(Long patientId);
    @Modifying
    @Transactional
    @Query("DELETE FROM PatientTherapistEntity p WHERE p.patientId = ?1 AND p.therapistId = ?2")

    void deleteByPatientIdAndTherapistId(Long patientId, Long therapistId);
}
