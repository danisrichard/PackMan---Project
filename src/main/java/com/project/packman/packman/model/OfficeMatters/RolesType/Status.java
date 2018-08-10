package com.project.packman.packman.model.OfficeMatters.RolesType;

import com.project.packman.packman.error.OfficeMatters.StatusNotFoundException;

import java.util.EnumSet;

public enum Status {
    NEW_REQUESTS, IN_PROGRESS, RESOLVED;

    private String statusName;

    Status() {
    }

    public static Status getStatus(String status) throws StatusNotFoundException {
        return EnumSet.allOf(Status.class).stream()
                    .filter(stat -> stat.name().equalsIgnoreCase(status))
                    .findFirst()
                    .orElseThrow(() -> new StatusNotFoundException("Status not represent"));
    }
}
