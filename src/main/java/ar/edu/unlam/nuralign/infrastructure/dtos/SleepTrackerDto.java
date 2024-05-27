package ar.edu.unlam.nuralign.infrastructure.dtos;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SleepTrackerDto {
    private Long patientId;
    private LocalDate effectiveDate;
    private Integer sleepHours;
    private String bedTime;
    private String negativeThoughtsFlag;
    private String anxiousFlag;
    private String sleepStraightFlag;
    private String sleepNotes;
}
