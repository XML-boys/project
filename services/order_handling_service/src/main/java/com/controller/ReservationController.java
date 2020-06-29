package com.controller;

import com.model.Ad;
import com.model.Reservation;
import com.model.ReservationDTO;
import com.model.UserValidateDTO;
import com.service.AdService;
import com.service.ReservationService;
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
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping(value = "/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private AdService adService;

    @PostMapping(value = "/{id}")
    public ResponseEntity<Void> saveReservation(@PathVariable("id") Long id, @RequestBody Reservation reservation, HttpServletRequest httpServletRequest)  {
        String requestTokenHeader = httpServletRequest.getHeader("Authorization");
        String jwt = requestTokenHeader.substring(7);
        RestService restService = new RestService(new RestTemplateBuilder());
        UserValidateDTO userValidateDTO = restService.getUserValidate(jwt);

        if(userValidateDTO.getRole().equals("Client")){
            Ad ad = adService.findById(id);
            if(ad != null) {
                Reservation rez = new Reservation();
                rez.setUserId(reservation.getUserId());
                rez.setState(reservation.getState());
                rez.setEndTime(reservation.getEndTime());
                rez.setStartTime(reservation.getStartTime());
                rez.setReklama(ad);
                ad.getReservations().add(reservationService.save(rez));
                Ad a = adService.save(ad);
                if(a != null){
                    return new ResponseEntity<>(HttpStatus.CREATED);
                }else
                {
                    return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
                }
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
            }
        }else if(userValidateDTO.getRole().equals("Agent")){
            Ad ad = adService.findById(id);
            if(ad != null) {
                if(reservation.getUserId() == ad.getIdAgenta()){
                    Reservation rez = new Reservation();
                    rez.setUserId(reservation.getUserId());
                    rez.setState("Reserved");
                    rez.setEndTime(reservation.getEndTime());
                    rez.setStartTime(reservation.getStartTime());
                    rez.setReklama(ad);
                    ad.getReservations().add(reservationService.save(rez));
                    Ad a = adService.save(ad);
                    if(a != null){
                        return new ResponseEntity<>(HttpStatus.CREATED);
                    }else
                    {
                        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
                    }
                }else{
                    Reservation rez = new Reservation();
                    rez.setUserId(reservation.getUserId());
                    rez.setState("Pending");
                    rez.setEndTime(reservation.getEndTime());
                    rez.setStartTime(reservation.getStartTime());
                    rez.setReklama(ad);
                    ad.getReservations().add(reservationService.save(rez));
                    Ad a = adService.save(ad);
                    if(a != null){
                        return new ResponseEntity<>(HttpStatus.CREATED);
                    }else
                    {
                        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
                    }
                }
            }
            return  new ResponseEntity<>(HttpStatus.NOT_MODIFIED);

        } else{
            return  new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Set<Reservation>> getReservations(@PathVariable Long id) {
        Ad ad = adService.findById(id);
        if (ad != null){
            return new ResponseEntity<>(ad.getReservations(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}/{idReservation}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id, @PathVariable("idReservation") Long idReservation) {
        Ad ad = adService.findById(id);
        if(ad != null) {
            for(Reservation reservation : ad.getReservations()){
                if(reservation.getId().equals(idReservation)){
                    ad.getReservations().remove(reservation);
                    reservationService.remove(idReservation);
                    Ad a = adService.save(ad);
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

    @PutMapping(value = "/{id}/{idReservation}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> putReservation(@RequestBody ReservationDTO reservationDTO, @PathVariable Long id, @PathVariable("idReservation") Long idReservation)  {
        Ad ad = adService.findById(id);
        if(ad != null ){
            for(Reservation rez : ad.getReservations()){
                if(rez.getId() == idReservation){
                    rez.setUserId(reservationDTO.getUserId());
                    rez.setState(reservationDTO.getState());
                    rez.setEndTime(reservationDTO.getEndTime());
                    rez.setStartTime(reservationDTO.getStartTime());
                    Reservation reservation = reservationService.save(rez);
                    if(reservation != null)
                    {
                        return new ResponseEntity<>(HttpStatus.OK);
                    }else{
                        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
                    }
                }

            }
        }


        return new ResponseEntity<>((HttpStatus.NOT_MODIFIED));
    }

    @GetMapping(value = "/{id}/{idReservation}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reservation> getReservation(@PathVariable Long id, @PathVariable("idReservation") Long idReservation) {
        Ad ad = adService.findById(id);
        if(ad != null) {
            for(Reservation reservation : ad.getReservations()){
                if(reservation.getId() == idReservation){
                    return new ResponseEntity<>(reservation,HttpStatus.OK);
                }
                else {
                    return new ResponseEntity<>(reservation,HttpStatus.NOT_MODIFIED);
                }
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @PutMapping(value = "/{id}/state", consumes = MediaType.APPLICATION_JSON_VALUE)
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

    @GetMapping(value = "/{id}/state", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getVehicleStatus(@PathVariable Long id){
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

    @GetMapping(value = "/{idAgenta}/agent", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Reservation>> getRezAgent(@PathVariable("idAgenta") Long idAgenta) {
        List<Ad> ads = adService.findAllAds();
        List<Reservation> returnReservation = new ArrayList<>();
        if(ads != null) {
            for(Ad ad : ads){
                if(ad.getIdAgenta() == idAgenta){
                    for(Reservation reservation : ad.getReservations()){
                        returnReservation.add(reservation);
                    }
                }
            }
            return new ResponseEntity<>(returnReservation,HttpStatus.OK);
        } else
        {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }



}
