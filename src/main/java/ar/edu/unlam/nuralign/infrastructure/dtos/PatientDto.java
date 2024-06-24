package ar.edu.unlam.nuralign.infrastructure.dtos;

import ar.edu.unlam.nuralign.domain.enums.Sex;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {

        private Long id;

        private String name;

        private String lastName;

        private String email;

        private String password;

        private String phoneNumber;

        private Integer documentNumber;

        private String registeredFlag;

        private LocalDate birthdate;

        private String generalNotifications;

        private String companionNotifications;

        private String nickname;

        private Sex sex;


}
