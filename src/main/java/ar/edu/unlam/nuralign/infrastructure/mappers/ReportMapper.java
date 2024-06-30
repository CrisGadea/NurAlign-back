package ar.edu.unlam.nuralign.infrastructure.mappers;

import ar.edu.unlam.nuralign.domain.models.Report;
import ar.edu.unlam.nuralign.infrastructure.dtos.ReportDto;
import ar.edu.unlam.nuralign.infrastructure.entities.ReportEntity;

public class ReportMapper {

    // DTO to Model
    public static Report toModel(ReportDto reportDto) {
        return Report.builder()
                .therapistId(reportDto.getTherapistId())
                .effectiveDate(reportDto.getEffectiveDate())
                .initialDate(reportDto.getInitialDate())
                .endDate(reportDto.getEndDate())
                .moodFlag(reportDto.getMoodFlag())  // Corregido a moodFlag
                .sleepFlag(reportDto.getSleepFlag())
                .therapyFlag(reportDto.getTherapyFlag())
                .medicationFlag(reportDto.getMedicationFlag())  // Corregido a medicationFlag
                .patientName(reportDto.getPatientName())
                .build();
    }

    // Model to DTO
    public static ReportDto toDto(Report report) {
        return ReportDto.builder()
                .therapistId(report.getTherapistId())
                .effectiveDate(report.getEffectiveDate())
                .initialDate(report.getInitialDate())
                .endDate(report.getEndDate())
                .moodFlag(report.getMoodFlag())  // Corregido a moodFlag
                .sleepFlag(report.getSleepFlag())
                .therapyFlag(report.getTherapyFlag())
                .medicationFlag(report.getMedicationFlag())  // Corregido a medicationFlag
                .patientName(report.getPatientName())
                .build();
    }

    // Model to Entity
    public static ReportEntity toEntity(Report report) {
        return ReportEntity.builder()
                .therapistId(report.getTherapistId())
                .effectiveDate(report.getEffectiveDate())
                .initialDate(report.getInitialDate())
                .endDate(report.getEndDate())
                .moodFlag(report.getMoodFlag())
                .sleepFlag(report.getSleepFlag())
                .therapyFlag(report.getTherapyFlag())
                .medicationFlag(report.getMedicationFlag())
                .patientName(report.getPatientName())
                .build();
    }

    // Entity to Model
    public static Report EntitytoModel(ReportEntity reportEntity) {
        return Report.builder()
                .therapistId(reportEntity.getTherapistId())
                .effectiveDate(reportEntity.getEffectiveDate())
                .initialDate(reportEntity.getInitialDate())
                .endDate(reportEntity.getEndDate())
                .moodFlag(reportEntity.getMoodFlag())
                .sleepFlag(reportEntity.getSleepFlag())
                .therapyFlag(reportEntity.getTherapyFlag())
                .medicationFlag(reportEntity.getMedicationFlag())
                .patientName(reportEntity.getPatientName())
                .build();
    }
}
