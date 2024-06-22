package ar.edu.unlam.nuralign.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "patient_therapist")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatientTherapistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_therapist_id")
    private Long id;
    @Column(name = "patient_id")
    @JoinColumn(name = "patient_id")
    private Long patientId;
    @Column(name = "therapist_id")
    @JoinColumn(name = "therapist_id")
    private Long therapistId;

}
