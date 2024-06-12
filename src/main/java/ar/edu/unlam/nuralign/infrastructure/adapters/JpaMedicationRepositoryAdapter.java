package ar.edu.unlam.nuralign.infrastructure.adapters;

import ar.edu.unlam.nuralign.application.ports.out.MedicationRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.Medication;
import ar.edu.unlam.nuralign.infrastructure.entities.MedicationEntity;
import ar.edu.unlam.nuralign.infrastructure.mappers.MedicationMapper;
import ar.edu.unlam.nuralign.infrastructure.repositories.JpaMedicationRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JpaMedicationRepositoryAdapter implements MedicationRepositoryPort {

    private final JpaMedicationRepository repository;

    public JpaMedicationRepositoryAdapter(JpaMedicationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Medication save(Medication medication) {
        return MedicationMapper.toModel(repository.save(MedicationMapper.toEntity(medication)));
    }

    @Override
    public List<Medication> findAll() {
        return repository.findAll().stream()
                .map(MedicationMapper::toModel)
                .toList();
    }

    @Override
    public Medication findById(Long id) {
        return repository.findById(id)
                .map(MedicationMapper::toModel)
                .orElse(null);
    }

    @Override
    public List<Medication> findAllByPatientId(Long patientId) {
        return repository.findAllByPatientId(patientId).stream()
                .map(MedicationMapper::toModel)
                .toList();
    }

    @Override
    public Optional<Medication> updateMedication(Medication medication, Long patientId) {
        MedicationEntity entityForUpdate = repository.findByPatientIdAndMedicationId(patientId, medication.getId());
        if (entityForUpdate != null) {
            if (medication.getGrammage() != null) entityForUpdate.setGrammage(medication.getGrammage());
            if (medication.getFlag() != null) entityForUpdate.setFlag(medication.getFlag());
            if (medication.getName() != null) entityForUpdate.setName(medication.getName());
            return Optional.ofNullable(MedicationMapper.toModel(repository.save(entityForUpdate)));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void deleteMedication(Long id) {
        repository.deleteById(id);
    }
}
