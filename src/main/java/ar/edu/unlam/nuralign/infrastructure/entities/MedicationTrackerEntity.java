package ar.edu.unlam.nuralign.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "medication_tracker")
public class MedicationTrackerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medication_tracker_id")
    private Long id;
    @Column(name = "patient_medication_id")
    private Long patientId;
    @Column(name = "effective_date")
    private LocalDate effectiveDate;
    @Column(name = "taken_flag")
    private Character takenFlag;
}
