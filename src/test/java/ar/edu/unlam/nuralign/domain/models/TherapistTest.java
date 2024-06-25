package ar.edu.unlam.nuralign.domain.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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

    @Test
    @DisplayName("Should validate therapist equality based on therapistId")
    public void shouldValidateTherapistEqualityBasedOnTherapistId() {
        Therapist therapist1 = new Therapist();
        therapist1.setDocumentNumber(1);

        Therapist therapist2 = new Therapist();
        therapist2.setDocumentNumber(1);

        assertEquals(therapist1, therapist2);
    }

    @Test
    @DisplayName("Should validate therapist inequality based on different therapistId")
    public void shouldValidateTherapistInequalityBasedOnDifferentTherapistId() {
        Therapist therapist1 = new Therapist();
        therapist1.setDocumentNumber(1);

        Therapist therapist2 = new Therapist();
        therapist2.setDocumentNumber(2);

        assertNotEquals(therapist1, therapist2);
    }

    @Test
    @DisplayName("Should validate therapist inequality with null")
    public void shouldValidateTherapistInequalityWithNull() {
        Therapist therapist = new Therapist();
        therapist.setDocumentNumber(1);

        assertNotEquals(therapist, null);
    }

    @Test
    @DisplayName("Should validate therapist inequality with different class")
    public void shouldValidateTherapistInequalityWithDifferentClass() {
        Therapist therapist = new Therapist();
        therapist.setId(1L);

        assertNotEquals(therapist, new Object());
    }
}
