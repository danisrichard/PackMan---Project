package com.project.packman.packman.service.impl.requestService;

import com.project.packman.packman.error.RequestNotFoundException;
import com.project.packman.packman.model.Request;
import com.project.packman.packman.model.RolesType.Priorities;
import com.project.packman.packman.repository.RequestRepository;
import com.project.packman.packman.service.TriageRequestService;
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
