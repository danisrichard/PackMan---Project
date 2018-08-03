package com.project.packman.packman.service;

import com.project.packman.packman.model.Users;

import java.util.List;

public interface UserRegistrationService {

    Users saveUser(Users users);

    List<Users> findAll();
}
