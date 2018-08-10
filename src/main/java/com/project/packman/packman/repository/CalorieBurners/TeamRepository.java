package com.project.packman.packman.repository.CalorieBurners;

import com.project.packman.packman.model.CalorieBurners.Team;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends MongoRepository<Team,String> {
}
