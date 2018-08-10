package com.project.packman.packman.service.OfficeMatters.impl.requestService;

import com.project.packman.packman.error.OfficeMatters.RequestNotFoundException;
import com.project.packman.packman.model.OfficeMatters.Request;
import com.project.packman.packman.model.OfficeMatters.RolesType.Status;
import com.project.packman.packman.repository.OfficeMatters.RequestRepository;
import com.project.packman.packman.service.OfficeMatters.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Override
    @Transactional
    public Request saveNewRequest(@Valid Request request) {
        request.setStatuses(Status.NEW_REQUESTS);
        return requestRepository.save(request);
    }

    @Override
    public synchronized HashMap<Status, List<Request>> getAllRequestGroupByStatus() {
        List<Request> requestList = requestRepository.findAll();
        return requestList.stream()
                .collect(Collectors.groupingBy(Request::getStatuses, HashMap::new, Collectors.toList()));
    }

    @Override
    public Request getRequestById(String id) throws RequestNotFoundException {
        return requestRepository.findById(id).orElseThrow(() -> new RequestNotFoundException("Not Represent!"));
    }
}
