package ar.edu.unlam.nuralign.infrastructure.adapters;

import ar.edu.unlam.nuralign.application.ports.out.SleepTrackerRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.SleepTracker;
import ar.edu.unlam.nuralign.infrastructure.entities.SleepTrackerEntity;
import ar.edu.unlam.nuralign.infrastructure.mappers.SleepTrackerMapper;
import ar.edu.unlam.nuralign.infrastructure.repositories.JpaSleepTrackerRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
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
        return entities.stream()
                .map(SleepTrackerMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<SleepTracker> findAllByPatientId(Long patientId) {
        List<SleepTrackerEntity> entities = repository.findAllByPatientId(patientId);
        return entities == null ? Collections.emptyList(): entities.stream()
                .map(SleepTrackerMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public SleepTracker findSleepTrackerByPatientIdAndEffectiveDate(Long patientId, String effectiveDate) {
        return SleepTrackerMapper.toDomain(repository.findByPatientIdAndEffectiveDate(patientId, LocalDate.parse(effectiveDate)));
    }

    @Override
    public Optional<SleepTracker> update(SleepTracker sleepTracker, Long patientId, String effectiveDate) {
        SleepTrackerEntity sleepTrackerEntity = repository.findByPatientIdAndEffectiveDate(patientId, LocalDate.parse(effectiveDate));
        if (sleepTrackerEntity == null) {
            return Optional.empty();
        }
        if (sleepTracker.getSleepHours() != null) {
            sleepTrackerEntity.setSleepHours(sleepTracker.getSleepHours());
        }

        if (sleepTracker.getSleepNotes() != null) {
            sleepTrackerEntity.setSleepNotes(sleepTracker.getSleepNotes());
        }

        if(sleepTracker.getAnxiousFlag() != null) {
            sleepTrackerEntity.setAnxiousFlag(sleepTracker.getAnxiousFlag());
        }

        if(sleepTracker.getBedTime() != null) {
            sleepTrackerEntity.setBedTime(sleepTracker.getBedTime());
        }

        if(sleepTracker.getSleepStraightFlag() != null) {
            sleepTrackerEntity.setSleepStraightFlag(sleepTracker.getSleepStraightFlag());
        }

        if(sleepTracker.getEffectiveDate() != null) {
            sleepTrackerEntity.setEffectiveDate(sleepTracker.getEffectiveDate());
        }

        if (sleepTracker.getNegativeThoughtsFlag() != null) {
            sleepTrackerEntity.setNegativeThoughtsFlag(sleepTracker.getNegativeThoughtsFlag());
        }

        return Optional.ofNullable(SleepTrackerMapper.toDomain(repository.save(sleepTrackerEntity)));
    }

}
