package com.project.packman.packman.repository;

import com.project.packman.packman.model.Request;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RequestRepository extends MongoRepository<Request,String> {
    Optional<Request> findById(String id);

}
