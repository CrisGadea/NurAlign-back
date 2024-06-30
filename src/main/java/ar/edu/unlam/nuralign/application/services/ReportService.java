package ar.edu.unlam.nuralign.application.services;

import ar.edu.unlam.nuralign.application.ports.in.report.CreateReportUseCase;
import ar.edu.unlam.nuralign.application.ports.in.report.FindAllReportsByTherapistIdUseCase;
import ar.edu.unlam.nuralign.domain.models.Report;

import java.util.List;

public class ReportService {

    private final CreateReportUseCase createReportUseCase;
    private final FindAllReportsByTherapistIdUseCase findAllReportsByTherapistIdUseCase;

    public ReportService(CreateReportUseCase createReportUseCase,
                         FindAllReportsByTherapistIdUseCase findAllReportsByTherapistIdUseCase) {
        this.createReportUseCase = createReportUseCase;
        this.findAllReportsByTherapistIdUseCase= findAllReportsByTherapistIdUseCase;
    }
    public Report createReport(Report report) {
        return createReportUseCase.CreateReport(report);

    }
    public List<Report> findAllReportsByTherapistId(Long therapistId) {
        return findAllReportsByTherapistIdUseCase.findAllReportsByTherapistId(therapistId);
    }
}
