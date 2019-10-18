package com.stackroute.MuzixApplication.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.MuzixApplication.CustomEcxeptions.UserAlreadyExistsEcxeption;
import com.stackroute.MuzixApplication.TrackService.TrackServiceImplementation;
import com.stackroute.MuzixApplication.domain.Track;
import com.stackroute.MuzixApplication.trackcontroller.TrackController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest

public class TrackRepositoryTest {
    @Autowired
    private MockMvc mockMvc;
    private Track track;
    @MockBean
    private TrackServiceImplementation trackServiceImplementation;
    @InjectMocks
    private TrackController trackController;

    private List<Track> list =null;

    @Before
    public void setUp(){

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(trackController).build();
        track = new Track();
        track.setTrackId("1");
        track.setTrackName("Dont wake me up");
        track.setTrackComments("Song by Avici");
        list = new ArrayList<Track>();
        list.add(track);
    }

    @Test
    public void saveUser() throws Exception {
        when(trackServiceImplementation.addTrack(any())).thenReturn(track);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/track")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());


    }
    @Test
    public void saveUserFailure() throws Exception {
        when(trackServiceImplementation.addTrack(any())).thenThrow(UserAlreadyExistsEcxeption.class);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/track")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(MockMvcResultMatchers.status().isConflict())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getAllUser() throws Exception {
        when(trackServiceImplementation.getTrackList()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/track")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(track)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }


    private static String asJsonString(final Object obj)
    {
        try{
            return new ObjectMapper().writeValueAsString(obj);

        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
