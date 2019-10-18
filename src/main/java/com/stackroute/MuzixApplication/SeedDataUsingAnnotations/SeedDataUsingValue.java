/*
package com.stackroute.MuzixApplication.SeedDataUsingAnnotations;

import com.stackroute.MuzixApplication.domain.Track;
import com.stackroute.MuzixApplication.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class SeedDataUsingValue {
    @Value("${trackid2}")
    String trackid2;
    @Value("${trackcomment2}")
    String trackcomment2;
    @Value("${trackname2}")
    String trackname2;
    @Autowired
    TrackRepository trackRepository;

    public String getTrackid2() {
        return trackid2;
    }

    public void setTrackid2(String trackid2) {
        this.trackid2 = trackid2;
    }

    public String getTrackcomment2() {
        return trackcomment2;
    }

    public void setTrackcomment2(String trackcomment2) {
        this.trackcomment2 = trackcomment2;
    }

    public String getTrackname2() {
        return trackname2;
    }

    public void setTrackname2(String trackname2) {
        this.trackname2 = trackname2;
    }

    @Bean
    public void seedData3()
    {
        trackRepository.save(new Track(trackid2,trackname2,trackcomment2));
    }
}
*/
