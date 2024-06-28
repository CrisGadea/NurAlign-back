package ar.edu.unlam.nuralign.infrastructure.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class MedicationDto {
    private Long id;
    private Long patientId;
    private String name;
    private Long grammage;
    private Character flag;
    private Character enabledFlag;
}
