package com.controller;

import com.model.Reservation;
import com.model.ReservationDTO;
import com.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping(path = "/saveReservation", consumes = "application/json")
    public ResponseEntity<Void> saveReservation(@RequestBody ReservationDTO reservationDTO)  {
        Reservation reservation = new Reservation();
        reservation.setUserId(reservationDTO.getUserId());
        //reservation.setReklama(reservationDTO.getAd());
        reservation.setStartTime(reservationDTO.getStartTime());
        reservation.setEndTime(reservationDTO.getEndTime());

        reservationService.save(reservation);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(path = "/getReservation", consumes = "application/json")
    public ResponseEntity<List<ReservationDTO>> getReservation(@RequestBody Long userId) {
        List<Reservation> reservations = reservationService.pronadjiPoUserId(userId);
        List<ReservationDTO> reservationDTOS= new ArrayList<>();
        if(reservations != null)
        {
            for(Reservation r : reservations)
            {
                reservationDTOS.add(new ReservationDTO(r));
            }
        }
        return new ResponseEntity<>(reservationDTOS, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteReservation/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationService.remove(id);
        return new ResponseEntity<>((HttpStatus.OK));
    }
}
