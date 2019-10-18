package com.stackroute.MuzixApplication.trackcontroller;

import com.stackroute.MuzixApplication.CustomEcxeptions.EmpyFieldExeption;
import com.stackroute.MuzixApplication.CustomEcxeptions.UserAlreadyExistsEcxeption;
import com.stackroute.MuzixApplication.TrackService.TrackServiceImplementation;
import com.stackroute.MuzixApplication.TrackService.TrackServiceInterface;
import com.stackroute.MuzixApplication.domain.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class TrackController
{

    private TrackServiceInterface trackserviceInterface;

    @Autowired
    public TrackController(TrackServiceInterface trackServiceInterface) {
        this.trackserviceInterface = trackServiceInterface;
    }


//    public List<Track> getAllTracks()
//        {
//            return trackImplementation.getTrackList();
//        }
    @GetMapping("/track")
    public ResponseEntity<List<Track>> getAllTracks()
    {
        return new ResponseEntity<List<Track>>(trackserviceInterface.getTrackList() , HttpStatus.OK);
    }
    @RequestMapping("/track/{id}")
    public ResponseEntity<?> getTrackById(@PathVariable String id)
         {
                    ResponseEntity responseEntity;
                    try
                        {
                            trackserviceInterface.getTrackById(id);
                            responseEntity=new ResponseEntity<Optional<Track>>(trackserviceInterface.getTrackById(id),HttpStatus.CREATED);
                        }
                    catch (Exception ex)
                        {
                            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
                        }
                    return responseEntity;
        }
   @PostMapping( value = "/track")
    public ResponseEntity<?> addTrack(@RequestBody Track track) throws EmpyFieldExeption {
//            trackService.addTrack(track);
            if(track.getTrackName().equals("")||track.getTrackId().equals("")||track.getTrackComments().equals(""))
                {
                    throw new EmpyFieldExeption("Field cannot be empty");
                }
            ResponseEntity responseEntity;
            try
            {
                trackserviceInterface.addTrack(track);
                responseEntity=new ResponseEntity<String>("Successfully saved", HttpStatus.CREATED);
            }
            catch (UserAlreadyExistsEcxeption ex)
            {
                responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
                ex.printStackTrace();
            }
            return responseEntity;
        }
   @PutMapping(value = "/track/{id}")
    public ResponseEntity<?> updateByID(@RequestBody Track track,@PathVariable String id)
        {
            ResponseEntity responseEntity;
            try
            {
                trackserviceInterface.updateById(track,id);
                responseEntity=new ResponseEntity<String>("Successfully Updated",HttpStatus.CREATED);
            }
            catch (Exception ex)
            {
                responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
            }
            return responseEntity;
        }
   @DeleteMapping( value="/track/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id) {

        ResponseEntity responseEntity;
        try
        {
            trackserviceInterface.deleteById(id);
            responseEntity=new ResponseEntity<String>("Successfully deleted",HttpStatus.CREATED);
        }
        catch (Exception ex)
        {
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
        }
    @DeleteMapping(value = "/track/allclear")
    public void allClear()
        {
            trackserviceInterface.completeDelete();
        }
/*    @RequestMapping(value = "/track/comments/{comments}",method = RequestMethod.GET)
    public List<Track> getTrackByComments(@PathVariable String comments)
        {
            return trackImplementation.getTrackByComments(comments);
        }*/



}
