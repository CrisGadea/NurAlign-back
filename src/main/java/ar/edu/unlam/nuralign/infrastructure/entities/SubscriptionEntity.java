package ar.edu.unlam.nuralign.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@Table(name = "subscriptions")
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long therapistId;
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