package ar.edu.unlam.nuralign.infrastructure.adapters;

import ar.edu.unlam.nuralign.application.ports.out.SleepTrakerRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.SleepTracker;
import ar.edu.unlam.nuralign.infrastructure.entities.SleepTrakerEntity;
import ar.edu.unlam.nuralign.infrastructure.mappers.SleepTrakerMapper;
import ar.edu.unlam.nuralign.infrastructure.repositories.JpaSleepTrakerRepository;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JpaSleepTrakerRepositoryAdapter implements SleepTrakerRepositoryPort {
    private final JpaSleepTrakerRepository repository;

    public JpaSleepTrakerRepositoryAdapter(JpaSleepTrakerRepository repository) {
        this.repository = repository;
    }

    @Override
    public SleepTracker save(SleepTracker sleepTracker) {
        SleepTrakerEntity sleepTrackerEntity = SleepTrakerMapper.toEntity(sleepTracker);
        return SleepTrakerMapper.toDomain(repository.save(sleepTrackerEntity));
    }

    @Override
    public Optional<SleepTracker> findById(Long id) {
        return repository.findById(id)
                .map(SleepTrakerMapper::toDomain);
    }

    @Override
    public List<SleepTracker> findAll() {
        List<SleepTrakerEntity> entities = repository.findAll();
        if (entities == null) {
            return Collections.emptyList(); // Devuelve una lista vacía si findAll() devuelve null
        }
        return entities.stream()
                .map(SleepTrakerMapper::toDomain)
                .collect(Collectors.toList());
    }

}
