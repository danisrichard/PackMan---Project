package com.project.packman.packman.service.OfficeMatters.impl.requestService;

import com.project.packman.packman.error.OfficeMatters.RequestNotFoundException;
import com.project.packman.packman.model.OfficeMatters.Request;
import com.project.packman.packman.model.OfficeMatters.RolesType.Priorities;
import com.project.packman.packman.repository.OfficeMatters.RequestRepository;
import com.project.packman.packman.service.OfficeMatters.TriageRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TriageRequestServiceImpl implements TriageRequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Override
    public List<Request> getAllRequest() {
        return requestRepository.findAll();
    }

    @Override
    public Request validateRequest(String id, Priorities priorities) throws RequestNotFoundException {
        Request request = requestRepository.findById(id).orElseThrow(() -> new RequestNotFoundException("This request not represent"));
        request.setPriorities(Collections.singleton(priorities));
        return request;
    }
}
