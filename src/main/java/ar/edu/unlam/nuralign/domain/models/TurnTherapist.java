package ar.edu.unlam.nuralign.domain.models;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TurnTherapist {

    private Long id;
    private Long therapistId;
    private String NamePacient;
    private String effectiveDate;
    private String TurnTime;

}
