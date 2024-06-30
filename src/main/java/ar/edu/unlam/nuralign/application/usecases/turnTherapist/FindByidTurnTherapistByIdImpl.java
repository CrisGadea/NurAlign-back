package ar.edu.unlam.nuralign.application.usecases.turnTherapist;

import ar.edu.unlam.nuralign.application.ports.in.turnTherapist.FindAllTurnTherapistByIdUseCase;
import ar.edu.unlam.nuralign.application.ports.out.TurnTherapistReposirotyPort;
import ar.edu.unlam.nuralign.domain.models.TurnTherapist;

import java.util.List;

public class FindByidTurnTherapistByIdImpl implements FindAllTurnTherapistByIdUseCase {
    TurnTherapistReposirotyPort reposiroty;
    public FindByidTurnTherapistByIdImpl(TurnTherapistReposirotyPort reposiroty) {
        this.reposiroty = reposiroty;
    }
    @Override
    public List<TurnTherapist> findByIdTurnTherapist(Long idTurnTherapist) {
        return reposiroty.findAllByIdTurnTherapist(idTurnTherapist);
    }
}
