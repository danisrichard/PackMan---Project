package com.project.packman.packman.controller.OfficeMatters.userAccessSection;

import com.project.packman.packman.error.OfficeMatters.RoleNotFoundException;
import com.project.packman.packman.model.OfficeMatters.Users;
import com.project.packman.packman.service.OfficeMatters.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Controller
public class UserRegistrationController implements WebMvcConfigurer {

    @Autowired
    private UserRegistrationService userService;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login");
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        Users user = new Users();
        model.addAttribute("user", user);
        return "/log-and-reg-section/registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String createNewUser(@Valid Users user, BindingResult bindingResult, Model model) throws RoleNotFoundException {
        if (bindingResult.hasErrors()) {
            return "/log-and-reg-section/registration";
        }
        model.addAttribute("successMessage", "User has been registered successfully");
        userService.saveUser(user);
        return "/log-and-reg-section/login";
    }
}

