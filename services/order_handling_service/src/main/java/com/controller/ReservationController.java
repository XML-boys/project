package com.controller;

import com.model.Reservation;
import com.model.ReservationDTO;
import com.model.State;
import com.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> saveReservation(@RequestBody ReservationDTO reservationDTO)  {
        Reservation reservation = new Reservation();
        reservation.setUserId(reservationDTO.getUserId());
        reservation.setReklama(reservationDTO.getReklama());
        reservation.setStartTime(reservationDTO.getStartTime());
        reservation.setEndTime(reservationDTO.getEndTime());
        reservation.setState("Pending");

        reservationService.save(reservation);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(consumes = "application/json" , produces = "application/json")
    public ResponseEntity<List<ReservationDTO>> getReservations() {
        List<Reservation> reservations = reservationService.findAll();
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

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationService.remove(id);
        return new ResponseEntity<>((HttpStatus.OK));
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<Void> putReservation(@RequestBody ReservationDTO reservationDTO, @PathVariable Long id)  {
        List<Reservation> reservations = reservationService.findAll();
        if(reservations != null){
            for(Reservation reservation : reservations)
            {
                if(reservation.getId() == id)
                {
                    reservation.setUserId(reservationDTO.getUserId());
                    reservation.setReklama(reservationDTO.getReklama());
                    reservation.setStartTime(reservationDTO.getStartTime());
                    reservation.setEndTime(reservationDTO.getEndTime());
                    reservation.setState("Pending");

                    reservationService.save(reservation);
                }
            }
        }


        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reservation> getReservation(@PathVariable Long id) {
        List<Reservation> reservations = reservationService.findAll();
        if(reservations != null)
        {
            for(Reservation reservation : reservations)
            {
                if(reservation.getId() == id){
                    return new ResponseEntity<>(reservation, HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/{id}/state", consumes = "application/json")
    public ResponseEntity<Void> putVehicleStatus(@RequestBody String state, @PathVariable Long id) {
        List<Reservation> reservations = reservationService.findAll();
        if(reservations != null)
        {
            for(Reservation r : reservations)
            {
                if(r.getId() == id){
                    r.setState(state);
                    reservationService.save(r);
                    return new ResponseEntity<>(HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}/state")
    public ResponseEntity<State> getVehicleStatus(@PathVariable Long id){
        List<Reservation> reservations = reservationService.findAll();
        if(reservations != null)
        {
            for(Reservation r : reservations)
            {
                return new ResponseEntity<>(r.getState(), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



}
