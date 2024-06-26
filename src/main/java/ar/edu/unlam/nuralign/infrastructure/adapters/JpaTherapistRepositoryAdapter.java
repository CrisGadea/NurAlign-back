package ar.edu.unlam.nuralign.infrastructure.adapters;

import ar.edu.unlam.nuralign.application.ports.out.TherapistRepositoryPort;
import ar.edu.unlam.nuralign.domain.models.Therapist;
import ar.edu.unlam.nuralign.infrastructure.entities.PatientTherapistEntity;
import ar.edu.unlam.nuralign.infrastructure.entities.TherapistEntity;
import ar.edu.unlam.nuralign.infrastructure.exceptions.LoginErrorException;
import ar.edu.unlam.nuralign.infrastructure.mappers.TherapistMapper;
import ar.edu.unlam.nuralign.infrastructure.repositories.JpaPatientTherapistRepository;
import ar.edu.unlam.nuralign.infrastructure.repositories.JpaTherapistRepository;
import ar.edu.unlam.nuralign.infrastructure.utils.CheckPassword;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class JpaTherapistRepositoryAdapter implements TherapistRepositoryPort {

    private final JpaTherapistRepository jpaTherapistRepository;

    private final JpaPatientTherapistRepository jpaPatientTherapistRepository;

    private CheckPassword checkPassword;

    public JpaTherapistRepositoryAdapter(JpaTherapistRepository jpaTherapistRepository,
                                         JpaPatientTherapistRepository jpaPatientTherapistRepository) {
        this.jpaTherapistRepository = jpaTherapistRepository;
        this.jpaPatientTherapistRepository = jpaPatientTherapistRepository;
        this.checkPassword = null;
    }

    @Override
    public Therapist save(Therapist therapist) {
        if (therapist.getDocumentNumber() == null && therapist.getMedicalLicense() == null) {
            therapist.setMedicalLicense("ABC123");
            therapist.setDocumentNumber(12345678);
        }
        this.checkPassword = new CheckPassword(therapist.getPassword());
        TherapistEntity therapistEntity = TherapistMapper.mapToEntity(therapist);
        if (therapist.getRegisteredFlag() == null) therapistEntity.setRegisteredFlag("Y");
        therapistEntity.setCreatedAt(LocalDateTime.now());
        therapistEntity.setUpdatedAt(LocalDateTime.now());
        therapistEntity.setIsSuscribed(false);
        if (therapist.getPassword() != null) therapistEntity.setPassword(this.checkPassword.hashPassword());
        else therapistEntity.setPassword("AJFINWIEGNWIGI5454yhrtdnERH$EH$G");
        TherapistEntity therapistEntitySaved = jpaTherapistRepository.save(therapistEntity);
        if (therapist.getRegisteredFlag().equals("N")) {
            PatientTherapistEntity patientTherapistEntity = new PatientTherapistEntity();
            patientTherapistEntity.setPatientId(therapist.getPatientId());
            patientTherapistEntity.setTherapistId(therapistEntitySaved.getId());
            jpaPatientTherapistRepository.save(patientTherapistEntity);
        }
        return TherapistMapper.mapToDomain(therapistEntitySaved);
    }

    @Override
    public Optional<Therapist> update(Therapist therapist, Long id) {
        if (jpaTherapistRepository.existsById(id)) {
            Optional<TherapistEntity> entityToSave = jpaTherapistRepository.findById(id);
            Optional<TherapistEntity> entityValidated = validateData(therapist, entityToSave);
            TherapistEntity updatedTherapistEntity = jpaTherapistRepository.save(entityValidated.get());
            return Optional.of(TherapistMapper.mapToDomain(updatedTherapistEntity));
        } else {
            return Optional.empty();
        }
    }

    private Optional<TherapistEntity> validateData(Therapist therapist, Optional<TherapistEntity> entityToSave) {
        if (entityToSave.isEmpty()) return Optional.empty();
        if (therapist.getMedicalLicense() != null && !therapist.getMedicalLicense()
                .equals(entityToSave.get().getMedicalLicense()))
            entityToSave.get().setMedicalLicense(therapist.getMedicalLicense());
        if (therapist.getName() != null && !therapist.getName()
                .equals(entityToSave.get().getName())) entityToSave.get().setName(therapist.getName());
        if (therapist.getLastName() != null && !therapist.getLastName()
                .equals(entityToSave.get().getLastName()))
            entityToSave.get().setLastName(therapist.getLastName());
        if (therapist.getEmail() != null && !therapist.getEmail()
                .equals(entityToSave.get().getEmail()))
            entityToSave.get().setEmail(therapist.getEmail());
        if (therapist.getPhoneNumber() != null && !therapist.getPhoneNumber()
                .equals(entityToSave.get().getPhoneNumber()))
            entityToSave.get().setPhoneNumber(therapist.getPhoneNumber());
        if (therapist.getRegisteredFlag() != null && !therapist.getRegisteredFlag()
                .equals(entityToSave.get().getRegisteredFlag()))
            entityToSave.get().setRegisteredFlag(therapist.getRegisteredFlag());
        if (therapist.getDocumentNumber() != null && !therapist.getDocumentNumber()
                .equals(entityToSave.get().getDocumentNumber()))
            entityToSave.get().setDocumentNumber(therapist.getDocumentNumber());
        if (therapist.getIsSuscribed() != null && !therapist.getIsSuscribed()
                .equals(entityToSave.get().getIsSuscribed()))
            entityToSave.get().setIsSuscribed(therapist.getIsSuscribed());
        if (therapist.getPassword() != null && !therapist.getPassword()
                .equals(entityToSave.get().getPassword())){
            this.checkPassword = new CheckPassword(therapist.getPassword());
            entityToSave.get().setPassword(this.checkPassword.hashPassword());
        }
        entityToSave.get().setUpdatedAt(LocalDateTime.now());
        return entityToSave;
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
