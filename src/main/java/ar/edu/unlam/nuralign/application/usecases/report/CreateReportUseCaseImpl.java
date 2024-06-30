package ar.edu.unlam.nuralign.application.usecases.report;

import ar.edu.unlam.nuralign.application.ports.in.report.CreateReportUseCase;
import ar.edu.unlam.nuralign.application.ports.out.ReportRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.Report;

public class CreateReportUseCaseImpl implements CreateReportUseCase {

    private final ReportRepositoryPort repositoryPort;

    public CreateReportUseCaseImpl(ReportRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public Report CreateReport(Report report) {
        return repositoryPort.save(report);
    }
}
