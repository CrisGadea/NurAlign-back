package ar.edu.unlam.nuralign.application.ports.out;

import ar.edu.unlam.nuralign.domain.models.Report;

import java.util.List;

public interface ReportRepositoryPort {
    Report save(Report report);
    List<Report> findAllByTherapistId(Long therapistId);
}
