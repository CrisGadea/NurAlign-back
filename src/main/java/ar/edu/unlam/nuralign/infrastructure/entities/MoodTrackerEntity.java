package ar.edu.unlam.nuralign.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "mood_tracker")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MoodTrackerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mood_tracker_id")
    private Long id;
    @Column(name = "patient_id")
    private Long patientId;
    @Column(name = "anxious_notes")
    private String anxiousNotes;
    @Column(name = "anxious_value")
    private String anxiousValue;
    @Column(name = "highest_notes")
    private String highestNotes;
    @Column(name = "highest_value")
    private String highestValue;
    @Column(name = "lowest_notes")
    private String lowestNotes;
    @Column(name = "lowest_value")
    private String lowestValue;
    @Column(name = "irritable_notes")
    private String irritableNotes;
    @Column(name = "irritable_value")
    private String irritableValue;
    @Column(name = "effective_date")
    private LocalDate effectiveDate;
}
