package ar.edu.unlam.nuralign.infrastructure.repositories;

import ar.edu.unlam.nuralign.infrastructure.entities.TurnTherapistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaTurnTherapistRepository extends JpaRepository<TurnTherapistEntity,Long> {





    List<TurnTherapistEntity> findAllBytherapistId(Long id);

    List<TurnTherapistEntity> findAllById(Long id);
}
