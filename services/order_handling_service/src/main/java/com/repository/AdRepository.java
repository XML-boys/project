package com.repository;

import com.model.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdRepository  extends JpaRepository<Ad, Long> {

    List<Ad> findAll();
    Ad save(Ad ad);
    void deleteById(Long id);
    Ad findAdById(Long id);

}
