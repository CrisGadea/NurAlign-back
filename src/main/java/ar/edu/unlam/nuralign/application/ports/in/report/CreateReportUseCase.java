package ar.edu.unlam.nuralign.application.ports.in.report;

import ar.edu.unlam.nuralign.domain.models.Report;

public interface CreateReportUseCase
{

    Report CreateReport(Report report);
}
