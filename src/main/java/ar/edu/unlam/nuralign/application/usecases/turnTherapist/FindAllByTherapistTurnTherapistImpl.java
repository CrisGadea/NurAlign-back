package ar.edu.unlam.nuralign.application.usecases.turnTherapist;

import ar.edu.unlam.nuralign.application.ports.in.turnTherapist.FindAllByTherapistIdTurnTherapistUseCase;
import ar.edu.unlam.nuralign.application.ports.out.TurnTherapistReposirotyPort;
import ar.edu.unlam.nuralign.domain.models.TurnTherapist;

import java.util.List;

public class FindAllByTherapistTurnTherapistImpl implements FindAllByTherapistIdTurnTherapistUseCase {

    TurnTherapistReposirotyPort reposiroty;
    public FindAllByTherapistTurnTherapistImpl(TurnTherapistReposirotyPort reposiroty) {
        this.reposiroty = reposiroty;
    }
    @Override
    public List<TurnTherapist> FindAllTurnTherapistByTherapistIdUseCase(Long id) {
        return reposiroty.findAllByIdTurnTherapist(id);
    }
}
