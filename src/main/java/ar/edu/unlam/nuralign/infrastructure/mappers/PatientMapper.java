package ar.edu.unlam.nuralign.infrastructure.mappers;

import ar.edu.unlam.nuralign.domain.models.Patient;
import ar.edu.unlam.nuralign.infrastructure.entities.PatientEntity;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class PatientMapper {

        public static PatientEntity mapToEntity(Patient patient) {
            return new PatientEntity(
                    patient.getName(),
                    patient.getLastName(),
                    patient.getEmail(),
                    patient.getPhoneNumber(),
                    patient.getPassword(),
                    patient.getSleepTrackers() != null ?
                    patient.getSleepTrackers().stream()
                            .map(SleepTrakerMapper::toEntity)
                            .collect(Collectors.toList())
                            : new ArrayList<>(),
                    patient.getRegisteredFlag(),
                    patient.getSex(),
                    patient.getBirthdate(),
                    patient.getNickname(),
                    patient.getGeneralNotifications(),
                    patient.getCompanionNotifications()
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
                    patientEntity.getSex(),
                    patientEntity.getBirthdate(),
                    patientEntity.getNickname(),
                    patientEntity.getGeneralNotifications(),
                    patientEntity.getCompanionNotifications(),
                    patientEntity.getCreatedAt(),
                    patientEntity.getUpdatedAt(),
                    patientEntity.getSleepTrackers() != null ?
                    patientEntity.getSleepTrackers().stream()
                            .map(SleepTrakerMapper::toDomain)
                            .collect(Collectors.toList())
                            : new ArrayList<>()
            );
        }
}
