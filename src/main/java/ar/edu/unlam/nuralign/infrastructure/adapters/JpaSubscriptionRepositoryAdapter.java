package ar.edu.unlam.nuralign.infrastructure.adapters;

import ar.edu.unlam.nuralign.application.ports.out.SubscriptionRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.Subscription;
import ar.edu.unlam.nuralign.infrastructure.mappers.SubscriptionMapper;
import ar.edu.unlam.nuralign.infrastructure.repositories.JpaSubscriptionRepository;

public class JpaSubscriptionRepositoryAdapter implements SubscriptionRepositoryPort {
    private final JpaSubscriptionRepository jpaSubscriptionRepository;

    public JpaSubscriptionRepositoryAdapter(JpaSubscriptionRepository jpaSubscriptionRepository) {
        this.jpaSubscriptionRepository = jpaSubscriptionRepository;
    }

    @Override
    public Subscription generate(Subscription subscription) {
        return SubscriptionMapper.toModel(jpaSubscriptionRepository.save(SubscriptionMapper.toEntity(subscription)));
    }
}
