package ar.edu.unlam.nuralign.infrastructure.adapters;

import ar.edu.unlam.nuralign.application.ports.out.MedicationTrackerRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.MedicationTracker;
import ar.edu.unlam.nuralign.infrastructure.mappers.MedicationTrackerMapper;
import ar.edu.unlam.nuralign.infrastructure.repositories.JpaMedicationTrackerRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

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
        return jpaMedicationTrackerRepository.findAllByPatientId(patientId)
                .stream()
                .map(MedicationTrackerMapper::toModel)
                .toList();
    }

    @Override
    public List<MedicationTracker> findAllByEffectiveDate(LocalDate effectiveDate) {
        return jpaMedicationTrackerRepository.findAllByEffectiveDate(effectiveDate)
                .stream()
                .map(MedicationTrackerMapper::toModel)
                .toList();
    }

    @Override
    public List<MedicationTracker> findAllByPatientIdAndEffectiveDate(Long patientId, LocalDate effectiveDate) {
        return jpaMedicationTrackerRepository.findAllByPatientIdAndEffectiveDate(patientId, effectiveDate)
                .stream()
                .map(MedicationTrackerMapper::toModel)
                .toList();
    }

}
