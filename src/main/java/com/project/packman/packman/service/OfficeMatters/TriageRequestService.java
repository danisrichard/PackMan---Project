package com.project.packman.packman.service.OfficeMatters;

import com.project.packman.packman.error.OfficeMatters.RequestNotFoundException;
import com.project.packman.packman.model.OfficeMatters.Request;
import com.project.packman.packman.model.OfficeMatters.RolesType.Priorities;

import java.util.List;

public interface TriageRequestService {

    List<Request> getAllRequest();

    Request validateRequest(String id, Priorities priority) throws RequestNotFoundException;
}
