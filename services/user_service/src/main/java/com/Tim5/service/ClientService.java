package com.Tim5.service;

import com.Tim5.dao.ClientRepository;
import com.Tim5.dto.LongBoolDTO;
import com.Tim5.model.Client;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;


    public void blockUser(Long id ) {
        clientRepository.blockUpdate(id, true);
    }

    public List<Client> getAll() {return  Lists.newArrayList(clientRepository.findAll());}

    public Client findByID(Long id) {return  clientRepository.findById(id).orElseGet(null);}

    public Client save(Client client) { return  clientRepository.save(client);}

    public Client findByUserId(Long id) {return  clientRepository.findClientByUserId(id);}

    public void delete(Long id) { clientRepository.deleteById(id);}

}
