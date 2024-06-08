package ar.edu.unlam.nuralign.infrastructure.mappers;

import ar.edu.unlam.nuralign.domain.models.MedicationTrackerNote;
import ar.edu.unlam.nuralign.infrastructure.dtos.MedicationTrackerNotesDto;
import ar.edu.unlam.nuralign.infrastructure.entities.MedicationTrackerNoteEntity;

public class MedicationTrackerNoteMapper {
    public static MedicationTrackerNotesDto toDto(MedicationTrackerNote model){
        return MedicationTrackerNotesDto.builder()
                .id(model.getId())
                .medicationTrackerId(model.getMedicationTrackerId())
                .effectiveDate(model.getEffectiveDate())
                .medicationNotes(model.getMedicationNotes())
                .build();
    }

    public static MedicationTrackerNote toModel(MedicationTrackerNotesDto dto){
        return MedicationTrackerNote.builder()
                .id(dto.getId())
                .medicationTrackerId(dto.getMedicationTrackerId())
                .effectiveDate(dto.getEffectiveDate())
                .medicationNotes(dto.getMedicationNotes())
                .build();

    }

    public static MedicationTrackerNote toModel(MedicationTrackerNoteEntity entity){
        return MedicationTrackerNote.builder()
                .id(entity.getId())
                .medicationTrackerId(entity.getMedicationTrackerId())
                .effectiveDate(entity.getEffectiveDate())
                .medicationNotes(entity.getMedicationNotes())
                .build();
    }

    public static MedicationTrackerNoteEntity toEntity(MedicationTrackerNote model){
        return MedicationTrackerNoteEntity.builder()
                .medicationTrackerId(model.getMedicationTrackerId())
                .effectiveDate(model.getEffectiveDate())
                .medicationNotes(model.getMedicationNotes())
                .build();
    }
}
