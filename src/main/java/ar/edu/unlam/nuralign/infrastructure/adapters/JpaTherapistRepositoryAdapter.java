package ar.edu.unlam.nuralign.infrastructure.adapters;

import ar.edu.unlam.nuralign.application.ports.out.TherapistRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.Therapist;
import ar.edu.unlam.nuralign.infrastructure.entities.TherapistEntity;
import ar.edu.unlam.nuralign.infrastructure.exceptions.LoginErrorException;
import ar.edu.unlam.nuralign.infrastructure.mappers.TherapistMapper;
import ar.edu.unlam.nuralign.infrastructure.repositories.JpaTherapistRepository;
import ar.edu.unlam.nuralign.infrastructure.utils.CheckPassword;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class JpaTherapistRepositoryAdapter implements TherapistRepositoryPort {

    private final JpaTherapistRepository jpaTherapistRepository;

    private CheckPassword checkPassword;

    public JpaTherapistRepositoryAdapter(JpaTherapistRepository jpaTherapistRepository) {
        this.jpaTherapistRepository = jpaTherapistRepository;
        this.checkPassword = null;
    }

    @Override
    public Therapist save(Therapist therapist) {
        this.checkPassword = new CheckPassword(therapist.getPassword());
        TherapistEntity therapistEntity = TherapistMapper.mapToEntity(therapist);
        if (therapist.getRegisteredFlag() == null) therapistEntity.setRegisteredFlag("Y");
        therapistEntity.setCreatedAt(LocalDateTime.now());
        therapistEntity.setUpdatedAt(LocalDateTime.now());
        therapistEntity.setIsSuscribed(false);
        if (therapist.getPassword() != null) therapistEntity.setPassword(this.checkPassword.hashPassword());
        else therapistEntity.setPassword("AJFINWIEGNWIGI5454yhrtdnERH$EH$G");
        return TherapistMapper.mapToDomain(jpaTherapistRepository.save(therapistEntity));
    }

    @Override
    public Optional<Therapist> update(Therapist therapist, Long id) {
        if (jpaTherapistRepository.existsById(id)) {
            TherapistEntity therapistEntity = TherapistMapper.mapToEntity(therapist);
            therapistEntity.setId(id);
            therapistEntity.setUpdatedAt(LocalDateTime.now());
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
        jpaTherapistRepository.deleteById(id);
        jpaTherapistRepository.findById(id);
    }

    @Override
    public Therapist login(String email, String password) {
        TherapistEntity therapistEntity = jpaTherapistRepository.findByEmail(email);
        this.checkPassword = new CheckPassword();
        if (therapistEntity == null) throw new LoginErrorException("Usuario no registrado");
        if(this.checkPassword.checkPassword(password, therapistEntity.getPassword()))
            return TherapistMapper.mapToDomain(therapistEntity);
        else
            throw new LoginErrorException("Contraseña incorrecta");
    }

}
