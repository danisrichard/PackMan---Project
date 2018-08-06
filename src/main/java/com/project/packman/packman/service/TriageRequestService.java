package com.project.packman.packman.service;

import com.project.packman.packman.error.RequestNotFoundException;
import com.project.packman.packman.model.Request;
import com.project.packman.packman.model.RolesType.Priorites;

import java.util.List;

public interface TriageRequestService {

    List<Request> getAllRequest();

    Request validateRequest(String id, Priorites priority) throws RequestNotFoundException;
}
