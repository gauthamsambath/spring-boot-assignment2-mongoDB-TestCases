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
@ConfigurationProperties
@PropertySource("classpath:application.properties")
public class SeedDataUsingAnnotations
{
//    @Value("${trackid2}")
    String trackid;
//    @Value("${trackcomment2}")
    String trackcomment;
//    @Value("${trackname2}")
    String trackname;
   @Autowired
    TrackRepository trackRepository;

    public String getTrackid() {
        return trackid;
    }

    public void setTrackid(String trackid) {
        this.trackid = trackid;
    }

    public String getTrackcomment() {
        return trackcomment;
    }

    public void setTrackcomment(String trackcomment) {
        this.trackcomment = trackcomment;
    }

    public String getTrackname() {
        return trackname;
    }

    public void setTrackname(String trackname) {
        this.trackname = trackname;
    }

    @Bean
    public void seedData2()
        {
            trackRepository.save(new Track(trackid,trackname,trackcomment));
        }

}
*/
