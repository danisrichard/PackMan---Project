package com.project.packman.packman.repository.CalorieBurners;

import com.project.packman.packman.model.CalorieBurners.Activities;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivitiesRepository extends MongoRepository<Activities,String> {
}