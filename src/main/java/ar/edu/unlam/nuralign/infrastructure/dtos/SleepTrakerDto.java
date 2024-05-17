package ar.edu.unlam.nuralign.infrastructure.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SleepTrakerDto {
    private Long patientId;
    private LocalDateTime effectiveDate;
    private Integer sleepHours;
    private Integer bedTime;
    private String negativeThoughtsFlag;
    private String anxiousFlag;
    private String sleepStraightFlag;
    private String sleepNotes;
}
