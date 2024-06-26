package ar.edu.unlam.nuralign.domain.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicationTrackerNote {
    private Long id;
    private Long medicationTrackerId;
    private String effectiveDate;
    private String medicationNotes;
}
