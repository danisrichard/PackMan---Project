package com.project.packman.packman.repository.CustomQueryRequestRepositoryImpl;

import com.project.packman.packman.controller.requestCommentController.RequestCommentController;
import com.project.packman.packman.model.Comments;
import com.project.packman.packman.model.Request;
import com.project.packman.packman.model.RolesType.Status;
import com.project.packman.packman.repository.CustomQueryRequestRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class CustomQueryRequestRepositoryImpl implements CustomQueryRequestRepository {

    private final static Logger logger = LogManager.getLogger(CustomQueryRequestRepositoryImpl.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void updateRequestStatusById(String id, Status status) {
        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update();
        update.set("statuses",status);
        mongoTemplate.update(Request.class).matching(query).apply(update).first();
    }

    @Override
    public void addCommentToRequestById(String id, Comments comments) {
        
    }
}
