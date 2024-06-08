package ar.edu.unlam.nuralign.domain.models;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicationTracker {
    private Long id;
    private Long patientId;
    private LocalDate effectiveDate;
    private Boolean takenFlag;
}
