package com.project.packman.packman.service.OfficeMatters.impl;

import com.project.packman.packman.error.OfficeMatters.RoleNotFoundException;
import com.project.packman.packman.model.OfficeMatters.Roles;
import com.project.packman.packman.model.OfficeMatters.RolesType.RolesType;
import com.project.packman.packman.model.OfficeMatters.Users;
import com.project.packman.packman.repository.OfficeMatters.RoleRepository;
import com.project.packman.packman.repository.OfficeMatters.UsersRepository;
import com.project.packman.packman.service.OfficeMatters.AdminSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashSet;

@Service
public class AdminSectionServiceImpl implements AdminSectionService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    @Transactional
    public Users setRolesToUser(String userId, RolesType rolesType) throws RoleNotFoundException {
        Users users = usersRepository.findById(userId).orElseThrow(() -> new UsernameNotFoundException("Not Found"));
        Roles roles = getRoles(rolesType);
        users.setRoles(new HashSet<>(Collections.singletonList(roles)));
        return users;
    }

    private Roles getRoles(RolesType rolesType) throws RoleNotFoundException {
        return roleRepository.findByRole(String.valueOf(rolesType)).orElseThrow(() -> new RoleNotFoundException(" dsa"));
    }


}
