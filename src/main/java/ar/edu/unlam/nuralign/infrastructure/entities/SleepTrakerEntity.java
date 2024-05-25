package ar.edu.unlam.nuralign.infrastructure.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "sleep_tracker")
public class SleepTrakerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sleep_tracker_id")
    private Long id;
    @Column(name = "patient_id")
    private Long patientId;
    @Column(name = "effective_date")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate effectiveDate;
    @Column(name = "sleep_hours")
    private Integer sleepHours;
    @Column(name = "bed_time")
    private Integer bedTime;
    @Column(name = "negative_thoughts_flag")
    private String negativeThoughtsFlag;
    @Column(name = "anxious_flag")
    private String anxiousFlag;
    @Column(name = "sleep_straight_flag")
    private String sleepStraightFlag;
    @Column(name = "sleep_notes")
    private String sleepNotes;
}
