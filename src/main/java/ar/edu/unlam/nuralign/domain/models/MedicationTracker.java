package ar.edu.unlam.nuralign.domain.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicationTracker {
    private Long id;
    private Long patientId;
    private String effectiveDate;
    private Boolean takenFlag;
}
