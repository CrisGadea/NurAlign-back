package ar.edu.unlam.nuralign.application.services;

import ar.edu.unlam.nuralign.application.ports.in.turnTherapist.CreateTurnTherapistUseCase;
import ar.edu.unlam.nuralign.application.ports.in.turnTherapist.DeleteTurnTherapistByIdUseCase;
import ar.edu.unlam.nuralign.application.ports.in.turnTherapist.FindAllByTherapistIdTurnTherapistUseCase;
import ar.edu.unlam.nuralign.domain.models.TurnTherapist;

import java.util.List;

public class TurnTherapistService {
    private CreateTurnTherapistUseCase createTurnTherapistUseCase;
    private FindAllByTherapistIdTurnTherapistUseCase findAllByTherapistTurnTherapist;
    private DeleteTurnTherapistByIdUseCase deleteTurnTherapist;

    public TurnTherapistService(CreateTurnTherapistUseCase createTurnTherapist,
                                FindAllByTherapistIdTurnTherapistUseCase findAllByTherapistTurnTherapist,
                                DeleteTurnTherapistByIdUseCase deleteTurnTherapist) {
        this.createTurnTherapistUseCase = createTurnTherapist;
        this.findAllByTherapistTurnTherapist=findAllByTherapistTurnTherapist;
        this.deleteTurnTherapist=deleteTurnTherapist;
    }

    public List<TurnTherapist> FindAllByTherapistId(Long therapistId) {

        return findAllByTherapistTurnTherapist.FindAllTurnTherapistByTherapistIdUseCase(therapistId);
    }

    public TurnTherapist createTurnTherapist(TurnTherapist turnTherapist) {
        return createTurnTherapistUseCase.CreateTurnTherapist(turnTherapist);
    }
}
