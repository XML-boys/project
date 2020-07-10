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
        if(ad != null){
            vote.setIdKola(ad.getVehicleId());
            vote.setIdReklame(idAd);
            vote.setVrednost(voteDTO.getVrednost());
            vote.setReklamaz(ad);
            vote.setApproved(false);
            ad.getVotes().add(voteService.save(vote));
            Ad adz = adService.save(ad);
            if (adz != null)
                return new ResponseEntity<>(HttpStatus.CREATED);
            else
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
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

    @DeleteMapping(value = "/{id}/{idVote}")
    public ResponseEntity<Void> deleteVote(@PathVariable Long id, @PathVariable("idVote") Long idVote) {
        Ad ad = adService.findById(id);
        if(ad != null) {
            for(Vote vote : ad.getVotes()){
                if(vote.getId().equals(idVote)){
                    ad.getVotes().remove(vote);
                    Ad a = adService.save(ad);
                    vote.setReklamaz(new Ad());
                    voteService.save(vote);

                    voteService.remove(idVote);
                    if(a != null) {
                        return new ResponseEntity<>(HttpStatus.OK);
                    } else{
                        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
                    }
                }
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
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
