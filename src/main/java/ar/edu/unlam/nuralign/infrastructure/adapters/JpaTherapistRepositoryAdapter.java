package ar.edu.unlam.nuralign.infrastructure.adapters;

import ar.edu.unlam.nuralign.application.ports.out.TherapistRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.Therapist;
import ar.edu.unlam.nuralign.infrastructure.entities.TherapistEntity;
import ar.edu.unlam.nuralign.infrastructure.mappers.TherapistMapper;
import ar.edu.unlam.nuralign.infrastructure.repositories.JpaTherapistRepository;
import at.favre.lib.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
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
        therapistEntity.setCreatedAt(LocalDateTime.now());
        therapistEntity.setUpdatedAt(LocalDateTime.now());
        therapistEntity.setPassword(this.hashPassword(therapist.getPassword()));
        return TherapistMapper.mapToDomain(jpaTherapistRepository.save(therapistEntity));
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
    public Boolean deleteById(Long id) {
        jpaTherapistRepository.deleteById(id);
        return jpaTherapistRepository.findById(id).isEmpty();
    }

    private boolean checkPassword(String password, String hashedPassword) {
        BCrypt.Verifyer verifyer = BCrypt.verifyer();
        BCrypt.Result result = verifyer.verify(password.toCharArray(), hashedPassword);
        return result.verified;
    }

    private String hashPassword(String password) {
        BCrypt.Hasher crypt = BCrypt.withDefaults();
        String passwordHashed = crypt.hashToString(12, password.toCharArray());
        return this.checkPassword(password, passwordHashed) ? passwordHashed : null;
    }
}
