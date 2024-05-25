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
import ar.edu.unlam.nuralign.application.usecases.sleepTraker.FindAllSleepTrackersByPatientIdImpl;
import ar.edu.unlam.nuralign.application.usecases.therapist.*;
import ar.edu.unlam.nuralign.application.usecases.sleepTraker.CreateSleepTrakerUseCaseImpl;
import ar.edu.unlam.nuralign.application.usecases.sleepTraker.FindAllSleepTrakersUseCaseImpl;
import ar.edu.unlam.nuralign.application.usecases.sleepTraker.FindSleepTrakerUseCaseImpl;
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
    public SleepTrakerService sleepTrakerService(SleepTrakerRepositoryPort sleepTrakerRepositoryPort) {
        return new SleepTrakerService(
                new CreateSleepTrakerUseCaseImpl(sleepTrakerRepositoryPort),
                new FindSleepTrakerUseCaseImpl(sleepTrakerRepositoryPort),
                new FindAllSleepTrakersUseCaseImpl(sleepTrakerRepositoryPort),
                new FindAllSleepTrackersByPatientIdImpl(sleepTrakerRepositoryPort)
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
    public JpaSleepTrakerRepositoryAdapter jpaSleepTrakerRepositoryAdapter(JpaSleepTrakerRepository adapter) {
        return new JpaSleepTrakerRepositoryAdapter(adapter);
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
