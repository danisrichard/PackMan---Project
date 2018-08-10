package com.project.packman.packman.controller.OfficeMatters.triageController;

import com.project.packman.packman.error.OfficeMatters.PrioritesNotRepresent;
import com.project.packman.packman.error.OfficeMatters.RequestNotFoundException;
import com.project.packman.packman.model.OfficeMatters.RolesType.Priorities;
import com.project.packman.packman.service.OfficeMatters.TriageRequestService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/triage")
public class TriageRequestController{

    private final static Logger logger = LogManager.getLogger(TriageRequestController.class);

    @Autowired
    private TriageRequestService triageRequestService;

    @GetMapping
    public String getAllRequest(Model model){
        model.addAttribute("triage",triageRequestService.getAllRequest());
        return "triage-section/triage-index";
    }


    @RequestMapping(value = "/{requestId}", method = RequestMethod.GET)
    public String addPriority(@PathVariable(value = "requestId") String requestId, @RequestParam(value="priority") String priority) throws PrioritesNotRepresent, RequestNotFoundException {
        logger.info("Id: {} , priority: {}",requestId,priority);
        Priorities priorities = Priorities.getPriority(priority);
        triageRequestService.validateRequest(requestId, priorities);
        return "redirect:/triage";
    }
}
