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
    private String phoneNumber;
    private String nickname;
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthdate;
    private Sex sex;
    @Column(name = "general_notifications")
    private String generalNotifications;
    @Column(name = "companion_notifications")
    private String companionNotifications;
    private Boolean registeredFlag;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @OneToMany(mappedBy = "patientId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SleepTrakerEntity> sleepTrackers;

    public PatientEntity( String name, String lastName, String email, String phoneNumber, String password,
                         LocalDate birthdate, List<SleepTrakerEntity> sleepTrackers) {

        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.sleepTrackers = sleepTrackers;
        this.birthdate = birthdate;
    }

    public PatientEntity(String name, String lastName, String email, String phoneNumber, String password,
                         List<SleepTrakerEntity> sleepTrackers, Boolean registeredFlag, Sex sex, LocalDate birthdate,
                         String nickname, String generalNotifications, String companionNotifications) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.registeredFlag = registeredFlag;
        this.sex = sex;
        this.birthdate = birthdate;
        this.nickname = nickname;
        this.generalNotifications = generalNotifications;
        this.companionNotifications = companionNotifications;
        this.sleepTrackers = sleepTrackers;
    }
}
