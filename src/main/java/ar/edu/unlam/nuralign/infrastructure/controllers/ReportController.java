package ar.edu.unlam.nuralign.infrastructure.controllers;


import ar.edu.unlam.nuralign.application.services.ReportService;
import ar.edu.unlam.nuralign.infrastructure.dtos.ReportDto;
import ar.edu.unlam.nuralign.infrastructure.mappers.ReportMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin(origins = "*")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping
    public ResponseEntity<ReportDto> createReport(@RequestBody ReportDto reportDto) {
        return ResponseEntity.ok(ReportMapper.toDto(reportService.createReport(ReportMapper.toModel(reportDto))));
    }

    @GetMapping("/{therapistId}")
    public ResponseEntity<List<ReportDto>> FindAllReportsByTherapistId(@PathVariable Long therapistId)
    {

        return ResponseEntity.ok(reportService.findAllReportsByTherapistId(therapistId).stream().map(ReportMapper::toDto).toList());
    }
}
