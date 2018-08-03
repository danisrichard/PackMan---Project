package com.project.packman.packman.controller.petlist;

import com.project.packman.packman.model.Users;
import com.project.packman.packman.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private UserRegistrationService registrationService;

    @GetMapping()
    public Collection<SimpleGrantedAuthority> getPets(){
        return (Collection<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
    }

    @GetMapping("/user")
    public List<Users> getuser(){
        return registrationService.findAll();
    }
}
