package com.project.packman.packman.service.OfficeMatters;

import com.project.packman.packman.error.OfficeMatters.RequestNotFoundException;
import com.project.packman.packman.model.OfficeMatters.Comments;
import com.project.packman.packman.model.OfficeMatters.Request;

public interface RequestCommentService {

    void addNewCommentToRequest(String id, Comments comment) throws RequestNotFoundException;

    Request findById(String id) throws RequestNotFoundException;

}
