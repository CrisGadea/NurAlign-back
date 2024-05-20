package ar.edu.unlam.nuralign.domain.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Builder
public class MoodTracker {
    private Long id;
    private Long patientId;
    private LocalDate effectiveDate;
    private String highestValue;
    private String lowestValue;
    private String highestNotes;
    private String lowestNotes;
    private String irritableValue;
    private String irritableNotes;
    private String anxiousValue;
    private String anxiousNotes;
}
