package com.Tim5.dao;

import com.Tim5.model.Agent;
import org.springframework.data.repository.CrudRepository;

public interface AgentRepository extends CrudRepository<Agent, Long> {

    Agent findAgentByUserId(Long id);
}
