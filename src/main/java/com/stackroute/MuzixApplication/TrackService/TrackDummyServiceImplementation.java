package com.stackroute.MuzixApplication.TrackService;

import com.stackroute.MuzixApplication.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Primary
@Qualifier("trackImplementation")
@Service
@Profile("prod")
public class TrackDummyServiceImplementation extends TrackServiceImplementation implements TrackServiceInterface {
    public TrackDummyServiceImplementation(TrackRepository trackRepository) {
        super(trackRepository);
    }
    @PostConstruct
    public void initIt() throws Exception {
        System.out.println("\n Dummy implementation of service created");
    }

    @PreDestroy
    public void cleanUp() throws Exception {
        System.out.println("\n Dummy implementation of service Destroyed \n");
    }
}
