package com.crio.xharktank.service;

import com.crio.xharktank.dao.pitchDaoInterface;
import com.crio.xharktank.exceptionHandlers.badRequestException;
import com.crio.xharktank.exceptionHandlers.pitchNotFoundException;
import com.crio.xharktank.models.Response;
import com.crio.xharktank.models.offers;
import com.crio.xharktank.models.pitches;
import org.bson.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.*;

@Service
public class services {

    @Autowired
    private pitchDaoInterface pitchRepository;

    @Autowired
    private MongoTemplate mongoTemplate;
    public List<pitches> getPitches(){

        List<pitches>p = pitchRepository.findAll();

        for(int i=0,j=p.size()-1;i<j;i++){
            p.add(i,p.remove(j));
        }
        return p;
    }

    public Response savePitch(pitches pitch) {

        try {
            if(pitch.getEquity()>100){
                throw new badRequestException();
            }
            Integer id = pitchRepository.findAll().size() + 1;
            pitch.setId(String.valueOf(id));
            pitch.setOffers(new ArrayList<offers>());
            pitchRepository.save(pitch);
            return new Response(String.valueOf(id));
        }catch(NullPointerException ex){
            throw new badRequestException();
        }

    }
    public pitches getPitch(String id){
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        pitches p = mongoTemplate.findOne(query, pitches.class);
        if(p==null){
            throw new pitchNotFoundException();
        }
        return p;
    }

    public Response saveOffer(String id, offers offer){
        try {
            if(offer.getEquity()>100){
                throw new badRequestException();
            }
            pitches p = getPitch(id);
            List<offers> o = p.getOffers();
            o.add(offer);
            p.setOffers(o);
            pitchRepository.save(p);
            return new Response(String.valueOf(id));
        }catch(NullPointerException ex){
            throw new badRequestException();
        }
    }
}
