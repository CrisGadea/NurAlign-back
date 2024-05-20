package ar.edu.unlam.nuralign.infrastructure.repositories;

import ar.edu.unlam.nuralign.infrastructure.entities.MedicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMedicationRepository extends JpaRepository<MedicationEntity, Long> {
}
