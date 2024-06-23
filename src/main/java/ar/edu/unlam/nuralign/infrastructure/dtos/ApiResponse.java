package ar.edu.unlam.nuralign.infrastructure.dtos;

public class ApiResponse {
    private String message;
    private int code;
    private String status;

    public ApiResponse(String message, int code, String status) {
        this.message = message;
        this.code = code;
        this.status = status;
    }

    // Getters y setters
}
