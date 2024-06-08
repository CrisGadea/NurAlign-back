package ar.edu.unlam.nuralign.infrastructure.config;

import ar.edu.unlam.nuralign.application.ports.out.*;
import ar.edu.unlam.nuralign.application.services.*;
import ar.edu.unlam.nuralign.application.usecases.medication.CreateMedicationUseCaseImpl;
import ar.edu.unlam.nuralign.application.usecases.medication.FindAllMedicationsUseCaseImpl;
import ar.edu.unlam.nuralign.application.usecases.medication.FindMedicationsByPatientIdUseCaseImpl;
import ar.edu.unlam.nuralign.application.usecases.medication.FindMedicationUseCaseImpl;
import ar.edu.unlam.nuralign.application.usecases.medicationTracker.*;
import ar.edu.unlam.nuralign.application.usecases.moodTracker.CreateMoodTrackerUseCaseImpl;
import ar.edu.unlam.nuralign.application.usecases.moodTracker.FindAllMoodTrackersByPatientIdAndEffectiveDateUseCaseImpl;
import ar.edu.unlam.nuralign.application.usecases.moodTracker.FindAllMoodTrackersUseCaseImpl;
import ar.edu.unlam.nuralign.application.usecases.moodTracker.FindMoodTrackerUseCaseImpl;
import ar.edu.unlam.nuralign.application.usecases.patient.*;
import ar.edu.unlam.nuralign.application.usecases.sleepTracker.*;
import ar.edu.unlam.nuralign.application.usecases.therapist.*;
import ar.edu.unlam.nuralign.application.usecases.therapySession.CreateTherapySessionUseCaseImpl;
import ar.edu.unlam.nuralign.application.usecases.therapySession.FindAllTherapySessionByPatientIdUseCaseImpl;
import ar.edu.unlam.nuralign.application.usecases.therapySession.FindAllTherapySessionByTherapistIdUseCaseImpl;
import ar.edu.unlam.nuralign.application.usecases.turnTherapist.CreateTurnTherapistImpl;
import ar.edu.unlam.nuralign.application.usecases.turnTherapist.DeleteTurnTherapistImpl;
import ar.edu.unlam.nuralign.application.usecases.turnTherapist.FindAllByTherapistTurnTherapistImpl;
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
                new FindAllMoodTrackersUseCaseImpl(moodTrackerRepositoryPort),
                new FindAllMoodTrackersByPatientIdAndEffectiveDateUseCaseImpl(moodTrackerRepositoryPort)
        );
    }

    @Bean
    public MedicationTrackerService medicationTrackerService(MedicationTrackerRepositoryPort medicationTrackerRepositoryPort) {
        return new MedicationTrackerService(
                new FindMedicationTrackerUseCaseImpl(medicationTrackerRepositoryPort),
                new FindAllMedicationTrackersByEffectiveDateUseCaseImpl(medicationTrackerRepositoryPort),
                new FindAllMedicationTrackersByPatientIdUseCaseImpl(medicationTrackerRepositoryPort),
                new FindAllMedicationTrackersUseCaseImpl(medicationTrackerRepositoryPort),
                new CreateMedicationTrackerUseCaseImpl(medicationTrackerRepositoryPort),
                new FindAllMedicationTrackerByPatientIdAndEffectiveDateUseCaseImpl(medicationTrackerRepositoryPort)
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
                new FindAllSleepTrackersByPatientIdImpl(sleepTrackerRepositoryPort),
                new FindAllSleepTrackersByPatientIdAndEffectiveDateImpl(sleepTrackerRepositoryPort)
        );
    }

    @Bean
    public TherapySessionService therapySessionService(TherapySessionRepositoryPort therapySessionRepositoryPort)
    {
        return new TherapySessionService(
                new CreateTherapySessionUseCaseImpl(therapySessionRepositoryPort),
                new FindAllTherapySessionByPatientIdUseCaseImpl(therapySessionRepositoryPort),
                new FindAllTherapySessionByTherapistIdUseCaseImpl(therapySessionRepositoryPort)
        );

    }

    @Bean
    public TherapySessionRepositoryPort therapySessionRepositoryPort( JpaTherapySessionAdapter jpaTherapySessionAdapter)
    {
        return jpaTherapySessionAdapter;
    }
    @Bean
    public JpaTherapySessionAdapter therapySessionAdapter(JpaTherapySessionRepository adapter)
    {
        return new JpaTherapySessionAdapter(adapter);
    }


@Bean
public TurnTherapistService turnTherapistService(TurnTherapistReposirotyPort turnTherapistReposirotyPort)
{
    return new TurnTherapistService(
            new CreateTurnTherapistImpl(turnTherapistReposirotyPort),
            new FindAllByTherapistTurnTherapistImpl(turnTherapistReposirotyPort),
            new DeleteTurnTherapistImpl(turnTherapistReposirotyPort)

    );

}

@Bean
public TurnTherapistReposirotyPort turnTherapistReposirotyPort(JpaTurnTherapistRepositoryAdapter jpaTurnTherapistRepositoryAdapter)
{
    return jpaTurnTherapistRepositoryAdapter;
}
@Bean
public JpaTurnTherapistRepositoryAdapter turnTherapistRepositoryAdapter(JpaTurnTherapistRepository adapter)
{
    return new JpaTurnTherapistRepositoryAdapter(adapter);

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
    public MedicationTrackerRepositoryPort medicationTrackerRepositoryPort(JpaMedicationTrackerRepositoryAdapter jpaMedicationTrackerRepositoryAdapter) {
        return jpaMedicationTrackerRepositoryAdapter;
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

    @Bean
    public JpaMedicationTrackerRepositoryAdapter jpaMedicationTrackerRepositoryAdapter(JpaMedicationTrackerRepository adapter) {
        return new JpaMedicationTrackerRepositoryAdapter(adapter);
    }


}
