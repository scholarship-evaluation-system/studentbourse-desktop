package com.studentbourse.servlet;

import com.studentbourse.db.DB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/api/student")
public class StudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest r, HttpServletResponse s)
            throws IOException {

        String userId = r.getParameter("id");
        s.setContentType("application/json");

        StringBuilder json = new StringBuilder("{");

        try (Connection c = DB.get()) {

            // student profile
            PreparedStatement ps = c.prepareStatement(
                    "select first_name,last_name,email,phone from users where id=?");

            ps.setInt(1, Integer.parseInt(userId));
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                json.append("\"firstName\":\"").append(rs.getString("first_name")).append("\",")
                        .append("\"lastName\":\"").append(rs.getString("last_name")).append("\",")
                        .append("\"email\":\"").append(rs.getString("email")).append("\",")
                        .append("\"phone\":\"").append(rs.getString("phone")).append("\",");
            }

            // student applications
            PreparedStatement aps = c.prepareStatement(
                    "select a.id,s.title,a.status,a.total_score " +
                            "from application a join scholarship s on a.scholarship_id=s.id " +
                            "where a.user_id=?");

            aps.setInt(1, Integer.parseInt(userId));
            ResultSet ars = aps.executeQuery();

            json.append("\"applications\":[");

            while (ars.next()) {
                json.append("{")
                        .append("\"id\":").append(ars.getInt("id")).append(",")
                        .append("\"title\":\"").append(ars.getString("title")).append("\",")
                        .append("\"status\":\"").append(ars.getString("status")).append("\",")
                        .append("\"score\":").append(ars.getFloat("total_score"))
                        .append("},");
            }

            if (json.charAt(json.length() - 1) == ',')
                json.deleteCharAt(json.length() - 1);

            json.append("]");

        } catch (Exception e) {
            s.sendError(500);
            return;
        }

        json.append("}");
        s.getWriter().print(json.toString());
    }
}
