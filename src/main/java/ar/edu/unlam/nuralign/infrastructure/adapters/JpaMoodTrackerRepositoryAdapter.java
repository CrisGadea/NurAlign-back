package ar.edu.unlam.nuralign.infrastructure.adapters;

import ar.edu.unlam.nuralign.application.ports.out.MoodTrackerRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.MoodTracker;
import ar.edu.unlam.nuralign.infrastructure.mappers.MoodTrackerMapper;
import ar.edu.unlam.nuralign.infrastructure.repositories.JpaMoodTrackerRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JpaMoodTrackerRepositoryAdapter implements MoodTrackerRepositoryPort {

    private final JpaMoodTrackerRepository repository;

    public JpaMoodTrackerRepositoryAdapter(JpaMoodTrackerRepository repository) {
        this.repository = repository;
    }

    @Override
    public MoodTracker save(MoodTracker moodTracker) {
        return MoodTrackerMapper.toModel(repository.save(MoodTrackerMapper.toEntity(moodTracker)));
    }

    @Override
    public List<MoodTracker> findAll() {
        return repository.findAll().stream()
                .map(MoodTrackerMapper::toModel)
                .toList();
    }

    @Override
    public MoodTracker findById(Long id) {
        return repository.findById(id)
                .map(MoodTrackerMapper::toModel)
                .orElse(null);
    }
}
