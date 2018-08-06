package com.project.packman.packman.model.RolesType;

import org.springframework.security.core.GrantedAuthority;

public enum RolesType implements GrantedAuthority {
    ROLE_REPORTER,ROLE_SPECIALIST,ROLE_DISPATCHER;

    RolesType() {
    }

    @Override
    public String getAuthority() {
        return name();
    }
}
