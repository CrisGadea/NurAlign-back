package ar.edu.unlam.nuralign.domain.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class Patient extends User {

        private Integer documentNumber;

        private Boolean registeredFlag;

        public Patient() {
        }

        public Patient(Long id, String name, String lastName, String email, String phoneNumber, String password,
                       Integer documentNumber, Boolean registeredFlag, LocalDateTime createdAt, LocalDateTime updatedAt) {
            super(id, name, lastName, email, password, phoneNumber, createdAt, updatedAt);
            this.documentNumber = documentNumber;
            this.registeredFlag = registeredFlag;
        }

}
