package com.project.packman.packman.model.OfficeMatters;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Document(collection = "users")
public class Users {

    @Id
    private String id;
    @NotNull
    @Length(min = 3, message = "required min")
    private String username;
    private String password;
    private Set<Roles> roles;

    public Users() {
    }

    public Users(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    public String getId() {
        return id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}