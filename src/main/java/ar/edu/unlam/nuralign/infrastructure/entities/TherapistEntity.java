package ar.edu.unlam.nuralign.infrastructure.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "therapists")
public class TherapistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String medicalLicense;
    private Integer documentNumber;
    private String registeredFlag;
    private Boolean isSuscribed;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @ManyToMany
    @JoinTable(
            name = "patient_therapist",
            joinColumns = @JoinColumn(name = "therapist_id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id")
    )
    private List<PatientEntity> patients;

    public TherapistEntity() {}

    public TherapistEntity(String name, String lastName, String email,  String phoneNumber, String password,
                           Integer documentNumber, String medicalLicense, String registeredFlag) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.medicalLicense = medicalLicense;
        this.documentNumber = documentNumber;
        this.registeredFlag = registeredFlag;
    }

    public TherapistEntity(String name, String lastName, String email,  String phoneNumber, String password,
                           Integer documentNumber, String medicalLicense, String registeredFlag, Boolean isSuscribed) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.medicalLicense = medicalLicense;
        this.documentNumber = documentNumber;
        this.registeredFlag = registeredFlag;
        this.isSuscribed = isSuscribed;
    }

    public TherapistEntity(String name, String lastName, String email,  String phoneNumber, String password,
                           Integer documentNumber, String medicalLicense, String registeredFlag, Boolean isSuscribed, LocalDateTime createdAt) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.medicalLicense = medicalLicense;
        this.documentNumber = documentNumber;
        this.registeredFlag = registeredFlag;
        this.isSuscribed = isSuscribed;
        this.createdAt = createdAt;
    }

}
