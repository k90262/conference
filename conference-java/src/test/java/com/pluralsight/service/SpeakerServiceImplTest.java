package com.pluralsight.service;

import com.pluralsight.model.Speaker;
import com.pluralsight.repository.SpeakerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

public class SpeakerServiceImplTest {
    @Mock
    SpeakerRepository repository;

    @InjectMocks
    SpeakerServiceImpl service;

    @BeforeEach //instead of @Before have to use @BeforeEach in junit5
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void findAll() {
        List<Speaker> speakers = new ArrayList<Speaker>();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Bill");
        speaker.setLastName("Ho");
        speakers.add(speaker);

        // using Mockito
        doReturn(speakers).when(repository).findAll();

        // when
        List<Speaker> speakers_from_service = service.findAll();

        // then
        assertEquals("Bill", speakers_from_service.get(0).getFirstName(), "Should be mock" );

        // Ref. https://stackoverflow.com/questions/60752423/how-to-mock-object-for-autowired-in-junit-5-unit-test
    }
}