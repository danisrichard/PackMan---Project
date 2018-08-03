package com.project.packman.packman.controller.adminSection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/incoming")
public class AdminIncomingController {

    @GetMapping
    public String inComing(){
        return null;
    }

    @GetMapping("/confirmation")
    public String incomingConfirmation(){
        return null;
    }
}
