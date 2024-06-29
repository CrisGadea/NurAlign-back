package ar.edu.unlam.nuralign.application.ports.in.subscription;

import ar.edu.unlam.nuralign.domain.models.Subscription;

public interface GenerateSubscriptionUseCase {
    Subscription generate(Subscription subscription);
}
