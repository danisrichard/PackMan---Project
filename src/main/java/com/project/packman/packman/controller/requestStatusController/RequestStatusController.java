package com.project.packman.packman.controller.requestStatusController;

import com.project.packman.packman.error.RequestNotFoundException;
import com.project.packman.packman.error.StatusNotFoundException;
import com.project.packman.packman.service.RequestStatusService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/status")
public class RequestStatusController {

    private final static Logger logger = LogManager.getLogger(RequestStatusController.class);

    @Autowired
    private RequestStatusService requestStatusService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String getRequestCommentById(Model model, @PathVariable(value = "id") String id) throws RequestNotFoundException {
        model.addAttribute("request",requestStatusService.findById(id));
        return "request-status-section/request-status-section";
    }

    @RequestMapping(value="/{id}/add", method = RequestMethod.GET)
    public String setStatus(@RequestParam("requestStatus") String status, @PathVariable String id,Model model) throws RequestNotFoundException, StatusNotFoundException {
        requestStatusService.addNewStatus(id,status);
        return "redirect:/home";
    }
}
