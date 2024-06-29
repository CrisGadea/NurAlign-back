package ar.edu.unlam.nuralign.application.services;

import ar.edu.unlam.nuralign.application.ports.in.subscription.GenerateSubscriptionUseCase;
import ar.edu.unlam.nuralign.domain.models.Subscription;

public class SubscriptionService implements GenerateSubscriptionUseCase {
    private final GenerateSubscriptionUseCase generateSubscriptionUseCase;

    public SubscriptionService(GenerateSubscriptionUseCase generateSubscriptionUseCase) {
        this.generateSubscriptionUseCase = generateSubscriptionUseCase;
    }

    @Override
    public Subscription generate(Subscription subscription) {
        return generateSubscriptionUseCase.generate(subscription);
    }
}
