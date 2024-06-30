package ar.edu.unlam.nuralign.infrastructure.controllers;

import ar.edu.unlam.nuralign.application.services.LoginTherapistService;
import ar.edu.unlam.nuralign.application.services.TherapistService;
import ar.edu.unlam.nuralign.domain.models.Therapist;
import ar.edu.unlam.nuralign.infrastructure.config.JwtTokenProvider;
import ar.edu.unlam.nuralign.infrastructure.dtos.LoginData;
import ar.edu.unlam.nuralign.infrastructure.dtos.LoginResponse;
import ar.edu.unlam.nuralign.infrastructure.dtos.TherapistDto;
import ar.edu.unlam.nuralign.infrastructure.mappers.TherapistMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TherapistControllerTest {

    @Mock
    private TherapistService therapistService;

    @Mock
    private LoginTherapistService loginService;

    @Mock
    private JwtTokenProvider jwtTokenProvider;

    @InjectMocks
    private TherapistController therapistController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateTherapist() {
        TherapistDto therapistDto = new TherapistDto();
        Therapist therapist = new Therapist();

        try (MockedStatic<TherapistMapper> mockedMapper = mockStatic(TherapistMapper.class)) {
            mockedMapper.when(() -> TherapistMapper.mapToDomain(therapistDto)).thenReturn(therapist);
            mockedMapper.when(() -> TherapistMapper.mapToDto(therapist)).thenReturn(therapistDto);
            when(therapistService.createTherapist(any(Therapist.class))).thenReturn(therapist);

            ResponseEntity<TherapistDto> response = therapistController.createTherapist(therapistDto);

            assertEquals(HttpStatus.CREATED, response.getStatusCode());
            assertEquals(therapistDto, response.getBody());
            verify(therapistService, times(1)).createTherapist(therapist);
        }
    }

    @Test
    public void testFindTherapist() {
        Long therapistId = 1L;
        Therapist therapist = new Therapist();
        TherapistDto therapistDto = new TherapistDto();

        try (MockedStatic<TherapistMapper> mockedMapper = mockStatic(TherapistMapper.class)) {
            mockedMapper.when(() -> TherapistMapper.mapToDto(therapist)).thenReturn(therapistDto);
            when(therapistService.findTherapist(therapistId)).thenReturn(Optional.of(therapist));

            ResponseEntity<Therapist> response = therapistController.findTherapist(therapistId);

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(therapist, response.getBody());
            //verify(therapistService, times(1)).findTherapist(therapistId);
        }
    }

    @Test
    public void testFindAllTherapists() {
        List<Therapist> therapists = Arrays.asList(new Therapist(), new Therapist());
        List<TherapistDto> therapistDtos = Arrays.asList(new TherapistDto(), new TherapistDto());

        try (MockedStatic<TherapistMapper> mockedMapper = mockStatic(TherapistMapper.class)) {
            mockedMapper.when(() -> TherapistMapper.mapToDto(any(Therapist.class))).thenReturn(new TherapistDto());
            when(therapistService.findAllTherapists()).thenReturn(therapists);

            ResponseEntity<List<Therapist>> response = therapistController.findAllTherapists();

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(therapistDtos.size(), response.getBody().size());
            verify(therapistService, times(1)).findAllTherapists();
        }
    }

    @Test
    public void testUpdateTherapist() {
        Long therapistId = 1L;
        Therapist therapist = new Therapist();
        TherapistDto therapistDto = new TherapistDto();

        try (MockedStatic<TherapistMapper> mockedMapper = mockStatic(TherapistMapper.class)) {
            mockedMapper.when(() -> TherapistMapper.mapToDomain(therapistDto)).thenReturn(therapist);
            mockedMapper.when(() -> TherapistMapper.mapToDto(therapist)).thenReturn(therapistDto);
            when(therapistService.updateTherapist(any(Therapist.class), eq(therapistId))).thenReturn(Optional.of(therapist));

            ResponseEntity<Therapist> response = therapistController.updateTherapist(therapist, therapistId);

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(therapist, response.getBody());
           // verify(therapistService, times(1)).updateTherapist(therapist, therapistId);
        }
    }

    @Test
    public void testDeleteTherapist() {
        Long therapistId = 1L;
        when(therapistService.deleteTherapist(therapistId)).thenReturn(true);

        ResponseEntity<Void> response = therapistController.deleteTherapist(therapistId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(therapistService, times(1)).deleteTherapist(therapistId);
    }

    @Test
    public void testLogin() {
        LoginData loginData = LoginData.builder().build();
        Therapist therapist = new Therapist();
        String token = "testToken";
        LoginResponse expectedResponse = LoginResponse.builder().token(token).build();

        try (MockedStatic<TherapistMapper> mockedMapper = mockStatic(TherapistMapper.class)) {
            mockedMapper.when(() -> TherapistMapper.mapToDomain(loginData)).thenReturn(therapist);
            when(loginService.login(any(LoginData.class))).thenReturn(therapist);
            when(jwtTokenProvider.generateToken(any(Therapist.class))).thenReturn(token);

            ResponseEntity<LoginResponse> response = therapistController.login(loginData);

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(expectedResponse, response.getBody());
            verify(loginService, times(1)).login(loginData);
            verify(jwtTokenProvider, times(1)).generateToken(therapist);
        }
    }
}