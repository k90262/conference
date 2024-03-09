package com.pluralsight.service;

import com.pluralsight.model.Speaker;
import com.pluralsight.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

// stereotype annotation -> class level
@Service("speakerService")
@Profile("dev")
public class SpeakerServiceImplDev implements SpeakerService {

    private SpeakerRepository repository;

    public SpeakerServiceImplDev()
    {
        System.out.println("[dev] SpeakerServiceImpl no args constructor");
    }

    // constructor injection
    @Autowired
    public SpeakerServiceImplDev(SpeakerRepository speakerRpository)
    {
        System.out.println("[dev] SpeakerServiceImpl repository constructor");
        this.repository = speakerRpository;
    }

    @PostConstruct
    private void initialize() {
        System.out.println("[dev] We're called after the constructors");
    }

    @Override
    public List<Speaker> findAll() {
        return repository.findAll();
    }

    // setter injection
    //@Autowired
    public void setRepository(SpeakerRepository repository) {
        System.out.println("[dev] SpeakerServiceImpl setter");
        this.repository = repository;
    }
}
