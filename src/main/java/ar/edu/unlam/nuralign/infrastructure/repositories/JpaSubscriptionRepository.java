package ar.edu.unlam.nuralign.infrastructure.repositories;

import ar.edu.unlam.nuralign.infrastructure.entities.SubscriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaSubscriptionRepository extends JpaRepository<SubscriptionEntity, Long> {
}