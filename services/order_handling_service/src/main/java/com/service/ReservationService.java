package com.service;

import com.model.Reservation;
import com.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    public ReservationRepository reservationRepository;

    public List<Reservation> pronadjiPoUserId(Long userId){
        return reservationRepository.findByUserId(userId);
    }

    public List<Reservation> findAll(){
        return reservationRepository.findAll();
    }

    public Reservation save(Reservation order){
        return reservationRepository.save(order);
    }

    public void remove(Long id){
        reservationRepository.deleteById(id);
    }

    public Reservation findById(Long id) {return reservationRepository.findById(id).orElseGet(null);}
}
