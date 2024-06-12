package ar.edu.unlam.nuralign.infrastructure.dtos;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MedicationTrackerDto {
    private Long id;
    private Long patientMedicationId;
    private String effectiveDate;
    private Boolean takenFlag;
}
