package ar.edu.unlam.nuralign.infrastructure.dtos;

import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportDto {

    private Long id;
    private Long therapistId;

    private LocalDate initialDate;

    LocalDate endDate;

    private LocalDate effectiveDate;

    private Boolean moodFlag;

    private Boolean sleepFlag;

    private Boolean therapyFlag;

    private Boolean medicationFlag;

    private String patientName;

    private Long patientId;
}
