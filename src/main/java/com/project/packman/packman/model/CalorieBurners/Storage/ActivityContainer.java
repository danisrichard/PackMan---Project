package com.project.packman.packman.model.CalorieBurners.Storage;

public enum ActivityContainer {
    WEIGHT_LIFTING(112), AEROBICS(149), YOGA(149), RIDER(186), CYCLING(260);

    private int activitiesValue;

    ActivityContainer() {
    }

    ActivityContainer(int activitiesValue) {
        this.activitiesValue = activitiesValue;
    }

    public int getActivitiesValue() {
        return activitiesValue;
    }
}
