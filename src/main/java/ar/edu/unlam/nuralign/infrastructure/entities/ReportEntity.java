/*package ar.edu.unlam.nuralign.infrastructure.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_Id")
    private Long Id;
    @Column(name = "therapist_id")
    @JoinColumn(name = "therapist_id")
    private Long therapistId;
    @Column(name = "initialDate")
    private LocalDate initialDate;
    @Column (name = "endDate")
    LocalDate endDate;
    @Column(name = "effective_date")
    private LocalDate effectiveDate;
    @Column(name="mooodFlag")
   private Boolean mooodFlag;
    @Column(name="sleepFlag")
    private Boolean sleepFlag;
    @Column(name="therapyFlag")
    private Boolean therapyFlag;
    @Column(name="MedicationFlag")
    private Boolean MedicationFlag;
    @Column(name="PatientName")
    private String PatientName;

}
*/