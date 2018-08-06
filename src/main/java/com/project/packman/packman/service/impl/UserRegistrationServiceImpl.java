package com.project.packman.packman.service.impl;

import com.project.packman.packman.error.RoleNotFoundException;
import com.project.packman.packman.model.Roles;
import com.project.packman.packman.model.RolesType.RolesType;
import com.project.packman.packman.model.Users;
import com.project.packman.packman.repository.RoleRepository;
import com.project.packman.packman.repository.UsersRepository;
import com.project.packman.packman.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService, UserDetailsService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersRepository userRepository;

    @Override
    public Users saveUser(@Valid Users users) throws RoleNotFoundException,UsernameNotFoundException {
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        Roles userRoles = roleRepository.findByRole(String.valueOf(RolesType.ROLE_DISPATCHER)).orElseThrow(() -> new RoleNotFoundException("dsa"));
        users.setRoles(new HashSet<>(Collections.singletonList(userRoles)));
        return userRepository.save(users);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(s).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
        return new User(user.getUsername(), user.getPassword(), authorities);
    }

    private List<GrantedAuthority> getUserAuthority(Set<Roles> userRoles) {
        return userRoles.stream().map(roles -> new SimpleGrantedAuthority(roles.getRole())).distinct().collect(Collectors.toList());
    }

    @Override
    public List<Users> findAll() {
        return userRepository.findAll();
    }
}
