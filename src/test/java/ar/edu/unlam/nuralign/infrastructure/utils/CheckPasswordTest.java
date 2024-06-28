package ar.edu.unlam.nuralign.infrastructure.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CheckPasswordTest {
    @DisplayName("Should verify hashed password correctly")
    @Test
    void shouldVerifyHashedPasswordCorrectly() {
        CheckPassword checkPassword = new CheckPassword("password123");
        String hashedPassword = checkPassword.hashPassword();
        assertTrue(checkPassword.checkPassword("password123", hashedPassword));
    }

    @DisplayName("Should not verify incorrect password")
    @Test
    void shouldNotVerifyIncorrectPassword() {
        CheckPassword checkPassword = new CheckPassword("password123");
        String hashedPassword = checkPassword.hashPassword();
        assertFalse(checkPassword.checkPassword("wrongpassword", hashedPassword));
    }

    @DisplayName("Should return null when hashing null password")
    @Test
    void shouldReturnNullWhenHashingNullPassword() {
        CheckPassword checkPassword = new CheckPassword(null);
        assertNull(checkPassword.hashPassword());
    }

    @DisplayName("Should not verify null password")
    @Test
    void shouldNotVerifyNullPassword() {
        CheckPassword checkPassword = new CheckPassword("password123");
        String hashedPassword = checkPassword.hashPassword();
        assertFalse(checkPassword.checkPassword(null, hashedPassword));
    }
}
