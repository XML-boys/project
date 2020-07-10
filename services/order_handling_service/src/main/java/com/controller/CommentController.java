package com.controller;

import com.model.*;
import com.service.AdService;
import com.service.CommentService;
import com.service.RestService;
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
@RequestMapping(value = "/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private AdService adService;

    @PostMapping(value = "/{idAd}", consumes = "application/json")
    public ResponseEntity<?> saveComment(@RequestBody CommentDTO commentDTO, @PathVariable("idAd") Long idAd, HttpServletRequest httpServletRequest){
        String requestTokenHeader = httpServletRequest.getHeader("Authorization");
        String jwt = requestTokenHeader.substring(7);
        RestService restService = new RestService(new RestTemplateBuilder());
        UserValidateDTO userValidateDTO = restService.getUserValidate(jwt);

        if(userValidateDTO.getRole().equals("Client")){
            ClientDataDTO clientDataDTO = restService.getClient(jwt);
            Ad ad = adService.findById(idAd);
            if(ad!= null){
                boolean flag = false;
                for(Comment c : ad.getComments()){
                    if(c.getIdKomentatora() == clientDataDTO.getUserId()){
                        flag = true;
                    }
                }
                if(!flag){
                    Comment comment = new Comment();
                    comment.setIdKomentatora(clientDataDTO.getUserId());
                    comment.setSadrzaj(commentDTO.getSadrzaj());
                    comment.setApproved(false);
                    comment.setReklamak(ad);
                    ad.getComments().add(commentService.save(comment));
                    Ad adz = adService.save(ad);
                    if(adz != null)
                        return new ResponseEntity<>(HttpStatus.CREATED);
                    else
                        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
                }else{
                    return new ResponseEntity<>("vec ste komentarisali ovu reklamu",HttpStatus.NOT_MODIFIED);
                }
            } else
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }else if (userValidateDTO.getRole().equals("Agent")){
            AgentDataDTO agentDataDTO = restService.getAgent(jwt);
            Ad ad = adService.findById(idAd);
            if(ad!= null){
                boolean flag = false;
                for(Comment c : ad.getComments()){
                    if(c.getIdKomentatora() == agentDataDTO.getUserId()){
                        flag = true;
                    }
                }
                if(!flag){
                    Comment comment = new Comment();
                    comment.setIdKomentatora(agentDataDTO.getUserId());
                    comment.setSadrzaj(commentDTO.getSadrzaj());
                    comment.setApproved(false);
                    comment.setReklamak(ad);
                    ad.getComments().add(commentService.save(comment));
                    Ad adz = adService.save(ad);
                    if(adz != null)
                        return new ResponseEntity<>(HttpStatus.CREATED);
                    else
                        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
                } else{
                    return new ResponseEntity<>("vec ste komentarisali ovu reklamu",HttpStatus.NOT_MODIFIED);
                }
            } else
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }

        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<CommentDTO>> getComments(){
        List<Comment> comments = commentService.findAllComments();
        List<CommentDTO> commentDTOS = new ArrayList<>();
        if(comments != null) {
            for(Comment comment : comments)
            {
                commentDTOS.add(new CommentDTO(comment));
                return new ResponseEntity<>(commentDTOS,HttpStatus.OK);
            }
        }else{
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}/{idComment}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id, @PathVariable("idComment") Long idComment) {
        Ad ad = adService.findById(id);
        if(ad != null) {
            for(Comment comment : ad.getComments()){
                if(comment.getId().equals(idComment)){
                    ad.getComments().remove(comment);
                    Ad a = adService.save(ad);
                    comment.setReklamak(new Ad());
                    commentService.save(comment);

                    commentService.remove(idComment);
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

    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<Void> putComment(@RequestBody CommentDTO commentDTO, @PathVariable Long id)  {
        List<Comment> comments = commentService.findAllComments();
        if(comments != null){
            for(Comment comment : comments)
            {
                if(comment.getId() == id)
                {
                    comment.setSadrzaj(commentDTO.getSadrzaj());
                    comment.setReklamak(commentDTO.getReklamak());
                    comment.setIdKomentatora(commentDTO.getIdKomentatora());
                    comment.setApproved(commentDTO.getApproved());
                    commentService.save(comment);
                }
            }
        }


        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Comment> getComment(@PathVariable Long id) {
        List<Comment> comments = commentService.findAllComments();
        if(comments != null)
        {
            for(Comment comment : comments)
            {
                if(comment.getId() == id){
                    return new ResponseEntity<>(comment, HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @PutMapping(value = "/{id}/approved/true", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Comment> putCommentApproved(@PathVariable Long id) {
        List<Comment> comments = commentService.findAllComments();
        if(comments != null)
        {
            for(Comment comment : comments)
            {
                if(comment.getId() == id){
                    comment.setApproved(true);
                    commentService.save(comment);
                    return new ResponseEntity<>(comment, HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity<>( HttpStatus.OK);
    }

}

