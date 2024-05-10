package ar.edu.unlam.nuralign.domain.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Setter
@Getter
public class Therapist extends User{

    private Integer documentNumber;

    private String medicalLicense;

    private Boolean registeredFlag;

    public Therapist() {}

    public Therapist(Long id, String name, String lastName, String email, String phoneNumber, String password,
                     Integer documentNumber, String medicalLicense, Boolean registeredFlag, LocalDateTime createdAt,
                        LocalDateTime updatedAt) {
        super(id, name, lastName, email, password, phoneNumber, createdAt, updatedAt);
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
