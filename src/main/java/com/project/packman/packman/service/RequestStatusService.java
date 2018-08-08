package com.project.packman.packman.service;

import com.project.packman.packman.error.RequestNotFoundException;
import com.project.packman.packman.error.StatusNotFoundException;
import com.project.packman.packman.model.Request;

public interface RequestStatusService {

    void addNewStatus(String id, String status) throws RequestNotFoundException, StatusNotFoundException;

    Request findById(String id) throws RequestNotFoundException;

}
