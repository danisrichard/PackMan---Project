package com.project.packman.packman.repository.OfficeMatters;

import com.project.packman.packman.model.OfficeMatters.Comments;
import com.project.packman.packman.model.OfficeMatters.RolesType.Status;

public interface CustomQueryRequestRepository {

    void updateRequestStatusById(String id, Status status);

    void addCommentToRequestById(String id, Comments comments);
}
