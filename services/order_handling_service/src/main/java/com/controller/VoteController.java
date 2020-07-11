package com.controller;

import com.model.*;
import com.service.AdService;
import com.service.RestService;
import com.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public ResponseEntity<?> saveVote(@RequestBody VoteDTO voteDTO, @PathVariable("idAd") Long idAd, HttpServletRequest httpServletRequest)  {
        String requestTokenHeader = httpServletRequest.getHeader("Authorization");
        String jwt = requestTokenHeader.substring(7);
        RestService restService = new RestService(new RestTemplateBuilder());
        UserValidateDTO userValidateDTO = restService.getUserValidate(jwt);

        Vote vote = new Vote();
        Ad ad = adService.findById(idAd);

        if(userValidateDTO.getRole().equals("Client")){
            ClientDataDTO clientDataDTO = restService.getClient(jwt);
            if(ad != null){
                boolean flag = false;
                for(Vote v : ad.getVotes()){
                    if(v.getIdUsera() == clientDataDTO.getUserId()){
                        flag = true;
                    }
                }
                if(!flag){
                    vote.setIdKola(ad.getVehicleId());
                    vote.setIdReklame(idAd);
                    vote.setVrednost(voteDTO.getVrednost());
                    vote.setIdUsera(clientDataDTO.getUserId());
                    vote.setReklamaz(ad);
                    vote.setApproved(false);
                    ad.getVotes().add(voteService.save(vote));
                    Ad adz = adService.save(ad);
                    if (adz != null)
                        return new ResponseEntity<>(HttpStatus.CREATED);
                    else
                        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
                } else
                    return new ResponseEntity<>("Vec ste glasali",HttpStatus.NOT_MODIFIED);
            }
        }else if(userValidateDTO.getRole().equals("Agent")){
            AgentDataDTO agentDataDTO = restService.getAgent(jwt);
            if(ad != null){
                boolean flag = false;
                for(Vote v : ad.getVotes()){
                    if(v.getIdUsera() == agentDataDTO.getUserId()){
                        flag = true;
                    }
                }
                if(!flag){
                    vote.setIdKola(ad.getVehicleId());
                    vote.setIdReklame(idAd);
                    vote.setVrednost(voteDTO.getVrednost());
                    vote.setIdUsera(agentDataDTO.getUserId());
                    vote.setReklamaz(ad);
                    vote.setApproved(false);
                    ad.getVotes().add(voteService.save(vote));
                    Ad adz = adService.save(ad);
                    if (adz != null)
                        return new ResponseEntity<>(HttpStatus.CREATED);
                    else
                        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
                } else
                    return new ResponseEntity<>("Vec ste glasali",HttpStatus.NOT_MODIFIED);
            }
        }


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
