package com.project.packman.packman.repository.OfficeMatters.CustomQueryRequestRepositoryImpl;

import com.project.packman.packman.model.OfficeMatters.Comments;
import com.project.packman.packman.model.OfficeMatters.Request;
import com.project.packman.packman.model.OfficeMatters.RolesType.Status;
import com.project.packman.packman.repository.OfficeMatters.CustomQueryRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class CustomQueryRequestRepositoryImpl implements CustomQueryRequestRepository {

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
        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update();
        update.addToSet("comments",comments);
        mongoTemplate.update(Request.class).matching(query).apply(update).first();
    }
}
