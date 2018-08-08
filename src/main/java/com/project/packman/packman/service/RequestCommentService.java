package com.project.packman.packman.service;

import com.project.packman.packman.error.RequestNotFoundException;
import com.project.packman.packman.model.Comments;
import com.project.packman.packman.model.Request;

public interface RequestCommentService {

    void addNewCommentToRequest(String id, Comments comment) throws RequestNotFoundException;

    Request findById(String id) throws RequestNotFoundException;

}
