package com.emazon.usermicroservice.domain.model;

public class Role {

    private String rolName;

    private String roleDescription;

    public Role(String rolName, String roleDescription) {
        this.rolName = rolName;
        this.roleDescription = roleDescription;
    }

    public String getRoleName() {
        return rolName;
    }

    public void setRoleName(String rolName) {
        this.rolName = rolName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
