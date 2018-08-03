package com.project.packman.packman.controller.adminSection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminParcelController {

    @GetMapping("/parcels")
    public String listOfParcels() {
        return "im fucking admin";
    }

}
