package com.crio.xharktank.dao;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.crio.xharktank.models.pitches;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface pitchDaoInterface extends MongoRepository<pitches, Integer> {

}
