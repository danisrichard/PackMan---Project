package com.project.packman.packman.service.OfficeMatters.impl.requestService;

import com.project.packman.packman.error.OfficeMatters.RequestNotFoundException;
import com.project.packman.packman.model.OfficeMatters.Comments;
import com.project.packman.packman.model.OfficeMatters.Request;
import com.project.packman.packman.repository.OfficeMatters.RequestRepository;
import com.project.packman.packman.service.OfficeMatters.RequestCommentService;
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
