package com.Tim5.model;

import javax.persistence.*;

@Entity
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long userId;
    @Column
    private String name;
    @Column
    private Long companyIdentifier;
    @Column
    private String adress;

    public Agent() {
    }

    public Agent(Long userId) {
        this.userId = userId;
    }

    public Agent(Long id, String name, Long companyIdentifier, String adress) {
        this.id = id;
        this.name = name;
        this.companyIdentifier = companyIdentifier;
        this.adress = adress;
    }

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

    public String getIme() {
        return name;
    }

    public void setIme(String name) {
        this.name = name;
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
