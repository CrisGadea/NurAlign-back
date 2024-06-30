package ar.edu.unlam.nuralign.infrastructure.mappers;

import ar.edu.unlam.nuralign.domain.models.TherapySession;
import ar.edu.unlam.nuralign.infrastructure.dtos.TherapySessionDto;
import ar.edu.unlam.nuralign.infrastructure.entities.TherapySessionEntity;

import java.time.LocalDate;

public class TherapySessionMapper {


    //modelt entity
    public static TherapySessionEntity toEntity(TherapySession therapySession) {
        return TherapySessionEntity.builder()
                .id(therapySession.getId())
                .patientId(therapySession.getPatientId())
                .therapistId(therapySession.getTherapistId())
                .effectiveDate(String.valueOf(therapySession.getEffectiveDate()))
                .sessionTime(therapySession.getSessionTime())
                .preSessionNotes(therapySession.getPreSessionNotes())
                .postSessionNotes(therapySession.getPostSessionNotes())
                .sessionFeel(therapySession.getSessionFeel())
                .build();


    }

    //model todto
    public static TherapySessionDto toDto(TherapySession therapySession)
    {
        return TherapySessionDto.builder()
                .id(therapySession.getId())
                .patientId(therapySession.getPatientId())
                .therapistId(therapySession.getTherapistId())
                .effectiveDate(String.valueOf(therapySession.getEffectiveDate()))
                .sessionTime(therapySession.getSessionTime())
                .preSessionNotes(therapySession.getPreSessionNotes())
                .postSessionNotes(therapySession.getPostSessionNotes())
                .sessionFeel(therapySession.getSessionFeel())
                .build();

    }

    //Entity to model
    public static TherapySession toModel(TherapySessionEntity therapySessionEntity)
    {
        return therapySessionEntity == null ? null : TherapySession.builder()
                .id(therapySessionEntity.getId())
                .patientId(therapySessionEntity.getPatientId())
                .therapistId(therapySessionEntity.getTherapistId())
                .effectiveDate(therapySessionEntity.getEffectiveDate() != null ? LocalDate.parse(therapySessionEntity.getEffectiveDate()) : null)
                .sessionTime(therapySessionEntity.getSessionTime())
                .preSessionNotes(therapySessionEntity.getPreSessionNotes())
                .postSessionNotes(therapySessionEntity.getPostSessionNotes())
                .sessionFeel(therapySessionEntity.getSessionFeel())
                .build();
    }
    //de dto a model
    public static TherapySession toModel(TherapySessionDto therapySessionDto)
    {
        return therapySessionDto == null ? null : TherapySession.builder()
                .id(therapySessionDto.getId())
                .patientId(therapySessionDto.getPatientId())
                .therapistId(therapySessionDto.getTherapistId())
                .effectiveDate(LocalDate.parse(therapySessionDto.getEffectiveDate()))
                .sessionTime(therapySessionDto.getSessionTime())
                .preSessionNotes(therapySessionDto.getPreSessionNotes())
                .postSessionNotes(therapySessionDto.getPostSessionNotes())
                .sessionFeel(therapySessionDto.getSessionFeel())
                .build();
    }
}
