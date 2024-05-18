package ar.edu.unlam.nuralign.application.services;

import ar.edu.unlam.nuralign.application.ports.in.therapist.CreateTherapistUseCase;
import ar.edu.unlam.nuralign.application.ports.in.therapist.DeleteTherapistUseCase;
import ar.edu.unlam.nuralign.application.ports.in.therapist.UpdateTherapistUseCase;
import ar.edu.unlam.nuralign.application.ports.in.therapist.FindTherapistUseCase;
import ar.edu.unlam.nuralign.application.ports.in.therapist.FindAllTherapistsUseCase;
import ar.edu.unlam.nuralign.domain.models.Therapist;

import java.util.List;
import java.util.Optional;

public class TherapistService implements CreateTherapistUseCase, UpdateTherapistUseCase, DeleteTherapistUseCase,
        FindTherapistUseCase, FindAllTherapistsUseCase {

    private final CreateTherapistUseCase createTherapistUseCase;
    private final UpdateTherapistUseCase updateTherapistUseCase;
    private final DeleteTherapistUseCase deleteTherapistUseCase;
    private final FindTherapistUseCase findTherapistUseCase;
    private final FindAllTherapistsUseCase findAllTherapistsUseCase;

    public TherapistService(CreateTherapistUseCase createTherapistUseCase, UpdateTherapistUseCase updateTherapistUseCase,
                            DeleteTherapistUseCase deleteTherapistUseCase, FindTherapistUseCase findTherapistUseCase,
                            FindAllTherapistsUseCase findAllTherapistsUseCase) {
        this.createTherapistUseCase = createTherapistUseCase;
        this.updateTherapistUseCase = updateTherapistUseCase;
        this.deleteTherapistUseCase = deleteTherapistUseCase;
        this.findTherapistUseCase = findTherapistUseCase;
        this.findAllTherapistsUseCase = findAllTherapistsUseCase;
    }

    @Override
    public Therapist createTherapist(Therapist therapist) {
        return createTherapistUseCase.createTherapist(therapist);
    }

    @Override
    public boolean deleteTherapist(Long id) {
        return deleteTherapistUseCase.deleteTherapist(id);
    }

    @Override
    public List<Therapist> findAllTherapists() {
        return findAllTherapistsUseCase.findAllTherapists();
    }

    @Override
    public Optional<Therapist> findTherapist(Long id) {
        return findTherapistUseCase.findTherapist(id);
    }

    @Override
    public Optional<Therapist> updateTherapist(Therapist therapist, Long therapistId) {
        return updateTherapistUseCase.updateTherapist(therapist, therapistId);
    }
}
