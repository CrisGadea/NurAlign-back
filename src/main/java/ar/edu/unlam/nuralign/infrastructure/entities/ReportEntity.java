package ar.edu.unlam.nuralign.infrastructure.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="report")
@Entity
public class ReportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private Long id;

    @Column(name = "therapist_id")
    private Long therapistId;

    @Column(name = "initial_date")
    private LocalDate initialDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "effective_date")
    private LocalDate effectiveDate;

    @Column(name = "mood_flag")
    private Boolean moodFlag;

    @Column(name = "sleep_flag")
    private Boolean sleepFlag;

    @Column(name = "therapy_flag")
    private Boolean therapyFlag;

    @Column(name = "medication_flag")
    private Boolean medicationFlag;

    @Column(name = "patient_name")
    private String patientName;
}
