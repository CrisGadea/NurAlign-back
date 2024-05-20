package ar.edu.unlam.nuralign.infrastructure.repositories;

import ar.edu.unlam.nuralign.infrastructure.entities.MoodTrackerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMoodTrackerRepository extends JpaRepository<MoodTrackerEntity, Long>{
}
