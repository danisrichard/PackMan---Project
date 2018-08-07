package com.project.packman.packman.controller.homePage;

import com.project.packman.packman.controller.triageController.TriageRequestController;
import com.project.packman.packman.service.RequestService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = {"/","/home","/index"})
@Controller
public class HomePageController {

    private final static Logger logger = LogManager.getLogger(HomePageController.class);

    @Autowired
    private RequestService requestService;

    @GetMapping
    public String loadIndexPage(Model model){
        model.addAttribute("requests",requestService.getAllRequestGroupByStatus());
        return "index";
    }

}
