package com.project.packman.packman.model;

import com.project.packman.packman.model.RolesType.Priorities;
import com.project.packman.packman.model.RolesType.Status;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Document
public class Request {

    @Id
    private String id;
    @NotEmpty
    private String users;
    @NotNull
    private String email;
    @NotEmpty
    @Length(min = 3, max = 10)
    private String subject;
    private String desc;
    private Set<Priorities> priorities;
    private Status statuses;
    private List<Comments> comments;

    public Request() {
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(Comments comment) {
        comments.add(comment);
    }

    public Status getStatuses() {
        return statuses;
    }

    public void setStatuses(Status statuses) {
        this.statuses = statuses;
    }

    public Set<Priorities> getPriorities() {
        return priorities;
    }

    public void setPriorities(Set<Priorities> priorities) {
        this.priorities = priorities;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id='" + id + '\'' +
                ", users=" + users +
                ", email='" + email + '\'' +
                ", subject='" + subject + '\'' +
                ", desc='" + desc + '\'' +
                ", priorites=" + priorities +
                ", statuses=" + statuses +
                '}';
    }
}
