package ar.edu.unlam.nuralign.infrastructure.dtos;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MedicationTrackerNotesDto {
    private Long id;
    private Long medicationTrackerId;
    private String effectiveDate;
    private String medicationNotes;
}
