package com.project.packman.packman.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class Comments {

    @NotEmpty
    @NotNull
    private String comment;
    private LocalDate date;

    public Comments(@NotEmpty @NotNull String comment) {
        this.comment = comment;
        this.date = LocalDate.now();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getDate() {
        return date;
    }
}
