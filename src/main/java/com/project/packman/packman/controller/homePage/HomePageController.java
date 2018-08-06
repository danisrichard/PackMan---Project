package com.project.packman.packman.controller.homePage;

import com.project.packman.packman.model.Request;
import com.project.packman.packman.model.RolesType.Status;
import com.project.packman.packman.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@RequestMapping(value = {"/","/home","/index"})
public class HomePageController {

    @Autowired
    private RequestService requestService;

    @GetMapping
    public String loadIndexPage(Model model){
        model.addAttribute("requests",requestService.getAllRequest());
        return "index";
    }

}
