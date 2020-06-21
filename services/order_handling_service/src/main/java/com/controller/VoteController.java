package com.controller;

import com.model.Comment;
import com.model.Vote;
import com.model.VoteDTO;
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

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> saveVote(@RequestBody VoteDTO voteDTO)  {
        Vote vote = new Vote();
        vote.setIdKola(voteDTO.getIdKola());
        vote.setIdReklame(voteDTO.getIdReklame());
        vote.setVrednost(voteDTO.getVrednost());
        vote.setApproved(false);
        voteService.save(vote);

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
        return new ResponseEntity<>(voteDTOS, HttpStatus.NOT_IMPLEMENTED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteVote(@PathVariable Long id) {
        voteService.remove(id);
        return new ResponseEntity<>((HttpStatus.OK));
    }


    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<Void> putVote(@RequestBody VoteDTO voteDTO, @PathVariable Long id)  {
        List<Vote> votes = voteService.findAll();
        if(votes != null){
            for(Vote vote : votes)
            {
                if(vote.getId() == id)
                {
                    vote.setIdKola(voteDTO.getIdKola());
                    vote.setIdReklame(voteDTO.getIdReklame());
                    vote.setVrednost(voteDTO.getVrednost());
                    vote.setApproved(voteDTO.getApproved());
                    voteService.save(vote);
                }
            }
        }


        return new ResponseEntity<>(HttpStatus.OK);
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
