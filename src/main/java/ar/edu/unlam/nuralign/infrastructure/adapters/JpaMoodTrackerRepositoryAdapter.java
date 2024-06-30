package ar.edu.unlam.nuralign.infrastructure.adapters;

import ar.edu.unlam.nuralign.application.ports.out.MoodTrackerRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.MoodTracker;
import ar.edu.unlam.nuralign.infrastructure.entities.MoodTrackerEntity;
import ar.edu.unlam.nuralign.infrastructure.mappers.MoodTrackerMapper;
import ar.edu.unlam.nuralign.infrastructure.repositories.JpaMoodTrackerRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    @Override
    public List<MoodTracker> findAllByPatientId(Long patientId) {
        return repository.findAllByPatientId(patientId).stream()
                .map(MoodTrackerMapper::toModel)
                .toList();
    }

    @Override
    public MoodTracker findByPatientIdAndEffectiveDate(Long patientId, String effectiveDate) {
        MoodTrackerEntity entity = repository.findByPatientIdAndEffectiveDate(patientId, LocalDate.parse(effectiveDate));
        return MoodTrackerMapper.toModel(entity);
    }

    @Override
    public Optional<MoodTracker> update(MoodTracker moodTracker, Long patientId, String effectiveDate) {
        MoodTrackerEntity entityToSave = repository.findByPatientIdAndEffectiveDate(patientId, LocalDate.parse(effectiveDate));
        if (moodTracker.getAnxiousNotes() != null) entityToSave.setAnxiousNotes(moodTracker.getAnxiousNotes());
        if (moodTracker.getAnxiousValue() != null) entityToSave.setAnxiousValue(moodTracker.getAnxiousValue());
        if (moodTracker.getEffectiveDate() != null) entityToSave.setEffectiveDate(moodTracker.getEffectiveDate());
        if (moodTracker.getHighestNotes() != null) entityToSave.setHighestNotes(moodTracker.getHighestNotes());
        if (moodTracker.getHighestValue() != null) entityToSave.setHighestValue(moodTracker.getHighestValue());
        if (moodTracker.getLowestNotes() != null) entityToSave.setLowestNotes(moodTracker.getLowestNotes());
        if (moodTracker.getLowestValue() != null) entityToSave.setLowestValue(moodTracker.getLowestValue());
        if (moodTracker.getIrritableNotes() != null) entityToSave.setIrritableNotes(moodTracker.getIrritableNotes());
        if (moodTracker.getIrritableValue() != null) entityToSave.setIrritableValue(moodTracker.getIrritableValue());

        return Optional.of(MoodTrackerMapper.toModel(repository.save(entityToSave)));
    }

    public List<MoodTracker> findAllMoodTrackerByPatientIdAndRangeDate(Long patientId, LocalDate fromDate, LocalDate toDate)
    {
        return repository.findAllByPatientIdByRangeDate(patientId, fromDate, toDate).stream().map(MoodTrackerMapper::toModel).toList();
    }
}
