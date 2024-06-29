package ar.edu.unlam.nuralign.domain.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TherapistTest {

    @Test
    @DisplayName("Should Return The Created Therapist")
    public void testTherapist() {
        Therapist therapist = new Therapist();
        therapist.setId(1L);
        therapist.setDocumentNumber(12345678);
        therapist.setMedicalLicense("123456");
        therapist.setRegisteredFlag("Y");

        assert therapist.getId() == 1L;
        assert therapist.getDocumentNumber() == 12345678;
        assert therapist.getMedicalLicense().equals("123456");
        assert therapist.getRegisteredFlag().equals("Y");
    }


}
