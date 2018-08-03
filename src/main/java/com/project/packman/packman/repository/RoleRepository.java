package com.project.packman.packman.repository;

import com.project.packman.packman.model.Roles;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<Roles,String> {
    Roles findByRole(String role);
}
