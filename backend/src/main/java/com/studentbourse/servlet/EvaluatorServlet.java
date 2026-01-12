package com.studentbourse.servlet;

import com.studentbourse.db.DB;
import com.studentbourse.util.ScoreCalculator;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/api/evaluator")
public class EvaluatorServlet extends HttpServlet {

    // fetch applications to review
    protected void doGet(HttpServletRequest r, HttpServletResponse s)
            throws IOException {

        s.setContentType("application/json");
        StringBuilder json = new StringBuilder("[");

        try (Connection c = DB.get()) {

            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(
                    "select a.id,u.first_name,u.last_name,s.title,a.status " +
                            "from application a " +
                            "join users u on a.user_id=u.id " +
                            "join scholarship s on a.scholarship_id=s.id");

            while (rs.next()) {
                json.append("{")
                        .append("\"applicationId\":").append(rs.getInt("id")).append(",")
                        .append("\"student\":\"")
                        .append(rs.getString("first_name")).append(" ")
                        .append(rs.getString("last_name")).append("\",")
                        .append("\"scholarship\":\"").append(rs.getString("title")).append("\",")
                        .append("\"status\":\"").append(rs.getString("status")).append("\"")
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

    // submit evaluation
    protected void doPost(HttpServletRequest r, HttpServletResponse s)
            throws IOException {

        try (Connection c = DB.get()) {

            int applicationId = Integer.parseInt(r.getParameter("application"));
            int evaluatorId = Integer.parseInt(r.getParameter("evaluator"));

            float academic = Float.parseFloat(r.getParameter("academic"));
            float financial = Float.parseFloat(r.getParameter("financial"));
            float exam = Float.parseFloat(r.getParameter("exam"));
            float extra = Float.parseFloat(r.getParameter("extra"));
            float university = Float.parseFloat(r.getParameter("university"));

            float total = ScoreCalculator.total(
                    academic, financial, exam, extra, university);

            PreparedStatement ps = c.prepareStatement(
                    "insert into evaluation " +
                            "(application_id,evaluator_id,academic_score,financial_score," +
                            "exam_score,extracurricular_score,university_score,total_score) " +
                            "values (?,?,?,?,?,?,?,?)");

            ps.setInt(1, applicationId);
            ps.setInt(2, evaluatorId);
            ps.setFloat(3, academic);
            ps.setFloat(4, financial);
            ps.setFloat(5, exam);
            ps.setFloat(6, extra);
            ps.setFloat(7, university);
            ps.setFloat(8, total);

            ps.executeUpdate();

            PreparedStatement ups = c.prepareStatement(
                    "update application set total_score=?, status='in_process' where id=?");

            ups.setFloat(1, total);
            ups.setInt(2, applicationId);
            ups.executeUpdate();

            s.setStatus(200);

        } catch (Exception e) {
            s.sendError(500);
        }
    }
}
