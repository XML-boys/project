package com.Tim5.service;

import com.Tim5.dao.ClientRepository;
import com.Tim5.model.Client;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private ClientRepository clientRepository;

    
    public void blockUser(Long userID) {
        clientRepository.blockUser(userID);
    }
    public void unblockUser(Long userID) {
        clientRepository.unblockUser(userID);
    }

    public List<Client> getAll() {return  Lists.newArrayList(clientRepository.findAll());}

}
