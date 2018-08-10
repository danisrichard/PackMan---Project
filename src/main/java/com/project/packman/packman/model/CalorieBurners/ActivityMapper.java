package com.project.packman.packman.model.CalorieBurners;

import java.util.Objects;

public class ActivityMapper {

    private String collectorIndividual;
    private int activitiesInMinutes;
    private String calories;

    public ActivityMapper() {
    }

    public String getCollectorIndividual() {
        return collectorIndividual;
    }

    public void setCollectorIndividual(String collectorIndividual) {
        this.collectorIndividual = collectorIndividual;
    }

    public int getActivitiesInMinutes() {
        return activitiesInMinutes;
    }

    public void addActivitiesInMinutes(int addNewMinutes) {
        activitiesInMinutes += addNewMinutes;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivityMapper that = (ActivityMapper) o;
        return Objects.equals(collectorIndividual, that.collectorIndividual);
    }

    @Override
    public int hashCode() {
        return Objects.hash(collectorIndividual);
    }
}
