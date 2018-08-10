package com.project.packman.packman.service.CalorieBurners.impl;

import com.project.packman.packman.model.CalorieBurners.Team;
import com.project.packman.packman.repository.CalorieBurners.TeamRepository;
import com.project.packman.packman.service.CalorieBurners.NewTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.validation.Valid;

@Repository
public class NewTeamServiceImpl implements NewTeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Team addNewTeam(@Valid Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Team findById(String id) {
        return teamRepository.findById(id).orElseThrow(() -> new NullPointerException("dsa"));
    }
}
