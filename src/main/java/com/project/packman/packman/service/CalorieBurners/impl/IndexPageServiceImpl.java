package com.project.packman.packman.service.CalorieBurners.impl;

import com.project.packman.packman.model.CalorieBurners.Team;
import com.project.packman.packman.model.CalorieBurners.User;
import com.project.packman.packman.repository.CalorieBurners.TeamRepository;
import com.project.packman.packman.service.CalorieBurners.IndexPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IndexPageServiceImpl implements IndexPageService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public List<Team> getAllTeamActivities() {
        List<Team> teamList = teamRepository.findAll();

        return null;
    }

    @Override
    public List<User> getAllUserActivities() {
        return null;
    }
}
