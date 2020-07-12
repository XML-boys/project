package com.service;

import com.model.Ad;
import com.repository.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdService {

    @Autowired
    private AdRepository adRepository;

    public List<Ad> findAllAds() { return adRepository.findAll(); }
    public Ad save(Ad ad) {
        return adRepository.save(ad);
    }
    public void remove(Long id) {
        adRepository.deleteById(id);
    }

    public Ad findById(Long id){
        return adRepository.findAdById(id);
    }

    public List<Ad> findAdsByVehicle(Long vehicleId) { return adRepository.findAllByVehicleId(vehicleId); }

    public List<Ad> findAdsByAgentId(Long agentId) { return adRepository.findAllByIdAgenta(agentId); }

}
