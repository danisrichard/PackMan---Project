package com.project.packman.packman.service;

import com.project.packman.packman.error.RequestNotFoundException;
import com.project.packman.packman.model.Request;

public interface RequestCommentService {

    Request addNewComment(String id, String comment) throws RequestNotFoundException;

    Request findById(String id) throws RequestNotFoundException;

}
