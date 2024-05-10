package ar.edu.unlam.nuralign.infrastructure.adapters;

import ar.edu.unlam.nuralign.application.ports.out.TherapistRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.Therapist;
import ar.edu.unlam.nuralign.infrastructure.entities.TherapistEntity;
import ar.edu.unlam.nuralign.infrastructure.mappers.TherapistMapper;
import ar.edu.unlam.nuralign.infrastructure.repositories.JpaTherapistRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JpaTherapistRepositoryAdapter implements TherapistRepositoryPort {

    private final JpaTherapistRepository jpaTherapistRepository;

    public JpaTherapistRepositoryAdapter(JpaTherapistRepository jpaTherapistRepository) {
        this.jpaTherapistRepository = jpaTherapistRepository;
    }

    @Override
    public Therapist save(Therapist therapist) {
        TherapistEntity therapistEntity = TherapistMapper.mapToEntity(therapist);
        TherapistEntity savedTherapistEntity = jpaTherapistRepository.save(therapistEntity);
        return TherapistMapper.mapToDomain(savedTherapistEntity);
    }

    @Override
    public Optional<Therapist> update(Therapist therapist, Long id) {
        if (jpaTherapistRepository.existsById(id)) {
            TherapistEntity therapistEntity = TherapistMapper.mapToEntity(therapist);
            therapistEntity.setId(id);
            TherapistEntity updatedTherapistEntity = jpaTherapistRepository.save(therapistEntity);
            return Optional.of(TherapistMapper.mapToDomain(updatedTherapistEntity));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Therapist> findById(Long id) {
        return jpaTherapistRepository.findById(id)
                .map(TherapistMapper::mapToDomain);
    }

    @Override
    public List<Therapist> findAll() {
        return jpaTherapistRepository.findAll()
                .stream()
                .map(TherapistMapper::mapToDomain)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        if (jpaTherapistRepository.existsById(id)) {
            jpaTherapistRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Therapist with id " + id + " does not exist");
        }
    }
}
