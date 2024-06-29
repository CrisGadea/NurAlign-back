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

//    public String crearSuscripcion(Subscription request) throws MPException {
//        Preference preference = new Preference();
//
//        PreferenceItem item = new PreferenceItem();
//        item.setTitle("Suscripción a NurAlign")
//                .setQuantity(1)
//                .setCurrencyId("ARS")  // Cambiar según la moneda de tu país
//                .setUnitPrice(request.getPrice());  // Monto de la suscripción
//
//        preference.appendItem(item);
//       // "http://nuralign.com/pago-exitoso",
//         //       "http://nuralign.com/pago-pendiente",
//           //     "http://nuralign.com/pago-fallido"
//
//        PreferenceBackUrls backUrls = new PreferenceBackUrls();
//                backUrls.getSuccess();
//        preference.setBackUrls(backUrls);
//        preference.setAutoReturn(Preference.AutoReturn.approved);
//
//        // Guarda la preferencia en MercadoPago
//        preference.save();
//
//        return preference.getId();
//    }
}
