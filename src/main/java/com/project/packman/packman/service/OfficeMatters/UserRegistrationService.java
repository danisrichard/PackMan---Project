package com.project.packman.packman.service.OfficeMatters;

import com.project.packman.packman.error.OfficeMatters.RoleNotFoundException;
import com.project.packman.packman.model.OfficeMatters.Users;

import java.util.List;

public interface UserRegistrationService {

    Users saveUser(Users users) throws RoleNotFoundException;

    List<Users> findAll();
}
