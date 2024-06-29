package ar.edu.unlam.nuralign.infrastructure.adapters;

import ar.edu.unlam.nuralign.domain.models.TurnTherapist;
import ar.edu.unlam.nuralign.infrastructure.entities.TurnTherapistEntity;
import ar.edu.unlam.nuralign.infrastructure.mappers.TurnTherapistMapper;
import ar.edu.unlam.nuralign.infrastructure.repositories.JpaTurnTherapistRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class JpaTurnTherapistRepositoryAdapterTest {

    @Mock
    private JpaTurnTherapistRepository repository;

    @InjectMocks
    private JpaTurnTherapistRepositoryAdapter adapter;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave() {
        TurnTherapist turnTherapist = new TurnTherapist();
        TurnTherapistEntity entity = new TurnTherapistEntity();
        when(repository.save(any(TurnTherapistEntity.class))).thenReturn(entity);

        // Mock the mapper methods
        mockStatic(TurnTherapistMapper.class);
        when(TurnTherapistMapper.toEntity(turnTherapist)).thenReturn(entity);
        when(TurnTherapistMapper.toModel(entity)).thenReturn(turnTherapist);

        TurnTherapist result = adapter.save(turnTherapist);

        assertEquals(turnTherapist, result);
        verify(repository, times(1)).save(entity);
    }

//    @Test
//    public void testFindAllByIdTurnTherapist() {
//        Long therapistId = 1L;
//        List<TurnTherapistEntity> entities = Arrays.asList(new TurnTherapistEntity(), new TurnTherapistEntity());
//        when(repository.findAllBytherapistId(therapistId)).thenReturn(entities);
//
//        // Mock the mapper methods
//        mockStatic(TurnTherapistMapper.class);
//        when(TurnTherapistMapper.toModel(any(TurnTherapistEntity.class))).thenReturn(new TurnTherapist());
//
//        List<TurnTherapist> result = adapter.findAllByIdTurnTherapist(therapistId);
//
//        assertEquals(2, result.size());
//        verify(repository, times(1)).findAllBytherapistId(therapistId);
//    }

    @Test
    public void testDeleteById() {
        Long id = 1L;
        doNothing().when(repository).deleteById(id);

        adapter.deleteById(id);

        verify(repository, times(1)).deleteById(id);
    }

//    @Test
//    public void testFindById() {
//        Long id = 1L;
//        List<TurnTherapistEntity> entities = Arrays.asList(new TurnTherapistEntity(), new TurnTherapistEntity());
//        when(repository.findAllById(id)).thenReturn(entities);
//
//        // Mock the mapper methods
//        mockStatic(TurnTherapistMapper.class);
//        when(TurnTherapistMapper.toModel(any(TurnTherapistEntity.class))).thenReturn(new TurnTherapist());
//
//        List<TurnTherapist> result = adapter.findById(id);
//
//        assertEquals(2, result.size());
//        verify(repository, times(1)).findAllById(id);
//    }
}