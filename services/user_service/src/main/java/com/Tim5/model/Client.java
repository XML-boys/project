package com.Tim5.model;

import javax.persistence.*;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long userId;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String adress;
    @Column
    private Boolean blocked;

    public Client() {
    }

    public Client(Long userId) {
        this.userId = userId;
        this.blocked = false;
    }

    public Client(Long id, String firstName, String lastName, String adress, Boolean blocked) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.blocked = blocked;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }
}
