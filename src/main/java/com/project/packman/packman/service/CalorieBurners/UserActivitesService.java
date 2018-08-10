package com.project.packman.packman.service.CalorieBurners;

import com.project.packman.packman.error.CalorieBurners.TeamNotFoundException;
import com.project.packman.packman.error.CalorieBurners.UserNotFoundException;
import com.project.packman.packman.model.CalorieBurners.Activities;
import com.project.packman.packman.model.CalorieBurners.User;

import javax.validation.Valid;
import java.util.UUID;

public interface UserActivitesService {

    User getUserByUUID(UUID userId,String teamId) throws TeamNotFoundException, UserNotFoundException;

    User setActivities(@Valid Activities activities);
}
