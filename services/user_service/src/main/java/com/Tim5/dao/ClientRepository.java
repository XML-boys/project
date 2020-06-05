package com.Tim5.dao;

import com.Tim5.model.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {

    @Query("UPDATE Client set blocked = 1 WHERE id = ?1")
    void blockUser(Long id);

    @Query("UPDATE Client set blocked = 0 WHERE id = ?1")
    void unblockUser(Long id);


}
