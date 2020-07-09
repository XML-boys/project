package com.controller;

import com.model.Ad;
import com.model.Comment;
import com.model.Vote;
import com.model.VoteDTO;
import com.service.AdService;
import com.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/vote")
public class VoteController {

    @Autowired
    private VoteService voteService;
    @Autowired
    private AdService adService;

    @PostMapping(value = "/{idAd}", consumes = "application/json")
    public ResponseEntity<Void> saveVote(@RequestBody VoteDTO voteDTO,@PathVariable("idAd") Long idAd)  {
        Vote vote = new Vote();
        Ad ad = adService.findById(idAd);
        vote.setIdKola(ad.getVehicleId());
        vote.setIdReklame(idAd);
        vote.setVrednost(voteDTO.getVrednost());
        vote.setReklamaz(ad);
        vote.setApproved(false);
        voteService.save(vote);
        ad.getVotes().add(vote);
        adService.save(ad);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<VoteDTO>> getVotes() {
        List<Vote> votes = voteService.findAll();
        List<VoteDTO> voteDTOS= new ArrayList<>();
        if(votes != null)
        {
            for(Vote vote : votes)
            {
                voteDTOS.add(new VoteDTO(vote));
                return new ResponseEntity<>(voteDTOS, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteVote(@PathVariable Long id) {
        voteService.remove(id);
        return new ResponseEntity<>((HttpStatus.OK));
    }


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vote> getVote(@PathVariable Long id) {
        List<Vote> votes = voteService.findAll();
        if(votes != null)
        {
            for(Vote vote : votes)
            {
                if(vote.getId() == id){
                    return new ResponseEntity<>(vote, HttpStatus.OK);
                }
            }
        }else{
            return new ResponseEntity<>( HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @PutMapping(value = "/{id}/approved/true", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vote> putVoteApproved(@PathVariable Long id) {
        List<Vote> votes = voteService.findAll();
        if(votes != null)
        {
            for(Vote vote : votes)
            {
                if(vote.getId() == id){
                    vote.setApproved(true);
                    voteService.save(vote);
                    return new ResponseEntity<>(vote, HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
