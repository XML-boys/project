package com.Tim5.dto;

import javax.persistence.Column;

public class AgentDataDTO {

    private Long id;
    private Long userId;
    private String username;
    private String email;
    private String name;
    private Long companyIdentifier;
    private String adress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCompanyIdentifier() {
        return companyIdentifier;
    }

    public void setCompanyIdentifier(Long companyIdentifier) {
        this.companyIdentifier = companyIdentifier;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
