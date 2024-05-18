package ar.edu.unlam.nuralign.infrastructure.utils;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class CheckPassword {

    private String password;

    public CheckPassword(String password) {
        this.password = password;
    }

    public CheckPassword() {}

    private boolean checkPassword(String password, String hashedPassword) {
        BCrypt.Verifyer verifyer = BCrypt.verifyer();
        BCrypt.Result result = verifyer.verify(password.toCharArray(), hashedPassword);
        return result.verified;
    }

    public final String hashPassword() {
        BCrypt.Hasher crypt = BCrypt.withDefaults();
        String passwordHashed = crypt.hashToString(12, password.toCharArray());
        return this.checkPassword(password, passwordHashed) ? passwordHashed : null;
    }
}
