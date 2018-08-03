package com.project.packman.packman.controller.adminSection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/handover")
public class AdminHandoverController {

    @GetMapping
    public String handover(){
        return null;
    }

    @GetMapping("/confirmation")
    public String handoverConfirmation(){
        return null;
    }
}
