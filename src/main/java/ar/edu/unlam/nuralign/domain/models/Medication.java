package ar.edu.unlam.nuralign.domain.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Medication {
    private Long id;
    private Long patientId;
    private String name;
    private Long grammage;
    private Character flag;
}
