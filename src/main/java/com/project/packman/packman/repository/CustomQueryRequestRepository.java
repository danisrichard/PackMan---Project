package com.project.packman.packman.repository;

import com.project.packman.packman.model.Comments;
import com.project.packman.packman.model.RolesType.Status;

public interface CustomQueryRequestRepository {

    void updateRequestStatusById(String id, Status status);

    void addCommentToRequestById(String id, Comments comments);
}
