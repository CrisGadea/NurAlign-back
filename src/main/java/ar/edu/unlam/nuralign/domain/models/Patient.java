package ar.edu.unlam.nuralign.domain.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Patient extends User {

        private Boolean registeredFlag;

        private List<SleepTracker> sleepTrackers;

        public Patient() {}

        public Patient(Long id, String name, String lastName, String email, String phoneNumber, String password,
                       Boolean registeredFlag, LocalDateTime createdAt, LocalDateTime updatedAt) {
            super(id, name, lastName, email, password, phoneNumber, createdAt, updatedAt);
            this.registeredFlag = registeredFlag;
            this.sleepTrackers = new ArrayList<>();
        }

}
