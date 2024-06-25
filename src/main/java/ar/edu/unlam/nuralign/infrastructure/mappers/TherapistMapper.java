package ar.edu.unlam.nuralign.infrastructure.mappers;

import ar.edu.unlam.nuralign.domain.models.Therapist;
import ar.edu.unlam.nuralign.infrastructure.dtos.TherapistDto;
import ar.edu.unlam.nuralign.infrastructure.entities.TherapistEntity;

public class TherapistMapper {

    public static TherapistEntity mapToEntity(Therapist therapist) {
        return new TherapistEntity(
                therapist.getName(),
                therapist.getLastName(),
                therapist.getEmail(),
                therapist.getPhoneNumber(),
                therapist.getPassword(),
                therapist.getDocumentNumber(),
                therapist.getMedicalLicense(),
                therapist.getRegisteredFlag()
                );
    }

    public static Therapist mapToDomain(TherapistEntity therapistEntity) {
        return new Therapist(
                therapistEntity.getId(),
                therapistEntity.getName(),
                therapistEntity.getLastName(),
                therapistEntity.getEmail(),
                therapistEntity.getPhoneNumber(),
                therapistEntity.getPassword(),
                therapistEntity.getDocumentNumber(),
                therapistEntity.getMedicalLicense(),
                therapistEntity.getRegisteredFlag()
                );
    }

    public static TherapistDto mapToDto(Therapist therapist) {
        return new TherapistDto(
                therapist.getId(),
                therapist.getName(),
                therapist.getLastName(),
                therapist.getEmail(),
                therapist.getPassword(),
                therapist.getPhoneNumber(),
                therapist.getDocumentNumber(),
                therapist.getMedicalLicense(),
                therapist.getRegisteredFlag()
                );
    }

    public static Therapist mapToDomain(TherapistDto therapistDto) {
        return new Therapist(
                null,
                therapistDto.getName(),
                therapistDto.getLastName(),
                therapistDto.getEmail(),
                therapistDto.getPhoneNumber(),
                therapistDto.getPassword(),
                therapistDto.getDocumentNumber(),
                therapistDto.getMedicalLicense(),
                therapistDto.getRegisteredFlag(),
                therapistDto.getPatientId()
                );
    }

}
