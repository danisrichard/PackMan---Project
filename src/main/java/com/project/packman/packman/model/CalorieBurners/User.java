package com.project.packman.packman.model.CalorieBurners;

import java.util.List;
import java.util.UUID;

public class User {

    private UUID id;
    private String name;
    private List<Activities> activitiesList;

    public User() {
        id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getActivitiesSumDuration() {
        return activitiesList.stream().mapToInt(Activities::getDuration).sum();
    }

    public int getActivitesSumTime(){
        return activitiesList.stream().mapToInt(Activities::getDuration).sum();
    }

    public void setActivitiesList(List<Activities> activitiesList) {
        this.activitiesList = activitiesList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", activitiesList=" + activitiesList +
                '}';
    }
}
