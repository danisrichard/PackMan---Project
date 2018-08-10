package com.project.packman.packman.service.CalorieBurners;

import com.project.packman.packman.model.CalorieBurners.Team;

import javax.validation.Valid;

public interface NewTeamService {
    Team addNewTeam(@Valid Team team);

    Team findById(String id);
}
