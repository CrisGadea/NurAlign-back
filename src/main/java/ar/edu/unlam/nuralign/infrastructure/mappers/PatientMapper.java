package ar.edu.unlam.nuralign.infrastructure.mappers;

import ar.edu.unlam.nuralign.domain.models.Patient;
import ar.edu.unlam.nuralign.infrastructure.dtos.PatientDto;
import ar.edu.unlam.nuralign.infrastructure.entities.PatientEntity;

public class PatientMapper {

        public static PatientEntity mapToEntity(Patient patient) {
            return new PatientEntity(
                    patient.getName(),
                    patient.getLastName(),
                    patient.getEmail(),
                    patient.getPassword(),
                    patient.getSex(),
                    patient.getBirthdate(),
                    patient.getNickname(),
                    patient.getDni()
                    );
        }

        public static Patient mapToDomain(PatientEntity patientEntity) {
            return new Patient(
                    patientEntity.getId(),
                    patientEntity.getName(),
                    patientEntity.getLastName(),
                    patientEntity.getEmail(),
                    patientEntity.getPassword(),
                    patientEntity.getRegisteredFlag(),
                    patientEntity.getSex(),
                    patientEntity.getDni(),
                    patientEntity.getBirthdate(),
                    patientEntity.getNickname(),
                    patientEntity.getGeneralNotifications(),
                    patientEntity.getCompanionNotifications()
            );
        }

        public static Patient mapToDomain(PatientDto patient) {
            return new Patient(
                    patient.getName(),
                    patient.getLastName(),
                    patient.getEmail(),
                    patient.getPassword(),
                    patient.getPhoneNumber(),
                    patient.getRegisteredFlag(),
                    patient.getSex(),
                    patient.getDocumentNumber(),
                    patient.getBirthdate(),
                    patient.getNickname(),
                    patient.getGeneralNotifications(),
                    patient.getCompanionNotifications()
            );
        }

        public static PatientDto mapToDto(Patient patient) {
            return new PatientDto(
                    patient.getName(),
                    patient.getLastName(),
                    patient.getEmail(),
                    patient.getPassword(),
                    patient.getPhone(),
                    patient.getDni(),
                    patient.getRegisteredFlag(),
                    patient.getBirthdate(),
                    patient.getGeneralNotifications(),
                    patient.getCompanionNotifications(),
                    patient.getNickname(),
                    patient.getSex()
            );
        }
}
