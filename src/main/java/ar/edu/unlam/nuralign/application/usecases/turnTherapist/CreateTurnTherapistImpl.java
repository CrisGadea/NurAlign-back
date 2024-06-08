package ar.edu.unlam.nuralign.application.usecases.turnTherapist;

import ar.edu.unlam.nuralign.application.ports.in.turnTherapist.CreateTurnTherapistUseCase;
import ar.edu.unlam.nuralign.application.ports.out.TurnTherapistReposirotyPort;
import ar.edu.unlam.nuralign.domain.models.TurnTherapist;

public class CreateTurnTherapistImpl implements CreateTurnTherapistUseCase {
    TurnTherapistReposirotyPort reposiroty;
    public CreateTurnTherapistImpl(TurnTherapistReposirotyPort reposiroty)
    {
        this.reposiroty = reposiroty;
    }
    @Override
    public TurnTherapist CreateTurnTherapist(TurnTherapist TurnTherapist) {
        return reposiroty.save(TurnTherapist);
    }
}
