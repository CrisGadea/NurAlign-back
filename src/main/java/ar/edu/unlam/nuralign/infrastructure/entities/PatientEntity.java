package ar.edu.unlam.nuralign.infrastructure.entities;

import ar.edu.unlam.nuralign.domain.enums.Sex;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patient")
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Long id;
    @Column(name = "patient_first_name")
    private String name;
    @Column(name = "patient_last_name")
    private String lastName;
    @Column(name = "patient_email")
    private String email;
    @Column(name = "patient_password")
    private String password;
    private String nickname;
    private Integer dni;
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthdate;
    private Sex sex;
    @Column(name = "general_notifications")
    private String generalNotifications;
    @Column(name = "companion_notifications")
    private String companionNotifications;
    private String registeredFlag;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @OneToMany(mappedBy = "patientId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SleepTrackerEntity> sleepTrackers;

    @OneToMany(mappedBy = "patientId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MedicationEntity> medications;

    public PatientEntity(String name, String lastName, String email, String password,
                         Sex sex, LocalDate birthdate, String nickname, Integer dni) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.sex = sex;
        this.birthdate = birthdate;
        this.nickname = nickname;
        this.dni = dni;
    }
}
