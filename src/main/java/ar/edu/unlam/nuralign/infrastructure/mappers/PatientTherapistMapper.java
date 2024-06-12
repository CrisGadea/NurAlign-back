package ar.edu.unlam.nuralign.infrastructure.mappers;

import ar.edu.unlam.nuralign.domain.models.PatientTherapist;
import ar.edu.unlam.nuralign.infrastructure.dtos.PatientTherapistDto;
import ar.edu.unlam.nuralign.infrastructure.entities.PatientTherapistEntity;

public class PatientTherapistMapper {
    public static PatientTherapist toModel(PatientTherapistEntity entity) {
        return PatientTherapist.builder()
                .id(entity.getId())
                .patientId(entity.getPatientId())
                .therapistId(entity.getTherapistId())
                .build();
    }

    public static PatientTherapistEntity toEntity(PatientTherapist model) {
        return PatientTherapistEntity.builder()
                .patientId(model.getPatientId())
                .therapistId(model.getTherapistId())
                .build();
    }

    public static PatientTherapist toModel(PatientTherapistDto dto) {
        return PatientTherapist.builder()
                .id(dto.getId())
                .patientId(dto.getPatientId())
                .therapistId(dto.getTherapistId())
                .build();
    }

    public static PatientTherapistDto toDto(PatientTherapist model) {
        return PatientTherapistDto.builder()
                .id(model.getId())
                .patientId(model.getPatientId())
                .therapistId(model.getTherapistId())
                .build();
    }
}
