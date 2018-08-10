package com.project.packman.packman.controller.CalorieBurners;

import com.project.packman.packman.error.CalorieBurners.TeamNotFoundException;
import com.project.packman.packman.error.CalorieBurners.UserNotFoundException;
import com.project.packman.packman.model.CalorieBurners.Activities;
import com.project.packman.packman.model.CalorieBurners.User;
import com.project.packman.packman.service.CalorieBurners.UserActivitesService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
@RequestMapping("/team")
public class UserActivitiesController {

    private final static Logger logger = LogManager.getLogger(UserActivitiesController.class);

    @Autowired
    private UserActivitesService userActivitesService;

    @GetMapping("/{teamId}/activity/{id}")
    public @ResponseBody
    User getUserById(@PathVariable(value = "teamId") String teamId, @PathVariable(value = "id") String id, Model model) throws TeamNotFoundException, UserNotFoundException {
        model.addAttribute("activity", new Activities());
        return userActivitesService.getUserByUUID(UUID.fromString(id),teamId);
    }
}
