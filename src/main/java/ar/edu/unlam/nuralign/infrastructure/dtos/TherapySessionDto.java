package ar.edu.unlam.nuralign.infrastructure.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class TherapySessionDto {

        private Long id;

        private Long patientId;

        private Long therapistId;

        private String effectiveDate;

        private Integer sessionTime;

        private String preSessionNotes;

        private String postSessionNotes;

        private String sessionFeel;

}
