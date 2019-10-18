package com.stackroute.MuzixApplication.repository;

import com.stackroute.MuzixApplication.domain.Track;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends MongoRepository<Track,String> {
// @Query(value = "SELECT * FROM Track WHERE track_comments like %?1%",nativeQuery = true)
//  List<Track> find(String comments);
}
