package com.studentbourse.service;

import com.studentbourse.util.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class EvaluationService {

    public void saveEvaluation(
            int applicationId,
            int evaluatorId,
            float totalScore,
            String comments
    ) {
        try (Connection c = DB.getConnection()) {

            PreparedStatement ps = c.prepareStatement(
                    """
                    insert into evaluation
                    (application_id, evaluator_id, total_score, comments)
                    values (?,?,?,?)
                    """
            );

            ps.setInt(1, applicationId);
            ps.setInt(2, evaluatorId);
            ps.setFloat(3, totalScore);
            ps.setString(4, comments);
            ps.executeUpdate();

            PreparedStatement updateApp = c.prepareStatement(
                    "update application set total_score=?, status='in_process' where id=?"
            );

            updateApp.setFloat(1, totalScore);
            updateApp.setInt(2, applicationId);
            updateApp.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
