package com.studentbourse.servlet;

import com.studentbourse.db.DB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/api/login")
public class AuthServlet extends HttpServlet {

    protected void doPost(HttpServletRequest r, HttpServletResponse s)
            throws IOException {

        String email = r.getParameter("email");
        String pass = r.getParameter("password");

        try (Connection c = DB.get()) {

            PreparedStatement ps = c.prepareStatement(
                    "select id, role from users where email=? and password=?");

            ps.setString(1, email);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                s.setContentType("application/json");
                s.getWriter().print(
                        "{\"id\":" + rs.getInt("id") +
                                ",\"role\":\"" + rs.getString("role") + "\"}"
                );
            } else {
                s.sendError(401);
            }

        } catch (Exception e) {
            s.sendError(500);
        }
    }
}