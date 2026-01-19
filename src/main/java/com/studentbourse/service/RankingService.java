package com.studentbourse.service;

import com.studentbourse.dao.ApplicationDAO;
import com.studentbourse.model.Application;

import java.util.List;

public class RankingService {

    public void rankScholarship(int scholarshipId, int maxWinners) {
        List<Application> apps =
                ApplicationDAO.findByScholarship(scholarshipId);

        for (int i = 0; i < apps.size(); i++) {
            Application a = apps.get(i);
            if (i < maxWinners) {
                ApplicationDAO.updateStatus(a.id, "picked");
            } else {
                ApplicationDAO.updateStatus(a.id, "rejected");
            }
        }
    }
}
