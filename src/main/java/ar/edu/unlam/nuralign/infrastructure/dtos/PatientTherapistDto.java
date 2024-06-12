package ar.edu.unlam.nuralign.infrastructure.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatientTherapistDto {
    private Long id;
    private Long patientId;
    private Long therapistId;
}