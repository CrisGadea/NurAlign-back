package ar.edu.unlam.nuralign.infrastructure.config;

import ar.edu.unlam.nuralign.application.ports.out.*;
import ar.edu.unlam.nuralign.application.services.*;
import ar.edu.unlam.nuralign.application.usecases.medication.CreateMedicationUseCaseImpl;
import ar.edu.unlam.nuralign.application.usecases.medication.FindAllMedicationsUseCaseImpl;
import ar.edu.unlam.nuralign.application.usecases.medication.FindMedicationsByPatientIdUseCaseImpl;
import ar.edu.unlam.nuralign.application.usecases.medication.FindMedicationUseCaseImpl;
import ar.edu.unlam.nuralign.application.usecases.moodTracker.CreateMoodTrackerUseCaseImpl;
import ar.edu.unlam.nuralign.application.usecases.moodTracker.FindAllMoodTrackersUseCaseImpl;
import ar.edu.unlam.nuralign.application.usecases.moodTracker.FindMoodTrackerUseCaseImpl;
import ar.edu.unlam.nuralign.application.usecases.patient.*;
import ar.edu.unlam.nuralign.application.usecases.sleepTracker.FindAllSleepTrackersByPatientIdImpl;
import ar.edu.unlam.nuralign.application.usecases.therapist.*;
import ar.edu.unlam.nuralign.application.usecases.sleepTracker.CreateSleepTrackerUseCaseImpl;
import ar.edu.unlam.nuralign.application.usecases.sleepTracker.FindAllSleepTrackersUseCaseImpl;
import ar.edu.unlam.nuralign.application.usecases.sleepTracker.FindSleepTrackerUseCaseImpl;
import ar.edu.unlam.nuralign.infrastructure.adapters.*;
import ar.edu.unlam.nuralign.infrastructure.repositories.*;
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
    public MoodTrackerService moodTrackerService(MoodTrackerRepositoryPort moodTrackerRepositoryPort) {
        return new MoodTrackerService(
                new CreateMoodTrackerUseCaseImpl(moodTrackerRepositoryPort),
                new FindMoodTrackerUseCaseImpl(moodTrackerRepositoryPort),
                new FindAllMoodTrackersUseCaseImpl(moodTrackerRepositoryPort)
        );
    }

    @Bean
    public MedicationsService medicationService(MedicationRepositoryPort medicationRepositoryPort) {
        return new MedicationsService(
                new CreateMedicationUseCaseImpl(medicationRepositoryPort),
                new FindMedicationUseCaseImpl(medicationRepositoryPort),
                new FindAllMedicationsUseCaseImpl(medicationRepositoryPort),
                new FindMedicationsByPatientIdUseCaseImpl(medicationRepositoryPort)
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
    public SleepTrackerService sleepTrackerService(SleepTrackerRepositoryPort sleepTrackerRepositoryPort) {
        return new SleepTrackerService(
                new CreateSleepTrackerUseCaseImpl(sleepTrackerRepositoryPort),
                new FindSleepTrackerUseCaseImpl(sleepTrackerRepositoryPort),
                new FindAllSleepTrackersUseCaseImpl(sleepTrackerRepositoryPort),
                new FindAllSleepTrackersByPatientIdImpl(sleepTrackerRepositoryPort)
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
    public SleepTrackerRepositoryPort sleepTrackerRepositoryPort(JpaSleepTrackerRepositoryAdapter jpaSleepTrackerRepositoryAdapter) {
        return jpaSleepTrackerRepositoryAdapter;
    }

    @Bean
    public MoodTrackerRepositoryPort moodTrackerRepositoryPort(JpaMoodTrackerRepositoryAdapter jpaMoodTrackerRepositoryAdapter) {
        return jpaMoodTrackerRepositoryAdapter;
    }

    @Bean
    public MedicationRepositoryPort medicationRepositoryPort(JpaMedicationRepositoryAdapter jpaMedicationRepositoryAdapter) {
        return jpaMedicationRepositoryAdapter;
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
    public JpaSleepTrackerRepositoryAdapter jpaSleepTrackerRepositoryAdapter(JpaSleepTrackerRepository adapter) {
        return new JpaSleepTrackerRepositoryAdapter(adapter);
    }

    @Bean
    public JpaMoodTrackerRepositoryAdapter jpaMoodTrackerRepositoryAdapter(JpaMoodTrackerRepository adapter) {
        return new JpaMoodTrackerRepositoryAdapter(adapter);
    }

    @Bean
    public JpaMedicationRepositoryAdapter jpaMedicationRepositoryAdapter(JpaMedicationRepository adapter) {
        return new JpaMedicationRepositoryAdapter(adapter);
    }




}
