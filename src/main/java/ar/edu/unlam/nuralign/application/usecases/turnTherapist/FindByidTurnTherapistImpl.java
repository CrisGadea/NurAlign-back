package ar.edu.unlam.nuralign.application.usecases.turnTherapist;

import ar.edu.unlam.nuralign.application.ports.in.turnTherapist.FindByIdTurnTherapistUseCase;
import ar.edu.unlam.nuralign.application.ports.out.TurnTherapistReposirotyPort;
import ar.edu.unlam.nuralign.domain.models.TurnTherapist;

import java.util.List;

public class FindByidTurnTherapistImpl implements FindByIdTurnTherapistUseCase {
    TurnTherapistReposirotyPort reposiroty;
    public FindByidTurnTherapistImpl(TurnTherapistReposirotyPort reposiroty) {
        this.reposiroty = reposiroty;
    }
    @Override
    public List<TurnTherapist> findByIdTurnTherapist(Long idTurnTherapist) {
        return reposiroty.findAllByIdTurnTherapist(idTurnTherapist);
    }
}
