package com.service;

import com.model.Comment;
import com.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> findAllComments() {
        return commentRepository.findAll();
    }

    public Comment save(Comment comment){
        return commentRepository.save(comment);
    }

    public void remove(Long id) {
        commentRepository.deleteById(id);
    }
}
