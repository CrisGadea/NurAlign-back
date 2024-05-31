package ar.edu.unlam.nuralign.domain.models;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TherapySession {

    private Long id;

    private Long patientId;

    private Long therapistId;

    private String effectiveDate;

    private Integer sessionTime;

    private String preSessionNotes;

    private String postSessionNotes;

    private String sessionFeel;
}
