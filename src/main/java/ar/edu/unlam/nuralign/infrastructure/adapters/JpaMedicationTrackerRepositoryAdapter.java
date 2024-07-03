package ar.edu.unlam.nuralign.infrastructure.adapters;

import ar.edu.unlam.nuralign.application.ports.out.MedicationTrackerRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.MedicationTracker;
import ar.edu.unlam.nuralign.infrastructure.entities.MedicationTrackerEntity;
import ar.edu.unlam.nuralign.infrastructure.mappers.MedicationTrackerMapper;
import ar.edu.unlam.nuralign.infrastructure.repositories.JpaMedicationTrackerRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class JpaMedicationTrackerRepositoryAdapter implements MedicationTrackerRepositoryPort {

    private final JpaMedicationTrackerRepository jpaMedicationTrackerRepository;

    public JpaMedicationTrackerRepositoryAdapter(JpaMedicationTrackerRepository jpaMedicationTrackerRepository) {
        this.jpaMedicationTrackerRepository = jpaMedicationTrackerRepository;
    }

    @Override
    public MedicationTracker save(MedicationTracker medicationTracker) {
        return MedicationTrackerMapper.toModel(jpaMedicationTrackerRepository.save(MedicationTrackerMapper.toEntity(medicationTracker)));
    }

    @Override
    public MedicationTracker findById(Long id) {
        return MedicationTrackerMapper.toModel(jpaMedicationTrackerRepository.findById(id).get());
    }

    @Override
    public List<MedicationTracker> findAll() {
        return jpaMedicationTrackerRepository.findAll()
                .stream()
                .map(MedicationTrackerMapper::toModel)
                .toList();
    }

    @Override
    public List<MedicationTracker> findAllByPatientId(Long patientId) {
        return jpaMedicationTrackerRepository.findAllByPatientId(patientId).stream()
                .map(MedicationTrackerMapper::toModel)
                .toList();
    }

    @Override
    public MedicationTracker findByEffectiveDate(LocalDate effectiveDate) {
        return MedicationTrackerMapper.toModel(jpaMedicationTrackerRepository.findByEffectiveDate(effectiveDate));
    }

    @Override
    public MedicationTracker findByPatientIdAndEffectiveDate(Long patientId, LocalDate effectiveDate) {
        return MedicationTrackerMapper.toModel(jpaMedicationTrackerRepository.findByPatientIdAndEffectiveDate(patientId, effectiveDate));
    }

    @Override
    public Optional<MedicationTracker> update(MedicationTracker medicationTracker, Long patientId, LocalDate effectiveDate) {
        if (!jpaMedicationTrackerRepository.existsByPatientIdAndEffectiveDate(patientId, effectiveDate)) {
            return Optional.empty();
        }
        MedicationTrackerEntity entityToUpdate = jpaMedicationTrackerRepository.findByPatientIdAndEffectiveDate(
                patientId, effectiveDate);
        if (medicationTracker.getTakenFlag() != null) {
            entityToUpdate.setTakenFlag(medicationTracker.getTakenFlag());
        }

        return Optional.of(MedicationTrackerMapper.toModel(jpaMedicationTrackerRepository.save(entityToUpdate)));
    }

    public List<MedicationTracker>findAllByMedicationIdAndRangeDate(Long patientId, LocalDate fromDate, LocalDate toDate)
    {
    return jpaMedicationTrackerRepository.findAllByMedicationIdAndRangeDate(patientId, fromDate, toDate).stream().map(MedicationTrackerMapper::toModel).toList();
    }

}
