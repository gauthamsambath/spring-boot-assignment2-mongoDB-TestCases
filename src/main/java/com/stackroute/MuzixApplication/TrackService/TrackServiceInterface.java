package com.stackroute.MuzixApplication.TrackService;

import com.stackroute.MuzixApplication.CustomEcxeptions.TrackNotFoundEcxeption;
import com.stackroute.MuzixApplication.CustomEcxeptions.UserAlreadyExistsEcxeption;
import com.stackroute.MuzixApplication.domain.Track;
import com.stackroute.MuzixApplication.repository.TrackRepository;

import java.util.List;
import java.util.Optional;

public interface TrackServiceInterface {
    public List<Track> getTrackList();
    public Optional<Track> getTrackById(String id) throws TrackNotFoundEcxeption;
    public Track addTrack(Track track) throws UserAlreadyExistsEcxeption;
    public void updateById(Track track,String id) throws TrackNotFoundEcxeption;
    public void deleteById(String id) throws TrackNotFoundEcxeption;
    public void completeDelete();
//    public List<Track> getTrackByComments(String comments);


}
