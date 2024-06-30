package ar.edu.unlam.nuralign.infrastructure.repositories;

import ar.edu.unlam.nuralign.infrastructure.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaPatientRepository extends JpaRepository<PatientEntity, Long> {
    PatientEntity findByEmail(String email);
    PatientEntity findByDni(Integer dni);

    @Query(value = "SELECT p from PatientEntity p JOIN PatientTherapistEntity tp ON p.id=tp.patientId WHERE tp.therapistId=?1")
    List<PatientEntity> findAllByTherapistId(Long therapistId);
}
