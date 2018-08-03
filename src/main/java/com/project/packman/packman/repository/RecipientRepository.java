package com.project.packman.packman.repository;

import com.project.packman.packman.model.Recipient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipientRepository extends MongoRepository<Recipient,String> {
}
