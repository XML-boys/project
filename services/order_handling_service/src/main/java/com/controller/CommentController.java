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
    public ResponseEntity<Void> saveComment(@RequestBody CommentDTO commentDTO, @PathVariable("idAd") Long idAd, HttpServletRequest httpServletRequest){
        String requestTokenHeader = httpServletRequest.getHeader("Authorization");
        String jwt = requestTokenHeader.substring(7);
        RestService restService = new RestService(new RestTemplateBuilder());
        ClientDataDTO clientDataDTO = restService.getClient(jwt);

        Comment comment = new Comment();
        Ad ad = adService.findById(idAd);
        comment.setIdKomentatora(clientDataDTO.getUserId());
        comment.setReklamak(ad);
        comment.setSadrzaj(commentDTO.getSadrzaj());
        comment.setApproved(false);
        commentService.save(comment);
        ad.getComments().add(comment);
        adService.save(ad);

        return new ResponseEntity<>(HttpStatus.CREATED);
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

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.remove(id);
        return new ResponseEntity<>((HttpStatus.OK));
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

