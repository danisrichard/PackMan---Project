package com.project.packman.packman.model.OfficeMatters.RolesType;

import com.project.packman.packman.error.OfficeMatters.PrioritesNotRepresent;

import java.util.EnumSet;

public enum Priorities {
    HIGH, LOW, MEDIUM;

    private String name;

    Priorities() {
    }

    Priorities(String name) {
        this.name = name;
    }

    public static Priorities getPriority(String priorty) throws PrioritesNotRepresent {
        return EnumSet.allOf(Priorities.class).stream()
                .filter(prio -> prio.name().equalsIgnoreCase(priorty))
                .findFirst()
                .orElseThrow(() -> new PrioritesNotRepresent(" Not represent"));
    }
}
