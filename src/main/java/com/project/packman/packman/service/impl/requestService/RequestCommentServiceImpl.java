package com.project.packman.packman.service.impl.requestService;

import com.project.packman.packman.error.RequestNotFoundException;
import com.project.packman.packman.model.Comments;
import com.project.packman.packman.model.Request;
import com.project.packman.packman.repository.RequestRepository;
import com.project.packman.packman.service.RequestCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RequestCommentServiceImpl implements RequestCommentService {

    @Autowired
    private RequestRepository requestRepository;

    @Override
    @Transactional
    public void addNewCommentToRequest(String id, Comments comment) throws RequestNotFoundException {
        requestRepository.findById(id).orElseThrow(() -> new RequestNotFoundException(" Not represent!"));
        requestRepository.addCommentToRequestById(id,comment);
    }

    @Override
    public Request findById(String id) throws RequestNotFoundException {
        return requestRepository.findById(id).orElseThrow(() -> new RequestNotFoundException("Not found"));
    }
}
