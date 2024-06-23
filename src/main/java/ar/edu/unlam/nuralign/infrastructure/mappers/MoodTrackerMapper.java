package ar.edu.unlam.nuralign.infrastructure.mappers;

import ar.edu.unlam.nuralign.domain.models.MoodTracker;
import ar.edu.unlam.nuralign.infrastructure.dtos.MoodTrackerDto;
import ar.edu.unlam.nuralign.infrastructure.entities.MoodTrackerEntity;

public class MoodTrackerMapper {

    public static MoodTracker toModel(MoodTrackerDto moodTrackerDto) {
        return MoodTracker.builder()
                .id(moodTrackerDto.getId())
                .patientId(moodTrackerDto.getPatientId())
                .anxiousNotes(moodTrackerDto.getAnxiousNotes())
                .anxiousValue(moodTrackerDto.getAnxiousValue())
                .highestNotes(moodTrackerDto.getHighestNotes())
                .highestValue(moodTrackerDto.getHighestValue())
                .lowestNotes(moodTrackerDto.getLowestNotes())
                .lowestValue(moodTrackerDto.getLowestValue())
                .irritableNotes(moodTrackerDto.getIrritableNotes())
                .irritableValue(moodTrackerDto.getIrritableValue())
                .effectiveDate(moodTrackerDto.getEffectiveDate())
                .build();
    }

    public static MoodTrackerDto toDto(MoodTracker moodTracker) {
        return MoodTrackerDto.builder()
                .id(moodTracker.getId())
                .patientId(moodTracker.getPatientId())
                .anxiousNotes(moodTracker.getAnxiousNotes())
                .anxiousValue(moodTracker.getAnxiousValue())
                .highestNotes(moodTracker.getHighestNotes())
                .highestValue(moodTracker.getHighestValue())
                .lowestNotes(moodTracker.getLowestNotes())
                .lowestValue(moodTracker.getLowestValue())
                .irritableNotes(moodTracker.getIrritableNotes())
                .irritableValue(moodTracker.getIrritableValue())
                .effectiveDate(moodTracker.getEffectiveDate())
                .build();
    }

    public static MoodTrackerEntity toEntity(MoodTracker moodTracker) {
        return MoodTrackerEntity.builder()
                .id(moodTracker.getId())
                .patientId(moodTracker.getPatientId())
                .anxiousNotes(moodTracker.getAnxiousNotes())
                .anxiousValue(moodTracker.getAnxiousValue())
                .highestNotes(moodTracker.getHighestNotes())
                .highestValue(moodTracker.getHighestValue())
                .irritableValue(moodTracker.getIrritableValue())
                .irritableNotes(moodTracker.getIrritableNotes())
                .lowestNotes(moodTracker.getLowestNotes())
                .lowestValue(moodTracker.getLowestValue())
                .effectiveDate(moodTracker.getEffectiveDate())
                .build();
    }

    public static MoodTracker toModel(MoodTrackerEntity moodTrackerEntity) {
        if (moodTrackerEntity == null) {
            return null;
        }
        return MoodTracker.builder()
                .id(moodTrackerEntity.getId())
                .patientId(moodTrackerEntity.getPatientId())
                .anxiousNotes(moodTrackerEntity.getAnxiousNotes())
                .anxiousValue(moodTrackerEntity.getAnxiousValue())
                .highestNotes(moodTrackerEntity.getHighestNotes())
                .highestValue(moodTrackerEntity.getHighestValue())
                .lowestNotes(moodTrackerEntity.getLowestNotes())
                .lowestValue(moodTrackerEntity.getLowestValue())
                .irritableNotes(moodTrackerEntity.getIrritableNotes())
                .irritableValue(moodTrackerEntity.getIrritableValue())
                .effectiveDate(moodTrackerEntity.getEffectiveDate())
                .build();
    }
}
