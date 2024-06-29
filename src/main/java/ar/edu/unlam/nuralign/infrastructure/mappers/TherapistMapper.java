package ar.edu.unlam.nuralign.infrastructure.mappers;

import ar.edu.unlam.nuralign.domain.models.Therapist;
import ar.edu.unlam.nuralign.infrastructure.dtos.LoginData;
import ar.edu.unlam.nuralign.infrastructure.dtos.TherapistDto;
import ar.edu.unlam.nuralign.infrastructure.entities.TherapistEntity;

public class TherapistMapper {

    public static TherapistEntity mapToEntity(Therapist therapist) {
        if (therapist == null) return null;
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
        if (therapistEntity == null) return null;
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
        return therapist.getPatientId() != null ?
                new TherapistDto(
                    therapist.getId(),
                    therapist.getName(),
                    therapist.getLastName(),
                    therapist.getEmail(),
                    therapist.getPassword(),
                    therapist.getPhoneNumber(),
                    therapist.getDocumentNumber(),
                    therapist.getMedicalLicense(),
                    therapist.getRegisteredFlag(),
                    therapist.getPatientId()
                    ) : new TherapistDto(
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
        if (therapistDto == null) return null;
        return therapistDto.getPatientId() != null ?
                new Therapist(
                    null,
                    therapistDto.getName(),
                    therapistDto.getLastName(),
                    therapistDto.getEmail(),
                    therapistDto.getPhoneNumber(),
                    therapistDto.getPassword(),
                    therapistDto.getDocumentNumber(),
                    therapistDto.getMedicalLicense(),
                    therapistDto.getRegisteredFlag(),
                    therapistDto.getPatientId()) :
                new Therapist(
                null,
                therapistDto.getName(),
                therapistDto.getLastName(),
                therapistDto.getEmail(),
                therapistDto.getPhoneNumber(),
                therapistDto.getPassword(),
                therapistDto.getDocumentNumber(),
                therapistDto.getMedicalLicense(),
                therapistDto.getRegisteredFlag());
    }

    public static Therapist mapToDomain(LoginData loginData) {
        if (loginData == null) return null;
        return new Therapist(
                null,
                null,
                null,
                loginData.getEmail(),
                null,
                loginData.getPassword(),
                null,
                null,
                null);
    }

}
