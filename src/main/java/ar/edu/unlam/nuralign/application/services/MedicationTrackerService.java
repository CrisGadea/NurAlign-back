package ar.edu.unlam.nuralign.application.services;

import ar.edu.unlam.nuralign.application.ports.in.medicationTracker.*;
import ar.edu.unlam.nuralign.domain.models.MedicationTracker;
import ar.edu.unlam.nuralign.infrastructure.dtos.MedicationTrackerDto;

import java.time.LocalDate;
import java.util.List;

public class MedicationTrackerService implements FindMedicationTrackerUseCase,
        FindAllMedicationTrackersByEffectiveDateUseCase,
        FindAllMedicationTrackersByPatientIdUseCase,
        FindAllMedicationTrackersUseCase,
        CreateMedicationTrackerUseCase,
        FindAllMedicationTrackerByPatientIdAndEffectiveDateUseCase {

    private final FindMedicationTrackerUseCase findMedicationTrackerUseCase;
    private final FindAllMedicationTrackersByEffectiveDateUseCase findAllMedicationTrackersByEffectiveDateUseCase;
    private final FindAllMedicationTrackersByPatientIdUseCase findAllMedicationTrackersByPatientIdUseCase;
    private final FindAllMedicationTrackersUseCase findAllMedicationTrackersUseCase;
    private final CreateMedicationTrackerUseCase createMedicationTrackerUseCase;
    private final FindAllMedicationTrackerByPatientIdAndEffectiveDateUseCase findAllMedicationTrackersByPatientIdAndEffectiveDateUseCase;

    public MedicationTrackerService(FindMedicationTrackerUseCase findMedicationTrackerUseCase,
                                    FindAllMedicationTrackersByEffectiveDateUseCase findAllMedicationTrackersByEffectiveDateUseCase,
                                    FindAllMedicationTrackersByPatientIdUseCase findAllMedicationTrackersByPatientIdUseCase,
                                    FindAllMedicationTrackersUseCase findAllMedicationTrackersUseCase,
                                    CreateMedicationTrackerUseCase createMedicationTrackerUseCase,
                                    FindAllMedicationTrackerByPatientIdAndEffectiveDateUseCase findAllMedicationTrackersByPatientIdAndEffectiveDateUseCase) {
        this.findMedicationTrackerUseCase = findMedicationTrackerUseCase;
        this.findAllMedicationTrackersByEffectiveDateUseCase = findAllMedicationTrackersByEffectiveDateUseCase;
        this.findAllMedicationTrackersByPatientIdUseCase = findAllMedicationTrackersByPatientIdUseCase;
        this.findAllMedicationTrackersUseCase = findAllMedicationTrackersUseCase;
        this.createMedicationTrackerUseCase = createMedicationTrackerUseCase;
        this.findAllMedicationTrackersByPatientIdAndEffectiveDateUseCase = findAllMedicationTrackersByPatientIdAndEffectiveDateUseCase;
    }

    @Override
    public MedicationTracker findMedicationTracker(Long id) {
        return findMedicationTrackerUseCase.findMedicationTracker(id);
    }

    @Override
    public List<MedicationTracker> findAllMedicationTrackersByEffectiveDate(String effectiveDate) {
        return findAllMedicationTrackersByEffectiveDateUseCase.findAllMedicationTrackersByEffectiveDate(effectiveDate);
    }

    @Override
    public List<MedicationTracker> findAllMedicationTrackersByPatientId(Long patientId) {
        return findAllMedicationTrackersByPatientIdUseCase.findAllMedicationTrackersByPatientId(patientId);
    }

    @Override
    public List<MedicationTracker> findAllMedicationTrackers() {
        return findAllMedicationTrackersUseCase.findAllMedicationTrackers();
    }

    @Override
    public MedicationTracker createMedicationTracker(MedicationTrackerDto medicationTracker) {
        return createMedicationTrackerUseCase.createMedicationTracker(medicationTracker);
    }

    @Override
    public List<MedicationTracker> findAllMedicationTrackerByPatientIdAndEffectiveDate(Long patientId, LocalDate effectiveDate) {
        return findAllMedicationTrackersByPatientIdAndEffectiveDateUseCase.findAllMedicationTrackerByPatientIdAndEffectiveDate(patientId, effectiveDate);
    }
}
