package com.repository;

import com.model.Ad;
import com.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

    List<Vote> findAll();
    Vote save(Vote vote);
    void deleteById(Long id);
    Vote findAdById(Long id);
}
