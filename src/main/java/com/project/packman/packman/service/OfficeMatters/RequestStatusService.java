package com.project.packman.packman.service.OfficeMatters;

import com.project.packman.packman.error.OfficeMatters.RequestNotFoundException;
import com.project.packman.packman.error.OfficeMatters.StatusNotFoundException;
import com.project.packman.packman.model.OfficeMatters.Request;

public interface RequestStatusService {

    void addNewStatus(String id, String status) throws RequestNotFoundException, StatusNotFoundException;

    Request findById(String id) throws RequestNotFoundException;

}
