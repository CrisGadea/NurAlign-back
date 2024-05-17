package ar.edu.unlam.nuralign.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "sleep_tracker")
public class SleepTrakerEntity {
    @Id
    private Long id;
    @Column(name = "patient_id")
    private Long patientId;
    @Column(name = "effective_date")
    private LocalDateTime effectiveDate;
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
