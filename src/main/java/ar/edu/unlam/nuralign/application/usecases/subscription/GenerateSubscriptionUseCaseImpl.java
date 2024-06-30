package ar.edu.unlam.nuralign.application.usecases.subscription;

import ar.edu.unlam.nuralign.application.ports.in.subscription.GenerateSubscriptionUseCase;
import ar.edu.unlam.nuralign.application.ports.out.SubscriptionRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.Subscription;

public class GenerateSubscriptionUseCaseImpl implements GenerateSubscriptionUseCase {
    private final SubscriptionRepositoryPort repository;

    public GenerateSubscriptionUseCaseImpl(SubscriptionRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Subscription generate(Subscription subscription) {
        return repository.generate(subscription);
    }
}
