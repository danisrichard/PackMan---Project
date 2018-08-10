package com.project.packman.packman.controller.CalorieBurners;

import com.project.packman.packman.service.CalorieBurners.IndexPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/team")
public class TeamReviewController {

    @Autowired
    private IndexPageService indexPageService;

    @GetMapping
    public String loadIndexPage(Model model){
        model.addAttribute("teamList",indexPageService.getAllTeamActivities());
        return "calorie-burn/index";
    }
}
