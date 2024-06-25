package ar.edu.unlam.nuralign.infrastructure.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

}
