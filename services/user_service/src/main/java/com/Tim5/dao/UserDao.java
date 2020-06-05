package com.Tim5.dao;

import com.Tim5.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface UserDao extends CrudRepository<User, Long> {

    User findByUsername(String username);

}
