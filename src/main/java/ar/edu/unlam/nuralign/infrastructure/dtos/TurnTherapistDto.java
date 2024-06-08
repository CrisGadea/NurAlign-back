package ar.edu.unlam.nuralign.infrastructure.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class TurnTherapistDto {
    private Long id;
    private Long therapistId;
    private String NamePacient;
    private String effectiveDate;
    private String TurnTime;
}
