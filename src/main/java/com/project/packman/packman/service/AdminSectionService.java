package com.project.packman.packman.service;

import com.project.packman.packman.error.RoleNotFoundException;
import com.project.packman.packman.model.Request;
import com.project.packman.packman.model.RolesType.RolesType;
import com.project.packman.packman.model.Users;

import java.util.List;

public interface AdminSectionService {
    Users setRolesToUser(String userId, RolesType rolesType) throws RoleNotFoundException;
}
