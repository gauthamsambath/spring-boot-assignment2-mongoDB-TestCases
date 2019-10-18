package com.stackroute.MuzixApplication.TrackService;

import com.stackroute.MuzixApplication.CustomEcxeptions.TrackNotFoundEcxeption;
import com.stackroute.MuzixApplication.CustomEcxeptions.UserAlreadyExistsEcxeption;
import com.stackroute.MuzixApplication.domain.Track;
import com.stackroute.MuzixApplication.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImplementation implements TrackServiceInterface
    {
      //  List<Track> trackList=new ArrayList<Track>(Arrays.asList(new Track("123","Billy jean","album by michael jackson")));
        public List<Track> getTrackList() {
            return trackRepository.findAll();
        }

        TrackRepository trackRepository;
        @Autowired
        public TrackServiceImplementation(TrackRepository trackRepository) {
            this.trackRepository = trackRepository;
        }

        public Optional<Track> getTrackById(String id) throws TrackNotFoundEcxeption
            {
//                return trackList.stream().filter(t->t.getTrackId().equals(id)).findFirst().get();
                if(!trackRepository.existsById(id))
                    {
                        throw new TrackNotFoundEcxeption("The track you are trying to get is not present in the repository");
                    }
                return trackRepository.findById(id);
            }
        public Track addTrack(Track track) throws UserAlreadyExistsEcxeption {

            Track savedTrack = null;
            if(trackRepository.existsById(track.getTrackId())){
                throw new UserAlreadyExistsEcxeption("User already exist");
            }

            else{
                savedTrack = trackRepository.save(track);
                if(savedTrack == null){
                    throw new UserAlreadyExistsEcxeption("User already exist");
                }
            }

            return savedTrack;

            }
        public void updateById(Track track,String id) throws TrackNotFoundEcxeption
            {
//                boolean b=false;
//                for (int i=0;i<trackList.size();i++)
//                    {
//                        Track track1=trackList.get(i);
//                        if(track1.getTrackId().equals(id))
//                            {
//
//                                trackList.set(i,track);
//                            }
//                    }
                if(!trackRepository.existsById(id))
                    {
                        throw new TrackNotFoundEcxeption("The track you are trying to Update is not present in the repository");
                    }

                        trackRepository.deleteById(id);
                        trackRepository.save(track);
            }
        public void deleteById(String id) throws TrackNotFoundEcxeption
            {
                if(!trackRepository.existsById(id))
                    {
                        throw new TrackNotFoundEcxeption("The track you are trying to Delete is not present in the repository");
                    }

                trackRepository.deleteById(id);


//                trackList.removeIf(t->t.getTrackId().equals(id));
            }
        public void completeDelete()
            {
                trackRepository.deleteAll();
                //trackList.clear();
            }
//        public List<Track> getTrackByComments(String comments)
//            {
//                return trackRepository.getTrackBytrackComments(comments);
//            }
        @PostConstruct
        public void initIt() throws Exception {
            System.out.println("\n Normal implementation of service created");
        }

        @PreDestroy
        public void cleanUp() throws Exception {
            System.out.println("\n Normal implementation of service Destroyed \n");
        }



    }
