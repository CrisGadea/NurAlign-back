package ar.edu.unlam.nuralign.infrastructure.mappers;

import ar.edu.unlam.nuralign.domain.models.SleepTracker;
import ar.edu.unlam.nuralign.infrastructure.entities.SleepTrackerEntity;

public class SleepTrackerMapper {

    public static SleepTracker toDomain(SleepTrackerEntity entity) {
        return SleepTracker.builder()
                .patientId(entity.getPatientId())
                .sleepHours(entity.getSleepHours())
                .effectiveDate(entity.getEffectiveDate())
                .bedTime(entity.getBedTime())
                .negativeThoughtsFlag(entity.getNegativeThoughtsFlag())
                .anxiousFlag(entity.getAnxiousFlag())
                .sleepStraightFlag(entity.getSleepStraightFlag())
                .sleepNotes(entity.getSleepNotes())
                .build();
    }

    public static SleepTrackerEntity toEntity(SleepTracker domain) {
        SleepTrackerEntity entity = new SleepTrackerEntity();
        entity.setPatientId(domain.getPatientId());
        entity.setSleepHours(domain.getSleepHours());
        entity.setBedTime(domain.getBedTime());
        entity.setEffectiveDate(domain.getEffectiveDate());
        entity.setNegativeThoughtsFlag(domain.getNegativeThoughtsFlag());
        entity.setAnxiousFlag(domain.getAnxiousFlag());
        entity.setSleepStraightFlag(domain.getSleepStraightFlag());
        entity.setSleepNotes(domain.getSleepNotes());
        return entity;
    }
}
