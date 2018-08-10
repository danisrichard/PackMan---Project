package com.project.packman.packman.service.OfficeMatters;

import com.project.packman.packman.error.OfficeMatters.RequestNotFoundException;
import com.project.packman.packman.model.OfficeMatters.Request;
import com.project.packman.packman.model.OfficeMatters.RolesType.Status;

import java.util.HashMap;
import java.util.List;

public interface RequestService {

    Request saveNewRequest(Request request);
    HashMap<Status, List<Request>> getAllRequestGroupByStatus();
    Request getRequestById(String id) throws RequestNotFoundException;
}
