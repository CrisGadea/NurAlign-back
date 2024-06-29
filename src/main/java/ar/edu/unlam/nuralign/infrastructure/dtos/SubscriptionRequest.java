package ar.edu.unlam.nuralign.infrastructure.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionRequest {
    private Long id;
    private Long therapistId;
    private String name;
    private Double price;
    private String status;
}
