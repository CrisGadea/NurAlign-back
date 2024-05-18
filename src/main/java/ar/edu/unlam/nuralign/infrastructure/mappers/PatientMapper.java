package ar.edu.unlam.nuralign.infrastructure.mappers;

import ar.edu.unlam.nuralign.domain.models.Patient;
import ar.edu.unlam.nuralign.infrastructure.entities.PatientEntity;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class PatientMapper {

        public static PatientEntity mapToEntity(Patient patient) {
            return new PatientEntity(
                    patient.getId(),
                    patient.getName(),
                    patient.getLastName(),
                    patient.getEmail(),
                    patient.getPhoneNumber(),
                    patient.getPassword(),
                    patient.getSleepTrackers() != null ? patient.getSleepTrackers().stream()
                            .map(SleepTrakerMapper::toEntity)
                            .collect(Collectors.toList()) : new ArrayList<>()
                    );
        }

        public static Patient mapToDomain(PatientEntity patientEntity) {
            return new Patient(
                    patientEntity.getId(),
                    patientEntity.getName(),
                    patientEntity.getLastName(),
                    patientEntity.getEmail(),
                    patientEntity.getPhoneNumber(),
                    patientEntity.getPassword(),
                    patientEntity.getRegisteredFlag(),
                    patientEntity.getCreatedAt(),
                    patientEntity.getUpdatedAt()
            );
        }
}
