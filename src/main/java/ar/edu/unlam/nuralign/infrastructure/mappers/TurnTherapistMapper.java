package ar.edu.unlam.nuralign.infrastructure.mappers;

import ar.edu.unlam.nuralign.domain.models.TurnTherapist;
import ar.edu.unlam.nuralign.infrastructure.dtos.TurnTherapistDto;
import ar.edu.unlam.nuralign.infrastructure.entities.TurnTherapistEntity;

public class TurnTherapistMapper {


//model to entity
    public static TurnTherapistEntity toEntity(TurnTherapist turnTherapist)
    {

      return TurnTherapistEntity.builder().id(turnTherapist.getId())
              .therapistId(turnTherapist.getTherapistId())
              .effectiveDate(turnTherapist.getEffectiveDate())
              .TurnTime(turnTherapist.getTurnTime())
              .NamePacient(turnTherapist.getNamePacient()).build();
    }

    //model to dto
    public static TurnTherapistDto toDto(TurnTherapist turnTherapist)
    {


        return   TurnTherapistDto.builder().id(turnTherapist.getId())
            .therapistId(turnTherapist.getTherapistId())
            .effectiveDate(turnTherapist.getEffectiveDate())
            .TurnTime(turnTherapist.getTurnTime())
            .NamePacient(turnTherapist.getNamePacient()).build();
    }
    //entity to model
    public static TurnTherapist toModel (TurnTherapistEntity turnTherapistEntity)
    {
        return TurnTherapist.builder().id(turnTherapistEntity.getId())
                .therapistId(turnTherapistEntity.getTherapistId())
                .effectiveDate(turnTherapistEntity.getEffectiveDate())
                .TurnTime(turnTherapistEntity.getTurnTime())
                .NamePacient(turnTherapistEntity.getNamePacient()).build();

    }

    //dto to model
    public static TurnTherapist ToModel(TurnTherapistDto turnTherapistDto)
    {
return TurnTherapist.builder().id(turnTherapistDto.getId())
        .therapistId(turnTherapistDto.getTherapistId())
        .effectiveDate(turnTherapistDto.getEffectiveDate())
        .TurnTime(turnTherapistDto.getTurnTime())
        .NamePacient(turnTherapistDto.getNamePacient()).build();
    }

}
