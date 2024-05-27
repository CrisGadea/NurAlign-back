package ar.edu.unlam.nuralign.domain.models;

import ar.edu.unlam.nuralign.domain.enums.Sex;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
public class Patient extends User {

    private LocalDate birthdate;

    private Sex sex;

    private String nickname;

    private String dni;

    private String generalNotifications;

    private String companionNotifications;

    private Boolean registeredFlag;

    public Patient() {}

    public Patient(Long id, String name, String lastName, String email, String password,
                   String dni, Boolean registeredFlag, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(id, name, lastName, email, password, createdAt, updatedAt);
        this.registeredFlag = registeredFlag;
        this.dni = dni;
    }

    public Patient(Long id, String name, String lastName, String email, String password,
                   Boolean registeredFlag, Sex sex, String dni, LocalDate birthdate, String nickname, String generalNotifications,
                   String companionNotifications, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(id, name, lastName, email, password, createdAt, updatedAt);
        this.birthdate = birthdate;
        this.registeredFlag = registeredFlag;
        this.companionNotifications = companionNotifications;
        this.generalNotifications = generalNotifications;
        this.nickname = nickname;
        this.dni = dni;
        this.sex = sex;
    }
}
