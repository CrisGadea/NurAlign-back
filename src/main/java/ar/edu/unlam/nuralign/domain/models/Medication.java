package ar.edu.unlam.nuralign.domain.models;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Medication {
    private Long id;
    private Long patientId;
    private String name;
    private Long grammage;
    private Character flag;
    private Character enabledFlag;
}
