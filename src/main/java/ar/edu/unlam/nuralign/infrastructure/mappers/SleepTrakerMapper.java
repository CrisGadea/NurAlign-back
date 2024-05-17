package ar.edu.unlam.nuralign.infrastructure.mappers;

import ar.edu.unlam.nuralign.domain.models.SleepTracker;
import ar.edu.unlam.nuralign.infrastructure.dtos.SleepTrakerDto;
import ar.edu.unlam.nuralign.infrastructure.entities.SleepTrakerEntity;

public class SleepTrakerMapper {

    public static SleepTrakerDto toDto(SleepTracker domain) {
        return new SleepTrakerDto(
                domain.getPatientId(),
                domain.getEffectiveDate(),
                domain.getSleepHours(),
                domain.getBedTime(),
                domain.getNegativeThoughtsFlag(),
                domain.getAnxiousFlag(),
                domain.getSleepStraightFlag(),
                domain.getSleepNotes()
        );
    }

    public static SleepTracker toDomain(SleepTrakerEntity entity) {
        return SleepTracker.builder()
                .patientId(entity.getPatientId())
                .effectiveDate(entity.getEffectiveDate())
                .sleepHours(entity.getSleepHours())
                .bedTime(entity.getBedTime())
                .negativeThoughtsFlag(entity.getNegativeThoughtsFlag())
                .anxiousFlag(entity.getAnxiousFlag())
                .sleepStraightFlag(entity.getSleepStraightFlag())
                .sleepNotes(entity.getSleepNotes())
                .build();
    }

    public static SleepTrakerEntity toEntity(SleepTracker domain) {
        SleepTrakerEntity entity = new SleepTrakerEntity();
        entity.setPatientId(domain.getPatientId());
        entity.setEffectiveDate(domain.getEffectiveDate());
        entity.setSleepHours(domain.getSleepHours());
        entity.setBedTime(domain.getBedTime());
        entity.setNegativeThoughtsFlag(domain.getNegativeThoughtsFlag());
        entity.setAnxiousFlag(domain.getAnxiousFlag());
        entity.setSleepStraightFlag(domain.getSleepStraightFlag());
        entity.setSleepNotes(domain.getSleepNotes());
        return entity;
    }
}
