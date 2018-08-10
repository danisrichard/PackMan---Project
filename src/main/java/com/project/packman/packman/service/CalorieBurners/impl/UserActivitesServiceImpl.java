package com.project.packman.packman.service.CalorieBurners.impl;

import com.project.packman.packman.error.CalorieBurners.TeamNotFoundException;
import com.project.packman.packman.error.CalorieBurners.UserNotFoundException;
import com.project.packman.packman.model.CalorieBurners.Activities;
import com.project.packman.packman.model.CalorieBurners.User;
import com.project.packman.packman.repository.CalorieBurners.TeamRepository;
import com.project.packman.packman.service.CalorieBurners.UserActivitesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import java.util.UUID;

@Controller
public class UserActivitesServiceImpl implements UserActivitesService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public User getUserByUUID(UUID userId, String teamId) throws TeamNotFoundException, UserNotFoundException {
        return teamRepository.findById(teamId)
                .orElseThrow(() -> new TeamNotFoundException("Team"))
                .getUserList()
                .stream()
                .filter(anUserList -> anUserList.getId().equals(userId))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User"));
    }

    @Override
    public User setActivities(@Valid Activities activities) {
        return null;
    }
}
