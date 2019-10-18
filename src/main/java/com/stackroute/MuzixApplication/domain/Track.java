package com.stackroute.MuzixApplication.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import javax.persistence.Entity;
//import javax.persistence.Id;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Track {
    @Id
    String trackId;
    String trackName;
    String trackComments;

//    public Track() {
//    }
//
//    public Track(String trackId, String trackName, String trackComments) {
//        this.trackId = trackId;
//        this.trackName = trackName;
//        this.trackComments = trackComments;
//    }
//
//    public String getTrackId() {
//        return trackId;
//    }
//
//    public void setTrackId(String trackId) {
//        this.trackId = trackId;
//    }
//
//    public String getTrackName() {
//        return trackName;
//    }
//
//    public void setTrackName(String trackName) {
//        this.trackName = trackName;
//    }
//
//    public String getTrackComments() {
//        return trackComments;
//    }
//
//    public void setTrackComments(String trackComments) {
//        this.trackComments = trackComments;
//    }
//
//    @Override
//    public String toString() {
//        return "Track{" +
//                "trackId=" + trackId +
//                ", trackName='" + trackName + '\'' +
//                ", trackComments='" + trackComments + '\'' +
//                '}';
//    }
}
