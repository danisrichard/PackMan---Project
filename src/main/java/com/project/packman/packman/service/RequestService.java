package com.project.packman.packman.service;

import com.project.packman.packman.error.RequestNotFoundException;
import com.project.packman.packman.model.Request;
import com.project.packman.packman.model.RolesType.Status;

import java.util.HashMap;
import java.util.List;

public interface RequestService {

    Request saveNewRequest(Request request);
    HashMap<Status, List<Request>> getAllRequest();
    Request getRequestById(String id) throws RequestNotFoundException;
}
