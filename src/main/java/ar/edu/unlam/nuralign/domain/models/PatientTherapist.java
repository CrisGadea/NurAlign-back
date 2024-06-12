package ar.edu.unlam.nuralign.domain.models;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatientTherapist {
    private Long id;
    private Long patientId;
    private Long therapistId;
}
