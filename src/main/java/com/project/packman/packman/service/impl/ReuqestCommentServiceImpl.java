package com.project.packman.packman.service.impl;

import com.project.packman.packman.error.RequestNotFoundException;
import com.project.packman.packman.model.Request;
import com.project.packman.packman.repository.RequestRepository;
import com.project.packman.packman.service.RequestCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ReuqestCommentServiceImpl implements RequestCommentService {

    @Autowired
    private RequestRepository requestRepository;

    @Override
    @Transactional
    public Request addNewComment(String id,String comment) throws RequestNotFoundException {
        Request request = requestRepository.findById(id).orElseThrow(() -> new RequestNotFoundException(" Not represent!"));
        request.setComments(comment);
        return request;
    }

    @Override
    public Request findById(String id) throws RequestNotFoundException {
        return requestRepository.findById(id).orElseThrow(() -> new RequestNotFoundException("Not found"));
    }
}
