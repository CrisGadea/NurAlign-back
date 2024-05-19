package ar.edu.unlam.nuralign.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    protected Long id;
    protected String name;
    protected String lastName;
    protected String email;
    protected String password;
    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;
}
