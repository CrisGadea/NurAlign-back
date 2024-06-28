package ar.edu.unlam.nuralign.infrastructure.mappers;

import ar.edu.unlam.nuralign.domain.models.Medication;
import ar.edu.unlam.nuralign.infrastructure.dtos.MedicationDto;
import ar.edu.unlam.nuralign.infrastructure.entities.MedicationEntity;

public class MedicationMapper {
    public static Medication toModel(MedicationDto medicationDto) {
        return Medication.builder()
                .id(medicationDto.getId())
                .patientId(medicationDto.getPatientId())
                .name(medicationDto.getName())
                .grammage(medicationDto.getGrammage())
                .flag(medicationDto.getFlag())
                .enabledFlag(medicationDto.getEnabledFlag())
                .build();
    }

    public static MedicationDto toDto(Medication medication) {
        return MedicationDto.builder()
                .id(medication.getId())
                .patientId(medication.getPatientId())
                .name(medication.getName())
                .grammage(medication.getGrammage())
                .flag(medication.getFlag())
                .enabledFlag(medication.getEnabledFlag())
                .build();
    }

    public static MedicationEntity toEntity(Medication medication) {
        return MedicationEntity.builder()
                .patientId(medication.getPatientId())
                .name(medication.getName())
                .grammage(medication.getGrammage())
                .flag(medication.getFlag())
                .enabledFlag(medication.getEnabledFlag())
                .build();
    }

    public static Medication toModel(MedicationEntity medicationEntity) {
        return Medication.builder()
                .id(medicationEntity.getId())
                .patientId(medicationEntity.getPatientId())
                .name(medicationEntity.getName())
                .grammage(medicationEntity.getGrammage())
                .flag(medicationEntity.getFlag())
                .enabledFlag(medicationEntity.getEnabledFlag())
                .build();
    }
}
