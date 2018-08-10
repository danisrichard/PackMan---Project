package com.project.packman.packman.controller.CalorieBurners;

import com.project.packman.packman.model.CalorieBurners.Team;
import com.project.packman.packman.service.CalorieBurners.NewTeamService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class TeamRegistrationController {

    private final static Logger logger = LogManager.getLogger(TeamRegistrationController.class);

    @Autowired
    private NewTeamService newTeamService;

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String getNewRequest(Model model) {
        model.addAttribute("team", new Team());
        return "calorie-burn/reg/registration";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String validateRequest(Model model, @Valid Team team, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "calorie-burn/reg/registration";
        }
        return "redirect:/registration/check/" + newTeamService.addNewTeam(team).getId();
    }

    @GetMapping("check/{id}")
    public String getRequestDetails(@PathVariable final String id,Model model) {
        model.addAttribute("team",newTeamService.findById(id));
        return "calorie-burn/reg/confirmation";
    }
}
