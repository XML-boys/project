package com.repository;

import com.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("SELECT userId from Reservation where userId =:userId")
    List<Reservation> findByUserId(@Param("userId") Long userId);

    Reservation save(Reservation order);
    void removeById(Long id);

    List<Reservation> findAll();
}
