package ar.edu.unlam.nuralign.infrastructure.adapters;

import ar.edu.unlam.nuralign.application.ports.out.MedicationRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.Medication;
import ar.edu.unlam.nuralign.infrastructure.mappers.MedicationMapper;
import ar.edu.unlam.nuralign.infrastructure.repositories.JpaMedicationRepository;
import org.springframework.stereotype.Component;

import java.util.List;

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
}
