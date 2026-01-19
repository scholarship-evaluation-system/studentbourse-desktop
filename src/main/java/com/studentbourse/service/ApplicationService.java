package com.studentbourse.service;

import com.studentbourse.dao.ApplicationDAO;
import com.studentbourse.model.Application;

import java.util.List;

public class ApplicationService {

    public void apply(int userId, int scholarshipId) {
        ApplicationDAO.apply(userId, scholarshipId);
    }

    public List<Application> getApplicationsForStudent(int userId) {
        return ApplicationDAO.findByUser(userId);
    }

    public long countByStatus(int userId, String status) {
        return getApplicationsForStudent(userId)
                .stream()
                .filter(a -> status.equals(a.status))
                .count();
    }
}
