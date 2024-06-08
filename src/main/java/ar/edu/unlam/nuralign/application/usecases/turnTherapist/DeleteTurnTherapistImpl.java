package ar.edu.unlam.nuralign.application.usecases.turnTherapist;

import ar.edu.unlam.nuralign.application.ports.in.turnTherapist.DeleteTurnTherapistByIdUseCase;
import ar.edu.unlam.nuralign.application.ports.out.TurnTherapistReposirotyPort;

public class DeleteTurnTherapistImpl implements DeleteTurnTherapistByIdUseCase {
    TurnTherapistReposirotyPort reposiroty;
    public DeleteTurnTherapistImpl(TurnTherapistReposirotyPort reposiroty) {
        this.reposiroty = reposiroty;
    }
    @Override
    public boolean DeleteTurnTherapistByIdUseCase(Long Id) {
        reposiroty.deleteById(Id);
        return reposiroty.findById(Id).isEmpty();
    }
}
