package ar.edu.unlam.nuralign.infrastructure.adapters;

import ar.edu.unlam.nuralign.domain.models.TherapySession;
import ar.edu.unlam.nuralign.infrastructure.dtos.TherapySessionDto;
import ar.edu.unlam.nuralign.infrastructure.entities.TherapySessionEntity;
import ar.edu.unlam.nuralign.infrastructure.mappers.TherapySessionMapper;
import ar.edu.unlam.nuralign.infrastructure.repositories.JpaTherapySessionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class JpaTherapySessionRepositoryAdapterTest {

    @Mock
    private JpaTherapySessionRepository repository;

    @InjectMocks
    private JpaTherapySessionRepositoryAdapter adapter;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave() {
        TherapySessionEntity entity = new TherapySessionEntity();
        TherapySession model = new TherapySession();

        // Configurar el mock de repository y mapper
        try (MockedStatic<TherapySessionMapper> mockedMapper = mockStatic(TherapySessionMapper.class)) {
            mockedMapper.when(() -> TherapySessionMapper.toEntity(any(TherapySession.class))).thenReturn(entity);
            when(repository.save(any(TherapySessionEntity.class))).thenReturn(entity);
            mockedMapper.when(() -> TherapySessionMapper.toModel(any(TherapySessionEntity.class))).thenReturn(model);

            // Ejecutar el método y verificar el resultado
            TherapySession result = adapter.save(model);

            assertNotNull(result);
            verify(repository, times(1)).save(any(TherapySessionEntity.class));
        }
    }

    @Test
    public void testFindAllByPatientId() {
        Long patientId = 1L;
        List<TherapySessionEntity> entities = Arrays.asList(new TherapySessionEntity(), new TherapySessionEntity());

        when(repository.findAllByPatientId(patientId)).thenReturn(entities);

        try (MockedStatic<TherapySessionMapper> mockedMapper = mockStatic(TherapySessionMapper.class)) {
            mockedMapper.when(() -> TherapySessionMapper.toModel(any(TherapySessionEntity.class)))
                    .thenReturn(new TherapySession());

            List<TherapySession> result = adapter.findAllByPatientId(patientId);

            assertEquals(2, result.size());
            verify(repository, times(1)).findAllByPatientId(patientId);
        }
    }

    @Test
    public void testFindAllByTherapistId() {
        Long therapistId = 1L;
        List<TherapySessionEntity> entities = Arrays.asList(new TherapySessionEntity(), new TherapySessionEntity());

        when(repository.findAllByTherapistId(eq(therapistId))).thenReturn(entities);

        List<TherapySession> result = adapter.findAllByTherapistId(therapistId);

        assertEquals(2, result.size());
        verify(repository, times(1)).findAllByTherapistId(eq(therapistId));
    }

    @Test
    public void testFindById() {
        Long sessionId = 1L;
        TherapySessionEntity entity = new TherapySessionEntity();
        TherapySession model = new TherapySession();

        // Configurar el mock de repository y mapper
        when(repository.findById(sessionId)).thenReturn(Optional.of(entity));
        try (MockedStatic<TherapySessionMapper> mockedMapper = mockStatic(TherapySessionMapper.class)) {
            mockedMapper.when(() -> TherapySessionMapper.toModel(entity)).thenReturn(model);

            // Ejecutar el método y verificar el resultado
            TherapySession result = adapter.findById(sessionId);

            assertNotNull(result);
            verify(repository, times(1)).findById(sessionId);
        }
    }

    @Test
    public void testFindAll() {
        TherapySessionEntity entity1 = new TherapySessionEntity();
        TherapySessionEntity entity2 = new TherapySessionEntity();
        List<TherapySessionEntity> entities = List.of(entity1, entity2);

        TherapySession model1 = new TherapySession();
        TherapySession model2 = new TherapySession();

        // Configurar el mock de repository y mapper
        when(repository.findAll()).thenReturn(entities);
        try (MockedStatic<TherapySessionMapper> mockedMapper = mockStatic(TherapySessionMapper.class)) {
            mockedMapper.when(() -> TherapySessionMapper.toModel(entity1)).thenReturn(model1);
            mockedMapper.when(() -> TherapySessionMapper.toModel(entity2)).thenReturn(model2);

            // Ejecutar el método y verificar el resultado
            List<TherapySession> result = adapter.findAll();

            assertNotNull(result);
            verify(repository, times(1)).findAll();
        }
    }

    @Test
    public void testFindAllByPatientIdAndTherapistId() {
        TherapySessionEntity entity = new TherapySessionEntity();
        entity.setId(1L);
        entity.setPatientId(1L);
        entity.setTherapistId(1L);
        entity.setEffectiveDate(String.valueOf(LocalDate.now()));

        List<TherapySessionEntity> entityList = List.of(entity);

        try (MockedStatic<TherapySessionMapper> mockedMapper = mockStatic(TherapySessionMapper.class)) {
            mockedMapper.when(() -> TherapySessionMapper.toModel(any(TherapySessionEntity.class)))
                    .thenAnswer(invocation -> {
                        TherapySessionEntity e = invocation.getArgument(0);
                        TherapySession session = new TherapySession();
                        session.setId(e.getId());
                        session.setPatientId(e.getPatientId());
                        session.setTherapistId(e.getTherapistId());
                        session.setEffectiveDate(LocalDate.parse(e.getEffectiveDate()));
                        return session;
                    });

            when(repository.findAllByPatientIdAndTherapistId(anyLong(), anyLong())).thenReturn(entityList);

            List<TherapySession> result = adapter.findAllByPatientIdAndTherapistId(1L, 1L);

            assertNotNull(result);
            verify(repository, times(1)).findAllByPatientIdAndTherapistId(anyLong(), anyLong());
        }
    }

    @Test
    public void testUpdate() {
        TherapySessionEntity entity = new TherapySessionEntity();
        LocalDate date=LocalDate.now();
        entity.setId(1L);
        entity.setPatientId(1L);
        entity.setTherapistId(1L);
        entity.setEffectiveDate(String.valueOf(LocalDate.parse(date.toString())));
        TherapySession session = new TherapySession();
        session.setId(1L);
        session.setPatientId(1L);
        session.setTherapistId(1L);
        session.setEffectiveDate(date);

        try (MockedStatic<TherapySessionMapper> mockedMapper = mockStatic(TherapySessionMapper.class)) {
            mockedMapper.when(() -> TherapySessionMapper.toEntity(any(TherapySession.class)))
                    .thenReturn(entity);
            mockedMapper.when(() -> TherapySessionMapper.toModel(any(TherapySessionEntity.class)))
                    .thenReturn(session);

            //when(repository.findById(anyLong())).thenReturn(Optional.of(entity));
            when(repository.save(any(TherapySessionEntity.class))).thenReturn(entity);
            when(repository.findByTherapistIdAndPatientIdAndEffectiveDate(anyLong(), anyLong(), anyString()))
                    .thenReturn(entity);

            TherapySession result = adapter.update(session,entity.getPatientId(),entity.getTherapistId(),date);

            assertNotNull(result);
            verify(repository, times(1)).findByTherapistIdAndPatientIdAndEffectiveDate(anyLong(), anyLong(), anyString());
            //verify(repository, times(1)).findById(anyLong());
            verify(repository, times(1)).save(any(TherapySessionEntity.class));
        }
    }
}