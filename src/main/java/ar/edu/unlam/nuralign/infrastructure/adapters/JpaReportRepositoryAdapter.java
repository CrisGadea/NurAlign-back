package ar.edu.unlam.nuralign.infrastructure.adapters;

import ar.edu.unlam.nuralign.application.ports.out.ReportRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.Report;
import ar.edu.unlam.nuralign.infrastructure.entities.ReportEntity;
import ar.edu.unlam.nuralign.infrastructure.mappers.ReportMapper;
import ar.edu.unlam.nuralign.infrastructure.repositories.JpaReportRepository;

import java.util.List;

public class JpaReportRepositoryAdapter implements ReportRepositoryPort {
    private final JpaReportRepository reportRepository;

    public JpaReportRepositoryAdapter(JpaReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public Report save(Report report) {

        return ReportMapper.EntitytoModel(reportRepository.save(ReportMapper.toEntity(report)));
    }

    @Override
    public List<Report> findAllByTherapistId(Long therapistId) {
        return reportRepository.findAllByTherapistId(therapistId).stream().map(ReportMapper::EntitytoModel).toList();
    }
}
