package ar.edu.unlam.nuralign.application.services;

import ar.edu.unlam.nuralign.application.ports.in.medicationTracker.*;
import ar.edu.unlam.nuralign.domain.models.MedicationTracker;
import ar.edu.unlam.nuralign.infrastructure.dtos.MedicationTrackerDto;

import java.time.LocalDate;
import java.util.List;

public class MedicationTrackersService implements FindMedicationTrackerUseCase,
        FindMedicationTrackerByEffectiveDateUseCase,
        FindAllMedicationTrackersByPatientIdUseCase,
        FindAllMedicationTrackersUseCase,
        CreateMedicationTrackerUseCase,
        FindMedicationTrackerByPatientIdAndEffectiveDateUseCase {

    private final FindMedicationTrackerUseCase findMedicationTrackerUseCase;
    private final FindMedicationTrackerByEffectiveDateUseCase findMedicationTrackerByEffectiveDateUseCase;
    private final FindAllMedicationTrackersByPatientIdUseCase findAllMedicationTrackersByPatientIdUseCase;
    private final FindAllMedicationTrackersUseCase findAllMedicationTrackersUseCase;
    private final CreateMedicationTrackerUseCase createMedicationTrackerUseCase;
    private final FindMedicationTrackerByPatientIdAndEffectiveDateUseCase findMedicationTrackerByPatientIdAndEffectiveDateUseCase;

    public MedicationTrackersService(FindMedicationTrackerUseCase findMedicationTrackerUseCase,
                                     FindMedicationTrackerByEffectiveDateUseCase findMedicationTrackerByEffectiveDateUseCase,
                                     FindAllMedicationTrackersByPatientIdUseCase findAllMedicationTrackersByPatientIdUseCase,
                                     FindAllMedicationTrackersUseCase findAllMedicationTrackersUseCase,
                                     CreateMedicationTrackerUseCase createMedicationTrackerUseCase,
                                     FindMedicationTrackerByPatientIdAndEffectiveDateUseCase findMedicationTrackerByPatientIdAndEffectiveDateUseCase) {
        this.findMedicationTrackerUseCase = findMedicationTrackerUseCase;
        this.findMedicationTrackerByEffectiveDateUseCase = findMedicationTrackerByEffectiveDateUseCase;
        this.findAllMedicationTrackersByPatientIdUseCase = findAllMedicationTrackersByPatientIdUseCase;
        this.findAllMedicationTrackersUseCase = findAllMedicationTrackersUseCase;
        this.createMedicationTrackerUseCase = createMedicationTrackerUseCase;
        this.findMedicationTrackerByPatientIdAndEffectiveDateUseCase = findMedicationTrackerByPatientIdAndEffectiveDateUseCase;
    }

    @Override
    public MedicationTracker findMedicationTracker(Long id) {
        return findMedicationTrackerUseCase.findMedicationTracker(id);
    }

    @Override
    public MedicationTracker findMedicationTrackerByEffectiveDate(String effectiveDate) {
        return findMedicationTrackerByEffectiveDateUseCase.findMedicationTrackerByEffectiveDate(effectiveDate);
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
    public MedicationTracker findMedicationTrackerByPatientIdAndEffectiveDate(Long patientId, LocalDate effectiveDate) {
        return findMedicationTrackerByPatientIdAndEffectiveDateUseCase.findMedicationTrackerByPatientIdAndEffectiveDate(patientId, effectiveDate);
    }

}
