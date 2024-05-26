package ar.edu.unlam.nuralign.infrastructure.config;

import ar.edu.unlam.nuralign.application.ports.out.PatientRepositoryPort;
import ar.edu.unlam.nuralign.application.ports.out.SleepTrakerRepositoryPort;
import ar.edu.unlam.nuralign.application.ports.out.TherapistRepositoryPort;
import ar.edu.unlam.nuralign.application.services.PatientService;
import ar.edu.unlam.nuralign.application.services.SleepTrackerService;
import ar.edu.unlam.nuralign.application.services.TherapistService;
import ar.edu.unlam.nuralign.application.usecases.patient.*;
import ar.edu.unlam.nuralign.application.usecases.sleepTracker.CreateSleepTrackerUseCaseImpl;
import ar.edu.unlam.nuralign.application.usecases.sleepTracker.FindAllSleepTrackersUseCaseImpl;
import ar.edu.unlam.nuralign.application.usecases.sleepTracker.FindSleepTrackerUseCaseImpl;
import ar.edu.unlam.nuralign.application.usecases.therapist.*;
import ar.edu.unlam.nuralign.infrastructure.adapters.JpaPatientRepositoryAdapter;
import ar.edu.unlam.nuralign.infrastructure.adapters.JpaSleepTrakerRepositoryAdapter;
import ar.edu.unlam.nuralign.infrastructure.adapters.JpaTherapistRepositoryAdapter;
import ar.edu.unlam.nuralign.infrastructure.repositories.JpaPatientRepository;
import ar.edu.unlam.nuralign.infrastructure.repositories.JpaSleepTrakerRepository;
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
    public PatientService patientService(PatientRepositoryPort patientRepositoryPort) {
        return new PatientService(
                new CreatePatientUseCaseImpl(patientRepositoryPort),
                new FindPatientUseCaseImpl(patientRepositoryPort),
                new FindAllPatientsUseCaseImpl(patientRepositoryPort),
                new DeletePatientUseCaseImpl(patientRepositoryPort),
                new UpdatePatientUseCaseImpl(patientRepositoryPort)
        );
    }

    @Bean
    public SleepTrackerService sleepTrakerService(SleepTrakerRepositoryPort sleepTrakerRepositoryPort) {
        return new SleepTrackerService(
                new CreateSleepTrackerUseCaseImpl(sleepTrakerRepositoryPort),
                new FindSleepTrackerUseCaseImpl(sleepTrakerRepositoryPort),
                new FindAllSleepTrackersUseCaseImpl(sleepTrakerRepositoryPort)
        );
    }

    @Bean
    public TherapistRepositoryPort therapistRepositoryPort(JpaTherapistRepositoryAdapter jpaTherapistRepositoryAdapter) {
        return jpaTherapistRepositoryAdapter;
    }

    @Bean
    public PatientRepositoryPort patientRepositoryPort(JpaPatientRepositoryAdapter jpaPatientRepositoryAdapter) {
        return jpaPatientRepositoryAdapter;
    }

    @Bean
    public SleepTrakerRepositoryPort sleepTrakerRepositoryPort(JpaSleepTrakerRepositoryAdapter jpaSleepTrakerRepositoryAdapter) {
        return jpaSleepTrakerRepositoryAdapter;
    }

    @Bean
    public JpaTherapistRepositoryAdapter jpaTherapistRepositoryAdapter(JpaTherapistRepository adapter) {
        return new JpaTherapistRepositoryAdapter(adapter);
    }

    @Bean
    public JpaPatientRepositoryAdapter jpaPatientRepositoryAdapter(JpaPatientRepository adapter) {
        return new JpaPatientRepositoryAdapter(adapter);
    }

    @Bean
    public JpaSleepTrakerRepositoryAdapter jpaSleepTrakerRepositoryAdapter(JpaSleepTrakerRepository adapter) {
        return new JpaSleepTrakerRepositoryAdapter(adapter);
    }


}
