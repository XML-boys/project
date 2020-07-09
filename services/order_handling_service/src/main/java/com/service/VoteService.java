package com.service;

import com.model.Ad;
import com.model.Vote;
import com.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;

    public List<Vote> findAll() { return voteRepository.findAll(); }
    public Vote save(Vote vote) {
        return voteRepository.save(vote);
    }
    public void remove(Long id) { voteRepository.deleteById(id);
    }
    public Vote findById(Long id){
        return voteRepository.findAdById(id);
    }
}
