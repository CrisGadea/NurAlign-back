package ar.edu.unlam.nuralign.infrastructure.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class LoginData {
    private String email;
    private String password;
}
