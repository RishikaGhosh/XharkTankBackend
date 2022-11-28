package com.crio.xharktank.controllers;

import com.crio.xharktank.exceptionHandlers.badRequestException;
import com.crio.xharktank.exceptionHandlers.errorObject;
import com.crio.xharktank.exceptionHandlers.pitchNotFoundException;
import com.crio.xharktank.models.Response;
import com.crio.xharktank.models.offers;
import com.crio.xharktank.models.pitches;
import com.crio.xharktank.service.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/")
public class Pitches {
    @Autowired
    private services pitchService;

    @GetMapping("/helloworld")
    public String Hello(){
        return "Hello World!";
    }

    @GetMapping("/pitches")
    public List<pitches> getAllPitches(){
        return pitchService.getPitches();
    }

    @GetMapping("/pitches/{_id}")
    public pitches getPitch(@PathVariable String _id){
        return pitchService.getPitch(_id);
    }
    @PostMapping("/pitches")
    public Response addPitch(@RequestBody pitches pitch){
        return pitchService.savePitch(pitch);
    }
    @PostMapping("/pitches/{id}/makeOffer")
    public Response addOffer(@PathVariable String id,@RequestBody offers offer){
        return pitchService.saveOffer(id,offer);
    }
    @ExceptionHandler
    ResponseEntity<errorObject> handleNotFoundException(pitchNotFoundException ex){
        errorObject eObject = new errorObject(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<errorObject>(eObject,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(badRequestException.class)
    ResponseEntity<errorObject> handleBadRequestException(badRequestException ex){
        errorObject eObject = new errorObject(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<errorObject>(eObject,HttpStatus.BAD_REQUEST);
    }

}
