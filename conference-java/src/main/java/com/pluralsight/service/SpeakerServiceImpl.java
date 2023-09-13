package com.pluralsight.service;

import com.pluralsight.model.Speaker;
import com.pluralsight.repository.HibernateSpeakerRepositoryImpl;
import com.pluralsight.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

// stereotype annotation -> class level
@Service("speakerService")
@Profile("dev")
public class SpeakerServiceImpl implements SpeakerService {

    private SpeakerRepository repository;

    public SpeakerServiceImpl()
    {
        System.out.println("SpeakerServiceImpl no args constructor");
    }

    // constructor injection
    @Autowired
    public SpeakerServiceImpl(SpeakerRepository speakerRpository)
    {
        System.out.println("SpeakerServiceImpl repository constructor");
        this.repository = speakerRpository;
    }

    @PostConstruct
    private void initialize() {
        System.out.println("We're called after the constructors");
    }

    @Override
    public List<Speaker> findAll() {
        return repository.findAll();
    }

    // setter injection
    //@Autowired
    public void setRepository(SpeakerRepository repository) {
        System.out.println("SpeakerServiceImpl setter");
        this.repository = repository;
    }
}
