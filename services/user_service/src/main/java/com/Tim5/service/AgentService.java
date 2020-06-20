package com.Tim5.service;

import com.Tim5.dao.AgentRepository;
import com.Tim5.model.Agent;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentService {

    @Autowired
    private AgentRepository agentRepository;

    public Agent save(Agent agent) {return agentRepository.save(agent);}

    public Agent findById(Long id) {return  agentRepository.findById(id).orElseGet(null);}

    public Agent findByUserId(Long id) {return  agentRepository.findAgentByUserId(id);}

    public List<Agent> findAll() {return Lists.newArrayList(agentRepository.findAll());}

}
