package ar.edu.unlam.nuralign.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patients")
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private Integer documentNumber;
    private Boolean registeredFlag;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public PatientEntity(Long id, String name, String lastName, String email, String phoneNumber, String password, Integer documentNumber) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.documentNumber = documentNumber;
    }

}
