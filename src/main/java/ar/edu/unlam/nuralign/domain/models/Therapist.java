package ar.edu.unlam.nuralign.domain.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
public class Therapist extends User{

    protected String phoneNumber;

    private Integer documentNumber;

    private String medicalLicense;

    private String registeredFlag;

    private Long patientId;

    public Therapist() {}

    public Therapist(Long id, String name, String lastName, String email, String phoneNumber, String password,
                     Integer documentNumber, String medicalLicense, String registeredFlag) {
        super(id, name, lastName, email, password);
        this.documentNumber = documentNumber;
        this.medicalLicense = medicalLicense;
        this.registeredFlag = registeredFlag;
        this.phoneNumber = phoneNumber;
    }

    public Therapist(Long id, String name, String lastName, String email, String phoneNumber, String password,
                     Integer documentNumber, String medicalLicense, String registeredFlag, Long patientId) {
        super(id, name, lastName, email, password);
        this.documentNumber = documentNumber;
        this.medicalLicense = medicalLicense;
        this.registeredFlag = registeredFlag;
        this.phoneNumber = phoneNumber;
        this.patientId = patientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Therapist therapist = (Therapist) o;
        return Objects.equals(getDocumentNumber(), therapist.getDocumentNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getDocumentNumber());
    }
}
