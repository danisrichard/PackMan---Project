package com.project.packman.packman.controller.OfficeMatters.userAccessSection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class UserLoginController {

    @GetMapping(value = "/login")
    public String login(Principal principal) {
        if (principal != null) {
            return "redirect: /pet";
        }
        return "log-and-reg-section/login";
    }
}
