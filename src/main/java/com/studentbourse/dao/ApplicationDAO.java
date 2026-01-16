package com.studentbourse.dao;

import com.studentbourse.util.DB;
import com.studentbourse.model.Application;

import java.sql.*;
import java.util.*;

public class ApplicationDAO {

    public static void apply(int userId, int scholarshipId) {
        try (Connection c = DB.getConnection()) {

            PreparedStatement ps = c.prepareStatement(
                    "insert into application(user_id, scholarship_id, status, total_score) " +
                            "values (?,?,?,0)");

            ps.setInt(1, userId);
            ps.setInt(2, scholarshipId);
            ps.setString(3, "submitted");
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Application> findByUser(int userId) {
        List<Application> list = new ArrayList<>();

        try (Connection c = DB.getConnection()) {

            PreparedStatement ps = c.prepareStatement(
                    "select * from application where user_id=?");

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Application a = new Application();
                a.id = rs.getInt("id");
                a.userId = rs.getInt("user_id");
                a.scholarshipId = rs.getInt("scholarship_id");
                a.status = rs.getString("status");
                a.totalScore = rs.getFloat("total_score");
                list.add(a);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
