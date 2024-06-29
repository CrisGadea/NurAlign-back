package ar.edu.unlam.nuralign.domain.models;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Subscription {
    private Long id;
    private String name;
    private Double price;
    private String status;
    private String paymentMethod;
    private String paymentStatus;
    private String paymentId;
    private String paymentDate;
    private String startDate;
    private String endDate;
    private String createdAt;
    private String updatedAt;
}
