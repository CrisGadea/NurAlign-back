package ar.edu.unlam.nuralign.infrastructure.mappers;

import ar.edu.unlam.nuralign.domain.models.SleepTracker;
import ar.edu.unlam.nuralign.infrastructure.dtos.SleepTrackerDto;
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

    public static SleepTrackerDto toDto(SleepTracker domain) {
        return SleepTrackerDto.builder()
                .patientId(domain.getPatientId())
                .effectiveDate(domain.getEffectiveDate())
                .sleepHours(domain.getSleepHours())
                .bedTime(String.valueOf(domain.getBedTime()))
                .negativeThoughtsFlag(domain.getNegativeThoughtsFlag())
                .anxiousFlag(domain.getAnxiousFlag())
                .sleepStraightFlag(domain.getSleepStraightFlag())
                .sleepNotes(domain.getSleepNotes())
                .build();
    }

    public static SleepTracker toDomain(SleepTrackerDto dto) {
        return SleepTracker.builder()
                .patientId(dto.getPatientId())
                .effectiveDate(dto.getEffectiveDate())
                .sleepHours(dto.getSleepHours())
                .bedTime(Integer.parseInt(dto.getBedTime()))
                .negativeThoughtsFlag(dto.getNegativeThoughtsFlag())
                .anxiousFlag(dto.getAnxiousFlag())
                .sleepStraightFlag(dto.getSleepStraightFlag())
                .sleepNotes(dto.getSleepNotes())
                .build();
    }
}
