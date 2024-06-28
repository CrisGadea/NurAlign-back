package ar.edu.unlam.nuralign.infrastructure.entities;
import jakarta.persistence.*;
import lombok.*;

    @Getter
    @Setter
    @Entity
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Table(name="therapy_session")
    public class TherapySessionEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="therapy_session_Id")
        private Long id;
        @Column(name="patient_id")
        private Long patientId;
        @Column(name="therapist_id")
        private Long therapistId;
        @Column(name="effective_date")
        private String effectiveDate;
        @Column(name="session_time")
        private Integer sessionTime;
        @Column(name="pre_session_notes")
        private String preSessionNotes;
        @Column(name="post_session_notes")
        private String postSessionNotes;
        @Column(name="session_feel")
        private String sessionFeel;

    }
