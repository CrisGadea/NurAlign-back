package ar.edu.unlam.nuralign.infrastructure.mappers;

import ar.edu.unlam.nuralign.domain.models.Therapist;
import ar.edu.unlam.nuralign.infrastructure.entities.TherapistEntity;

public class TherapistMapper {

    public static TherapistEntity mapToEntity(Therapist therapist) {
        return new TherapistEntity(
                therapist.getId(),
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

}
