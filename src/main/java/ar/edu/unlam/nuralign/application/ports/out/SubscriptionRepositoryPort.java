package ar.edu.unlam.nuralign.application.ports.out;

import ar.edu.unlam.nuralign.domain.models.Subscription;

public interface SubscriptionRepositoryPort {
    Subscription generate(Subscription subscription);
}
