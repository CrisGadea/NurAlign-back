package ar.edu.unlam.nuralign.domain.models;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Report {


    private Long therapistId;

    private LocalDate initialDate;

    LocalDate endDate;

    private LocalDate effectiveDate;

    private Boolean moodFlag;

    private Boolean sleepFlag;

    private Boolean therapyFlag;

    private Boolean medicationFlag;

    private String patientName;

}
