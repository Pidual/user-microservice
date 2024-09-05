package com.emazon.user_microservice.domain.model;

public class Rol {

    private String rolName;

    private String rolDescription;

    public Rol(String rolName, String rolDescription) {
        this.rolName = rolName;
        this.rolDescription = rolDescription;
    }

    public String getRolName() {
        return rolName;
    }

    public void setRolName(String rolName) {
        this.rolName = rolName;
    }

    public String getRolDescription() {
        return rolDescription;
    }

    public void setRolDescription(String rolDescription) {
        this.rolDescription = rolDescription;
    }
}
