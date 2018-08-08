package com.project.packman.packman.service.impl;

import com.project.packman.packman.error.RequestNotFoundException;
import com.project.packman.packman.error.StatusNotFoundException;
import com.project.packman.packman.model.Request;
import com.project.packman.packman.model.RolesType.Status;
import com.project.packman.packman.repository.RequestRepository;
import com.project.packman.packman.service.RequestStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RequestStatusServiceImpl implements RequestStatusService {

    @Autowired
    private RequestRepository requestRepository;

    @Override
    @Transactional
    public void addNewStatus(String id, String status) throws StatusNotFoundException {
        requestRepository.updateRequestStatusById(id, Status.getStatus(status));
    }

    @Override
    public Request findById(String id) throws RequestNotFoundException {
        return requestRepository.findById(id).orElseThrow(() -> new RequestNotFoundException(" Not represent!"));
    }
}
