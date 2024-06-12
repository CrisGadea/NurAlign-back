package ar.edu.unlam.nuralign.domain.models;

import ar.edu.unlam.nuralign.domain.enums.Sex;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
public class Patient extends User {

    private String phone;

    private LocalDate birthdate;

    private Sex sex;

    private String nickname;

    private Integer dni;

    private String generalNotifications;

    private String companionNotifications;

    private String registeredFlag;

    public Patient() {}

    public Patient(Long id, String name, String lastName, String email, String password,
                   Integer dni, String registeredFlag) {
        super(id, name, lastName, email, password);
        this.registeredFlag = registeredFlag;
        this.dni = dni;
    }

    public Patient(Long id, String name, String lastName, String email, String password,
                   String registeredFlag, Sex sex, Integer dni, LocalDate birthdate, String nickname, String generalNotifications,
                   String companionNotifications) {
        super(id, name, lastName, email, password);
        this.birthdate = birthdate;
        this.registeredFlag = registeredFlag;
        this.companionNotifications = companionNotifications;
        this.generalNotifications = generalNotifications;
        this.nickname = nickname;
        this.dni = dni;
        this.sex = sex;
    }

    public Patient(String name, String lastName, String email, String password, String phone,
                   String registeredFlag, Sex sex, Integer dni, LocalDate birthdate, String nickname, String generalNotifications,
                   String companionNotifications) {
        super(name, lastName, email, password);
        this.phone = phone;
        this.registeredFlag = registeredFlag;
        this.sex = sex;
        this.dni = dni;
        this.birthdate = birthdate;
        this.nickname = nickname;
        this.generalNotifications = generalNotifications;
        this.companionNotifications = companionNotifications;
    }

//    public Patient(String name, String lastName, String email, String password, String phoneNumber,
//                   String registeredFlag,
//                   Sex sex, Integer dni, LocalDate birthdate, String nickname, String generalNotifications,
//                   String companionNotifications) {
//        super(name, lastName, email, password);
//        this.phone = phoneNumber;
//        this.registeredFlag = registeredFlag;
//        this.sex = sex;
//        this.dni = dni;
//        this.birthdate = birthdate;
//        this.nickname = nickname;
//        this.generalNotifications = generalNotifications;
//        this.companionNotifications = companionNotifications;
//
//    }
}
