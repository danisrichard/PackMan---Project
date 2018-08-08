package com.project.packman.packman.controller;

import com.project.packman.packman.error.PrioritesNotRepresent;
import com.project.packman.packman.error.RequestNotFoundException;
import com.project.packman.packman.error.RoleNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody
    String handleUserNameNotFound(final UsernameNotFoundException userNotFoundExp) {
        return userNotFoundExp.getMessage();
    }

    @ExceptionHandler(RoleNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody
    String handleRoleNotFound(final RoleNotFoundException roleNotFound) {
        return roleNotFound.getMessage();
    }

    @ExceptionHandler(PrioritesNotRepresent.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody
    String handlePrioritesNotFound(final PrioritesNotRepresent prioritesNotRepresent) {
        return prioritesNotRepresent.getMessage();
    }

    @ExceptionHandler(RequestNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody
    String handleRequestNotFound(final RequestNotFoundException requestNotFound) {
        return requestNotFound.getMessage();
    }
}
