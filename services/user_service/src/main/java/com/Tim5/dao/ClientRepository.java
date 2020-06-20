package com.Tim5.dao;

import com.Tim5.model.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {

    @Query("UPDATE Client set blocked = ?2 WHERE id = ?1")
    void blockUpdate(Long id, Boolean blocked);

    Client findClientByUserId(Long id);

}
