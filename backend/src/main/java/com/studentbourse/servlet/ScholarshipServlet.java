package com.studentbourse.servlet;

import com.studentbourse.db.DB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/api/scholarships")
public class ScholarshipServlet extends HttpServlet {

    protected void doGet(HttpServletRequest r, HttpServletResponse s)
            throws IOException {

        s.setContentType("application/json");

        StringBuilder json = new StringBuilder("[");
        try (Connection c = DB.get()) {

            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(
                    "select id,title,amount,deadline,max_applicants,level from scholarship");

            while (rs.next()) {
                json.append("{")
                        .append("\"id\":").append(rs.getInt("id")).append(",")
                        .append("\"title\":\"").append(rs.getString("title")).append("\",")
                        .append("\"amount\":").append(rs.getInt("amount")).append(",")
                        .append("\"deadline\":\"").append(rs.getDate("deadline")).append("\",")
                        .append("\"slots\":").append(rs.getInt("max_applicants")).append(",")
                        .append("\"level\":\"").append(rs.getString("level")).append("\"")
                        .append("},");
            }

        } catch (Exception e) {
            s.sendError(500);
            return;
        }

        if (json.charAt(json.length() - 1) == ',')
            json.deleteCharAt(json.length() - 1);

        json.append("]");
        s.getWriter().print(json.toString());
    }
}
