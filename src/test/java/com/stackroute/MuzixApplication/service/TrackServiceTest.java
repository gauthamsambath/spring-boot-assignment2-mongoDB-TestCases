package com.stackroute.MuzixApplication.service;

import com.stackroute.MuzixApplication.CustomEcxeptions.UserAlreadyExistsEcxeption;
import com.stackroute.MuzixApplication.TrackService.TrackServiceImplementation;
import com.stackroute.MuzixApplication.domain.Track;
import com.stackroute.MuzixApplication.repository.TrackRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class TrackServiceTest {
    private Track track;

    //Create a mock for UserRepository
    @Mock
    private TrackRepository trackRepository;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    private TrackServiceImplementation trackServiceImplementation;
    List<Track> list= null;


    @Before
    public void setUp(){
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        track = new Track();
        track.setTrackId("1");
        track.setTrackName("Dont wake me up");
        track.setTrackComments("Song by Avici");
        list = new ArrayList<Track>();
        list.add(track);


    }

    @Test
    public void saveUserTestSuccess() throws UserAlreadyExistsEcxeption {

        when(trackRepository.save((Track) any())).thenReturn(track);
        Track savedTrack = trackServiceImplementation.addTrack(track);
        Assert.assertEquals(track,savedTrack);

        //verify here verifies that userRepository save method is only called once
        verify(trackRepository,times(1)).save(track);

    }

    @Test(expected = UserAlreadyExistsEcxeption.class)
    public void saveUserTestFailure() throws UserAlreadyExistsEcxeption {
        when(trackRepository.save((Track) any())).thenReturn(null);
        Track savedTrack = trackServiceImplementation.addTrack(track);
        System.out.println("savedUser" + savedTrack);
        Assert.assertEquals(track,savedTrack);

       /*doThrow(new UserAlreadyExistException()).when(userRepository).findById(eq(101));
       userService.saveUser(user);*/


    }

    @Test
    public void getAllUser(){

        trackRepository.save(track);
        //stubbing the mock to return specific data
        when(trackRepository.findAll()).thenReturn(list);
        List<Track> userlist = trackServiceImplementation.getTrackList();
        Assert.assertEquals(list,userlist);
    }
}
