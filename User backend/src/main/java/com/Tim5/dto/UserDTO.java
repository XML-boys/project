package com.Tim5.dto;

import com.Tim5.model.ROLE;

public class UserDTO {
    private String username;
    private String password;
    private ROLE role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role.name();
    }

    public void setRole(String role) {
        this.role = ROLE.valueOf(role);
    }
}
