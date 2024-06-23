package ar.edu.unlam.nuralign.infrastructure.exceptions;

public class UnauthorizedException extends RuntimeException{
    public UnauthorizedException(String message) {
        super(message);
    }
}
