package com.controller;

import ch.qos.logback.core.net.server.Client;
import com.model.*;
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
                ClientDataDTO clientDataDTO = restService.getClient(jwt);
                Reservation rez = new Reservation();
                rez.setUserId(clientDataDTO.getUserId());
                rez.setState(reservation.getState());
                rez.setEndTime(reservation.getEndTime());
                rez.setStartTime(reservation.getStartTime());
                rez.setReklama(ad);
                rez.setArhivirano(false);
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
                    AgentDataDTO agentDataDTO = restService.getAgent(jwt);
                    Reservation rez = new Reservation();
                    rez.setUserId(agentDataDTO.getUserId());
                    rez.setState("Reserved");
                    rez.setEndTime(reservation.getEndTime());
                    rez.setStartTime(reservation.getStartTime());
                    rez.setArhivirano(false);
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
                    AgentDataDTO agentDataDTO = restService.getAgent(jwt);
                    Reservation rez = new Reservation();
                    rez.setUserId(agentDataDTO.getUserId());
                    rez.setState("Pending");
                    rez.setEndTime(reservation.getEndTime());
                    rez.setStartTime(reservation.getStartTime());
                    rez.setArhivirano(false);
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
                    Ad a = adService.save(ad);
                    reservation.setReklama(new Ad());
                    reservationService.save(reservation);

                    reservationService.remove(idReservation);

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
    public ResponseEntity<?> putReservation(@RequestBody ReservationDTO reservationDTO, @PathVariable Long id, @PathVariable("idReservation") Long idReservation)  {
        Ad ad = adService.findById(id);
        if(ad != null ){
            for(Reservation rez : ad.getReservations()){
                if(rez.getId() == idReservation && rez.getState() != "Reserved"){
                    rez.setState(reservationDTO.getState());
                    rez.setEndTime(reservationDTO.getEndTime());
                    rez.setStartTime(reservationDTO.getStartTime());
                    Reservation reservation = reservationService.save(rez);
                    adService.save(ad);
                    if(reservation != null)
                    {
                        return new ResponseEntity<>(HttpStatus.OK);
                    }else{
                        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
                    }
                }else if (rez.getState() == "Reserved"){
                    return new ResponseEntity<>("Rezervisana vec",HttpStatus.OK);
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

    @GetMapping(value = "/{idAgenta}/agent", produces = "application/json")
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
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        }
    }




}
