package ar.edu.unlam.nuralign.infrastructure.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TherapistDto {

    private String name;

    private String lastName;

    private String email;

    private String phoneNumber;

    private Integer documentNumber;

    private String medicalLicense;

    private String registeredFlag;

    public TherapistDto() {}

    public TherapistDto( String name, String lastName, String email, String phoneNumber,
                     Integer documentNumber, String medicalLicense, String registeredFlag ) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.documentNumber = documentNumber;
        this.medicalLicense = medicalLicense;
        this.registeredFlag = registeredFlag;
    }
}
