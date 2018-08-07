package com.project.packman.packman.controller.requestCommentController;

import com.project.packman.packman.error.RequestNotFoundException;
import com.project.packman.packman.service.RequestCommentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/comment")
public class RequestCommentController {

    private final static Logger logger = LogManager.getLogger(RequestCommentController.class);

    @Autowired
    private RequestCommentService commentService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String getRequestCommentById(Model model, @PathVariable(value = "id") String id) throws RequestNotFoundException {
        logger.info(id);
        model.addAttribute("request",commentService.findById(id));
        return "request-comment-section/request-comment-index";
    }
}
