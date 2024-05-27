package ar.edu.unlam.nuralign.infrastructure.adapters;

import ar.edu.unlam.nuralign.application.ports.out.SleepTrackerRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.SleepTracker;
import ar.edu.unlam.nuralign.infrastructure.entities.SleepTrackerEntity;
import ar.edu.unlam.nuralign.infrastructure.mappers.SleepTrackerMapper;
import ar.edu.unlam.nuralign.infrastructure.repositories.JpaSleepTrackerRepository;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JpaSleepTrackerRepositoryAdapter implements SleepTrackerRepositoryPort {
    private final JpaSleepTrackerRepository repository;

    public JpaSleepTrackerRepositoryAdapter(JpaSleepTrackerRepository repository) {
        this.repository = repository;
    }

    @Override
    public SleepTracker save(SleepTracker sleepTracker) {
        SleepTrackerEntity sleepTrackerEntity = SleepTrackerMapper.toEntity(sleepTracker);
        return SleepTrackerMapper.toDomain(repository.save(sleepTrackerEntity));
    }

    @Override
    public Optional<SleepTracker> findById(Long id) {
        return repository.findById(id)
                .map(SleepTrackerMapper::toDomain);
    }

    @Override
    public List<SleepTracker> findAll() {
        List<SleepTrackerEntity> entities = repository.findAll();
        if (entities == null) {
            return Collections.emptyList(); // Devuelve una lista vacía si findAll() devuelve null
        }
        return entities.stream()
                .map(SleepTrackerMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<SleepTracker> findAllByPatientId(Long patientId) {
        List<SleepTrackerEntity> entities = repository.findAllByPatientId(patientId);
        if (entities == null) {
            return Collections.emptyList(); // Devuelve una lista vacía si findAllByPatientId() devuelve null
        }
        return entities.stream()
                .map(SleepTrackerMapper::toDomain)
                .collect(Collectors.toList());
    }

}
