package ar.edu.unlam.nuralign.application.ports.in.report;

import ar.edu.unlam.nuralign.domain.models.Report;

import java.util.List;

public interface FindAllReportsByTherapistIdUseCase {

    List<Report> findAllReportsByTherapistId(Long therapistId);

}
