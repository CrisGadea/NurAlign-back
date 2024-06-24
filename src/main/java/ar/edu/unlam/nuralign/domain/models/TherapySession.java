package ar.edu.unlam.nuralign.domain.models;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TherapySession {

    private Long id;

    private Long patientId;

    private Long therapistId;

    private LocalDate effectiveDate;

    private Integer sessionTime;

    private String preSessionNotes;

    private String postSessionNotes;

    private String sessionFeel;
}
