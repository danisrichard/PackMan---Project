package com.project.packman.packman.model;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Document
public class Recipient {

    @Id
    private String id;
    @NotEmpty(message = "*Please provide your password")
    @NotNull(message = "Please write this field")
    private String name;
    @NotEmpty(message = "*Please provide your password")
    @DateTimeFormat(pattern = "yyyyMMdd")
    @NotNull
    @FutureOrPresent
    private Date date;
    private String description;

    public Recipient() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
