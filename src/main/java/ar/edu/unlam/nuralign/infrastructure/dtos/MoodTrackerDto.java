package ar.edu.unlam.nuralign.infrastructure.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class MoodTrackerDto {
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
