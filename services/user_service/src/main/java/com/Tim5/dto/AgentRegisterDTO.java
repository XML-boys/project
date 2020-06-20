package com.Tim5.dto;

public class AgentRegisterDTO {

    private String username;
    private String password;
    private String email;
    private String name;
    private Long companyIdentifier;
    private String adress;

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
