package ar.edu.unlam.nuralign.infrastructure.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TherapistDto {

    private Long id;

    private String name;

    private String lastName;

    private String email;

    private String password;

    private String phoneNumber;

    private Integer documentNumber;

    private String medicalLicense;

    private String registeredFlag;

    private Long patientId;

    private Boolean isSuscribed;

    private String createdAt;

    public TherapistDto(Long id, String name, String lastName, String email, String password, String phoneNumber,
                        Integer documentNumber, String medicalLicense, String registeredFlag) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.documentNumber = documentNumber;
        this.medicalLicense = medicalLicense;
        this.registeredFlag = registeredFlag;
    }

    public TherapistDto(Long id, String name, String lastName, String email, String password, String phoneNumber,
                        Integer documentNumber, String medicalLicense, String registeredFlag, Long patientId) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.documentNumber = documentNumber;
        this.medicalLicense = medicalLicense;
        this.registeredFlag = registeredFlag;
        this.patientId = patientId;
    }

    public TherapistDto(Long id, String name, String lastName, String email, String password, String phoneNumber,
                        Integer documentNumber, String medicalLicense, String registeredFlag, Long patientId, Boolean isSuscribed) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.documentNumber = documentNumber;
        this.medicalLicense = medicalLicense;
        this.registeredFlag = registeredFlag;
        this.patientId = patientId;
        this.isSuscribed = isSuscribed;
    }

    public TherapistDto(Long id, String name, String lastName, String email, String password, String phoneNumber,
                        Integer documentNumber, String medicalLicense, String registeredFlag, Boolean isSuscribed, String createdAt) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.documentNumber = documentNumber;
        this.medicalLicense = medicalLicense;
        this.registeredFlag = registeredFlag;
        this.isSuscribed = isSuscribed;
        this.createdAt = createdAt;
    }
}
