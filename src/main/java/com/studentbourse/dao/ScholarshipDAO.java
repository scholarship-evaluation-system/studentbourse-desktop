package com.studentbourse.dao;

import com.studentbourse.util.DB;
import com.studentbourse.model.Scholarship;

import java.sql.*;
import java.util.*;

public class ScholarshipDAO {

    public static List<Scholarship> findAll() {
        List<Scholarship> list = new ArrayList<>();
        try (Connection c = DB.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery("select * from scholarship")) {

            while (rs.next()) {
                Scholarship s = new Scholarship();
                s.id = rs.getInt("id");
                s.title = rs.getString("title");
                s.amount = rs.getInt("amount");
                s.deadline = rs.getDate("deadline").toLocalDate();
                s.maxApplicants = rs.getInt("max_applicants");
                s.level = rs.getString("level");
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
