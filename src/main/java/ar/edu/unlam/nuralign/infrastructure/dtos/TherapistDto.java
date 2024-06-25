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

    private String name;

    private String lastName;

    private String email;

    private String password;

    private String phoneNumber;

    private Integer documentNumber;

    private String medicalLicense;

    private String registeredFlag;

}
