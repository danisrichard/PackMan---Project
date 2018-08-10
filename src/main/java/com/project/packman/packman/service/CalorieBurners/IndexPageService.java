package com.project.packman.packman.service.CalorieBurners;

import com.project.packman.packman.model.CalorieBurners.Team;
import com.project.packman.packman.model.CalorieBurners.User;

import java.util.List;

public interface IndexPageService {

    List<Team> getAllTeamActivities();

    List<User> getAllUserActivities();
}
