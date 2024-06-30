package ar.edu.unlam.nuralign.application.usecases.report;

import ar.edu.unlam.nuralign.application.ports.in.report.FindAllReportsByTherapistIdUseCase;
import ar.edu.unlam.nuralign.application.ports.out.ReportRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.Report;

import java.util.List;

public class FindAllReportsByTherapistIdUseCaseImpl implements FindAllReportsByTherapistIdUseCase {

    private final ReportRepositoryPort reportRepositoryPort;

    public FindAllReportsByTherapistIdUseCaseImpl(ReportRepositoryPort reportRepositoryPort) {
        this.reportRepositoryPort = reportRepositoryPort;
    }

    @Override
    public List<Report> findAllReportsByTherapistId(Long therapistId) {
        return reportRepositoryPort.findAllByTherapistId(therapistId);
    }
}
