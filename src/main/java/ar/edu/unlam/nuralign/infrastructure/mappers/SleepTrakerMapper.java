package ar.edu.unlam.nuralign.infrastructure.mappers;

import ar.edu.unlam.nuralign.domain.models.SleepTracker;
import ar.edu.unlam.nuralign.infrastructure.dtos.SleepTrakerDto;
import ar.edu.unlam.nuralign.infrastructure.entities.SleepTrakerEntity;

import java.time.LocalDateTime;

public class SleepTrakerMapper {

    public static SleepTracker toDomain(SleepTrakerEntity entity) {
        return SleepTracker.builder()
                .patientId(entity.getPatientId())
                .sleepHours(entity.getSleepHours())
                .effectiveDate(String.valueOf(entity.getEffectiveDate()))
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
        entity.setSleepHours(domain.getSleepHours());
        entity.setBedTime(domain.getBedTime());
        entity.setNegativeThoughtsFlag(domain.getNegativeThoughtsFlag());
        entity.setAnxiousFlag(domain.getAnxiousFlag());
        entity.setSleepStraightFlag(domain.getSleepStraightFlag());
        entity.setSleepNotes(domain.getSleepNotes());
        return entity;
    }
}
