package com.studentbourse.dao;

import com.studentbourse.model.University;
import com.studentbourse.util.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UniversityDAO {

    public static List<University> findAll() {
        List<University> list = new ArrayList<>();

        String sql = "select id, name, rank from university order by rank asc";

        try (Connection conn = DB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(
                        new University(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getInt("rank")
                        )
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
