package ar.edu.unlam.nuralign.infrastructure.mappers;

import ar.edu.unlam.nuralign.domain.models.MedicationTracker;
import ar.edu.unlam.nuralign.infrastructure.dtos.MedicationTrackerDto;
import ar.edu.unlam.nuralign.infrastructure.entities.MedicationTrackerEntity;

import java.time.LocalDate;

public class MedicationTrackerMapper {
    public static MedicationTrackerDto toDto(MedicationTracker model){
        return MedicationTrackerDto.builder()
                .id(model.getId())
                .patientMedicationId(model.getPatientId())
                .effectiveDate(String.valueOf(model.getEffectiveDate()))
                .takenFlag(model.getTakenFlag())
                .build();
    }

    public static MedicationTracker toModel(MedicationTrackerDto dto){
        return MedicationTracker.builder()
                .id(dto.getId())
                .patientId(dto.getPatientMedicationId())
                .effectiveDate(dto.getEffectiveDate() != null ? LocalDate.parse(dto.getEffectiveDate()) : null)
                .takenFlag(dto.getTakenFlag())
                .build();
    }

    public static MedicationTracker toModel(MedicationTrackerEntity entity){
        return MedicationTracker.builder()
                .id(entity.getId())
                .patientId(entity.getPatientId())
                .effectiveDate(entity.getEffectiveDate())
                .takenFlag(entity.getTakenFlag())
                .build();
    }

    public static MedicationTrackerEntity toEntity(MedicationTracker model){
        return MedicationTrackerEntity.builder()
                .patientId(model.getPatientId())
                .effectiveDate(model.getEffectiveDate())
                .takenFlag(model.getTakenFlag())
                .build();
    }
}
