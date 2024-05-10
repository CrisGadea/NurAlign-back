package ar.edu.unlam.nuralign.infrastructure.config;

import ar.edu.unlam.nuralign.application.ports.out.TherapistRepositoryPort;
import ar.edu.unlam.nuralign.application.services.TherapistService;
import ar.edu.unlam.nuralign.application.usecases.therapist.*;
import ar.edu.unlam.nuralign.infrastructure.adapters.JpaTherapistRepositoryAdapter;
import ar.edu.unlam.nuralign.infrastructure.repositories.JpaTherapistRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public TherapistService therapistService(TherapistRepositoryPort therapistRepositoryPort) {
        return new TherapistService(
                new CreateTherapistUseCaseImpl(therapistRepositoryPort),
                new UpdateTherapistUseCaseImpl(therapistRepositoryPort),
                new DeleteTherapistUseCaseImpl(therapistRepositoryPort),
                new FindTherapistUseCaseImpl(therapistRepositoryPort),
                new FindAllTherapistsUseCaseImpl(therapistRepositoryPort)
        );
    }

    @Bean
    public TherapistRepositoryPort therapistRepositoryPort(JpaTherapistRepositoryAdapter jpaTherapistRepositoryAdapter) {
        return jpaTherapistRepositoryAdapter;
    }

    @Bean
    public JpaTherapistRepositoryAdapter jpaTherapistRepositoryAdapter(JpaTherapistRepository adapter) {
        return new JpaTherapistRepositoryAdapter(adapter);
    }


}
