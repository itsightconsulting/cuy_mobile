package com.itsight.cuy.domain;

import java.io.Serializable;
import java.util.Set;

public class SecurityRole implements Serializable {

    private String role;

    private Set<SecurityPrivelege> privileges;

    public SecurityRole(){}

    public SecurityRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<SecurityPrivelege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Set<SecurityPrivelege> privileges) {
        this.privileges = privileges;
    }


}