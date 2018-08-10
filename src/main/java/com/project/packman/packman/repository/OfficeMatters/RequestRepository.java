package com.project.packman.packman.repository.OfficeMatters;

import com.project.packman.packman.model.OfficeMatters.Request;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RequestRepository extends MongoRepository<Request,String>,CustomQueryRequestRepository {
    Optional<Request> findById(String id);
}
