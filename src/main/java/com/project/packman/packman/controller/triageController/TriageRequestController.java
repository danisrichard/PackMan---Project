package com.project.packman.packman.controller.triageController;

import com.project.packman.packman.service.TriageRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/triage")
public class TriageRequestController {

    @Autowired
    private TriageRequestService triageRequestService;


    @GetMapping
    public String getAllRequest(Model model){
        model.addAttribute("triage",triageRequestService.getAllRequest());
        return "triage-section/triage-index";
    }

}
