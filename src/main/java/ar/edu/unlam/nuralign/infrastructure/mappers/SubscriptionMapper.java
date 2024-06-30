package ar.edu.unlam.nuralign.infrastructure.mappers;

import ar.edu.unlam.nuralign.domain.models.Subscription;
import ar.edu.unlam.nuralign.infrastructure.dtos.SubscriptionRequest;
import ar.edu.unlam.nuralign.infrastructure.entities.SubscriptionEntity;

public class SubscriptionMapper {
    public static SubscriptionEntity toEntity(Subscription subscription) {
        return SubscriptionEntity.builder()
                .id(subscription.getId())
                .name(subscription.getName())
                .price(subscription.getPrice())
                .build();
    }

    public static Subscription toModel(SubscriptionEntity subscriptionEntity) {
        return Subscription.builder()
                .id(subscriptionEntity.getId())
                .name(subscriptionEntity.getName())
                .price(subscriptionEntity.getPrice())
                .build();
    }

    public static Subscription toModel(SubscriptionRequest subscriptionRequest) {
        return Subscription.builder()
                .name(subscriptionRequest.getName())
                .price(subscriptionRequest.getPrice())
                .build();
    }

    public static SubscriptionRequest toRequest(Subscription subscription) {
        return SubscriptionRequest.builder()
                .name(subscription.getName())
                .price(subscription.getPrice())
                .build();
    }

}
