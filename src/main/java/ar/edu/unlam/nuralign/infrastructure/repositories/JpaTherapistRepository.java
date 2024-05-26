package ar.edu.unlam.nuralign.infrastructure.repositories;

import ar.edu.unlam.nuralign.infrastructure.entities.TherapistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaTherapistRepository extends JpaRepository<TherapistEntity, Long>{
    TherapistEntity findByEmail(String email);
    TherapistEntity findByDocumentNumber(Integer dni);
}
