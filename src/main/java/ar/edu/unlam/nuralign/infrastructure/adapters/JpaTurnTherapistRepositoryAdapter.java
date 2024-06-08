package ar.edu.unlam.nuralign.infrastructure.adapters;

import ar.edu.unlam.nuralign.application.ports.out.TurnTherapistReposirotyPort;
import ar.edu.unlam.nuralign.domain.models.TurnTherapist;
import ar.edu.unlam.nuralign.infrastructure.entities.TurnTherapistEntity;
import ar.edu.unlam.nuralign.infrastructure.mappers.TurnTherapistMapper;
import ar.edu.unlam.nuralign.infrastructure.repositories.JpaTurnTherapistRepository;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JpaTurnTherapistRepositoryAdapter implements TurnTherapistReposirotyPort {

    private JpaTurnTherapistRepository repository;

    public JpaTurnTherapistRepositoryAdapter(JpaTurnTherapistRepository repository) {
        this.repository = repository;
    }


    @Override
    public TurnTherapist save(TurnTherapist turnTherapist) {

        TurnTherapistEntity turnTherapistEntity = TurnTherapistMapper.toEntity(turnTherapist);

        return TurnTherapistMapper.toModel(repository.save(turnTherapistEntity));
    }

    @Override
    public List<TurnTherapist> findAllByIdTurnTherapist(Long id) {
        List<TurnTherapistEntity> entities = repository.findAllBytherapistId(id);
        if (entities.isEmpty()) {
            return Collections.emptyList();
        }


        return entities.stream().map(TurnTherapistMapper::toModel).collect(Collectors.toList());
    }

    @Override

    public  void deleteById(Long Id) {



        repository.deleteById(Id);
    }

    @Override
    public List<TurnTherapist> findById(Long Id) {
        List<TurnTherapistEntity> entities = repository.findAllById(Id);
        if (entities.isEmpty())

        {
            return Collections.emptyList();
        }
        return null;
    }


}
