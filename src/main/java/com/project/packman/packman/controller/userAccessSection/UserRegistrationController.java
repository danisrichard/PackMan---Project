package com.project.packman.packman.controller.userAccessSection;

import com.project.packman.packman.error.RoleNotFoundException;
import com.project.packman.packman.model.Users;
import com.project.packman.packman.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class UserRegistrationController {

    @Autowired
    private UserRegistrationService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        Users user = new Users();
        model.addAttribute("user", user);
        return "/log-and-reg-section/registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String createNewUser(@Valid Users user, BindingResult bindingResult, Model model) throws RoleNotFoundException {
        if (!bindingResult.hasErrors()) {
            userService.saveUser(user);
            model.addAttribute("successMessage", "User has been registered successfully");
            model.addAttribute("user", new Users());
            return "/log-and-reg-section/login";
        }

        return "/log-and-reg-section/registration";
    }

}

