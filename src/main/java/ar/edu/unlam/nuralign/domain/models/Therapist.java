package ar.edu.unlam.nuralign.domain.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Setter
@Getter
public class Therapist{

    private Long id;

    private String name;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String password;

    private Integer documentNumber;

    private String medicalLicense;

    private String registeredFlag;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Therapist() {}

    public Therapist(Long id, String name, String lastName, String email, String phoneNumber, String password,
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Therapist therapist = (Therapist) o;
        return Objects.equals(id, therapist.id);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(id);
        return result;
    }
}
