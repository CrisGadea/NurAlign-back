package ar.edu.unlam.nuralign.infrastructure.repositories;

import ar.edu.unlam.nuralign.infrastructure.entities.SleepTrakerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaSleepTrakerRepository extends JpaRepository<SleepTrakerEntity, Long> {
}
