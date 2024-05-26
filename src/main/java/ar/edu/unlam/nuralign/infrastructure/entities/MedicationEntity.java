package ar.edu.unlam.nuralign.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@Table(name = "patient_medication")
@NoArgsConstructor
@AllArgsConstructor
public class MedicationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_medication_id")
    private Long id;
    @Column(name = "patient_id")
    private Long patientId;
    @Column(name = "medication_name")
    private String name;
    @Column(name = "medication_grammage")
    private Long grammage;
    @Column(name = "optional_flag")
    private Character flag;

}
