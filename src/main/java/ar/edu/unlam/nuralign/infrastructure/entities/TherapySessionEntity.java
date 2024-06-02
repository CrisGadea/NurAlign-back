package ar.edu.unlam.nuralign.infrastructure.entities;
import ar.edu.unlam.nuralign.infrastructure.enums.Confirmation;
import jakarta.persistence.*;
import lombok.*;

    @Getter
    @Setter
    @Entity
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Table(name="TherapySession")
    public class TherapySessionEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="therapysession_Id")
        private Long id;
        @Column(name="patientId")
        private Long patientId;
        @Column(name="therapistId")
        private Long therapistId;
        @Column(name="effectiveDate")
        private String effectiveDate;
        @Column(name="sessionTime")
        private Integer sessionTime;
        @Column(name="preSessionNotes")
        private String preSessionNotes;
        @Column(name="postSessionNotes")
        private String postSessionNotes;
        @Column(name="sessionFeel")
        private String sessionFeel;
        // se creo la carpeta enum para meterlo aca
        @Enumerated(EnumType.STRING)
        @Column(name = "confirmation")
        private Confirmation confirmation;


    }
