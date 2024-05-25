package ar.edu.unlam.nuralign.infrastructure.repositories;

import ar.edu.unlam.nuralign.infrastructure.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPatientRepository extends JpaRepository<PatientEntity, Long> {
    PatientEntity findByEmail(String email);
    PatientEntity findByDni(String dni);
}
