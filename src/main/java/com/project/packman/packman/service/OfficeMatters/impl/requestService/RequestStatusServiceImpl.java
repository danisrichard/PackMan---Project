package com.project.packman.packman.service.OfficeMatters.impl.requestService;

import com.project.packman.packman.error.OfficeMatters.RequestNotFoundException;
import com.project.packman.packman.error.OfficeMatters.StatusNotFoundException;
import com.project.packman.packman.model.OfficeMatters.Request;
import com.project.packman.packman.model.OfficeMatters.RolesType.Status;
import com.project.packman.packman.repository.OfficeMatters.RequestRepository;
import com.project.packman.packman.service.OfficeMatters.RequestStatusService;
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
