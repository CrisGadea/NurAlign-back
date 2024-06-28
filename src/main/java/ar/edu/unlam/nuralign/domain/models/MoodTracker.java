package ar.edu.unlam.nuralign.domain.models;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MoodTracker {
    private Long id;
    private Long patientId;
    private LocalDate effectiveDate;
    private Integer highestValue;
    private Integer lowestValue;
    private Integer irritableValue;
    private Integer anxiousValue;
    private String highestNotes;
    private String lowestNotes;
    private String irritableNotes;
    private String anxiousNotes;
}
