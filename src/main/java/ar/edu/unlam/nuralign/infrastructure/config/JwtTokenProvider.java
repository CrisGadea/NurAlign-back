package ar.edu.unlam.nuralign.infrastructure.config;

import ar.edu.unlam.nuralign.domain.models.Therapist;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.WeakKeyException;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
public class JwtTokenProvider {

    private static byte[] SECRET_KEY;

    @PostConstruct
    public void init() {
        SECRET_KEY = generateSecret();
    }

    private byte[] generateSecret() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] key = new byte[32];
        secureRandom.nextBytes(key);
        return key;
    }

    public String generateToken(Therapist user) {
        return Jwts.builder()
                .claim("id", user.getId())
                .claim("email", user.getEmail())
                .claim("name", user.getName())
                .claim("createdAt", user.getCreatedAt())
                .setIssuedAt(new Date())
                .setExpiration(Date.from(Instant.now().plus(1, ChronoUnit.HOURS)))
                .signWith(Keys.hmacShaKeyFor(SECRET_KEY), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(SECRET_KEY))
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (IllegalArgumentException e) {
            throw new WeakKeyException("Invalid token");
        }
    }
}
