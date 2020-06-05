package com.Tim5.model;

import javax.persistence.*;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long userId;
    @Column
    private String firstName;
    @Column
    private String lastName;

    public Admin() {
    }

    public Admin(Long userId) {
        this.userId = userId;
    }

    public Admin(Long id, Long userId, String firstName, String lastName) {
        this.id = id;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
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
        return firstName;
    }

    public void setIme(String ime) {
        this.firstName = firstName;
    }

    public String getPrezime() {
        return lastName;
    }

    public void setPrezime(String lastName) {
        this.lastName = lastName;
    }
}
