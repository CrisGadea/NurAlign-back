package ar.edu.unlam.nuralign.domain.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class SleepTracker {
    private Long patientId;
    private String effectiveDate;
    private Integer sleepHours;
    private Integer bedTime;
    private String negativeThoughtsFlag;
    private String anxiousFlag;
    private String sleepStraightFlag;
    private String sleepNotes;
}
