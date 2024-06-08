package ar.edu.unlam.nuralign.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="TurnTherapist")
public class TurnTherapistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id_Turn")
    private Long id;
    @Column(name="therapistId")
    private Long therapistId;
    @Column(name="NamePacient")
    private String NamePacient;
    @Column(name="effectiveDate")
    private String effectiveDate;
    @Column(name="TurnTime")
    private String TurnTime;
}
