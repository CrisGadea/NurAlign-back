package ar.edu.unlam.nuralign.infrastructure.repositories;

import ar.edu.unlam.nuralign.infrastructure.entities.ReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaReportRepository extends JpaRepository<ReportEntity, Long> {



    List<ReportEntity> findAllByTherapistId(Long thrapistId);

}
