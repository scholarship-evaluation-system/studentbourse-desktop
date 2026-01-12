package com.studentbourse.servlet;

import com.studentbourse.db.DB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/api/apply")
public class ApplicationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest r, HttpServletResponse s)
            throws IOException {

        try (Connection c = DB.get()) {

            PreparedStatement ps = c.prepareStatement(
                    "insert into application(user_id, scholarship_id, status) values (?, ?, ?)");

            ps.setInt(1, Integer.parseInt(r.getParameter("user")));
            ps.setInt(2, Integer.parseInt(r.getParameter("scholarship")));
            ps.setString(3, "submitted");

            ps.executeUpdate();
            s.setStatus(200);

        } catch (Exception e) {
            s.sendError(500);
        }
    }
}
