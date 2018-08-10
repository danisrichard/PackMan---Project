package com.project.packman.packman.service.OfficeMatters;

import com.project.packman.packman.error.OfficeMatters.RoleNotFoundException;
import com.project.packman.packman.model.OfficeMatters.RolesType.RolesType;
import com.project.packman.packman.model.OfficeMatters.Users;

public interface AdminSectionService {
    Users setRolesToUser(String userId, RolesType rolesType) throws RoleNotFoundException;
}
