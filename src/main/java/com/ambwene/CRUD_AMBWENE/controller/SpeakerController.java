package com.ambwene.CRUD_AMBWENE.controller;

import com.ambwene.CRUD_AMBWENE.entity.SpeakerEntity;
import com.ambwene.CRUD_AMBWENE.exception.SpeakerNotFoundException;
import com.ambwene.CRUD_AMBWENE.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speaker")
public class SpeakerController {

@Autowired
private SpeakerRepository speakerRepository;

@GetMapping
public List<SpeakerEntity> getAllSpeakers(){
    return speakerRepository.findAll();
}

//code for adding speaker (create)
    @PostMapping
    public  SpeakerEntity createSpeaker(@RequestBody SpeakerEntity speakerEntity){
     return speakerRepository.save(speakerEntity);
    }

    //code for read speaker
    @GetMapping("{id}")
    public ResponseEntity<SpeakerEntity> getSpeakerById(@PathVariable long id){
    SpeakerEntity speakerEntity = speakerRepository.findById(id)
            .orElseThrow(() -> new SpeakerNotFoundException("Speaker not found"));
    return ResponseEntity.ok(speakerEntity);
    }

    //code for update
    @PutMapping("{id}")
    public ResponseEntity<SpeakerEntity> updateSpeaker(@PathVariable long id,@RequestBody SpeakerEntity speakerEntityDetails) {
        SpeakerEntity updateSpeaker = speakerRepository.findById(id)
                .orElseThrow(() -> new SpeakerNotFoundException("speaker not found"));

        updateSpeaker.setSpeakerID(speakerEntityDetails.getSpeakerID());
        updateSpeaker.setSpeakerFirstName(speakerEntityDetails.getSpeakerFirstName());
        updateSpeaker.setSpeakerSecondName(speakerEntityDetails.getSpeakerSecondName());
        updateSpeaker.setSpeakerEmail(speakerEntityDetails.getSpeakerEmail());
        updateSpeaker.setAddress(speakerEntityDetails.getAddress());
        updateSpeaker.setPhoneNo(speakerEntityDetails.getPhoneNo());

        speakerRepository.save(updateSpeaker);
        return ResponseEntity.ok(updateSpeaker);
    }

    //code for deleting
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteSpeaker(@PathVariable long id){
    SpeakerEntity deleteSpeaker = speakerRepository.findById(id)
            .orElseThrow(() ->new SpeakerNotFoundException("Speaker not found"));
    speakerRepository.delete(deleteSpeaker);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
