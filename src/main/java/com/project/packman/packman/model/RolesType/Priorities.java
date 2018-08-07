package com.project.packman.packman.model.RolesType;

import com.project.packman.packman.error.PrioritesNotRepresent;

import java.util.EnumSet;
import java.util.Optional;

public enum Priorities {
    HIGH, LOW, MEDIUM;

    private String name;

    Priorities() {
    }

    Priorities(String name) {
        this.name = name;
    }

    public static Priorities getPriority(String priorty) throws PrioritesNotRepresent {
        return EnumSet.allOf(Priorities.class).stream().filter(prio -> prio.name().equalsIgnoreCase(priorty)).findFirst().orElse(null);
    }
}
