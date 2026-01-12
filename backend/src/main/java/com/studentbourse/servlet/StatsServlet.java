package com.studentbourse.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/api/stats")
public class StatsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest r, HttpServletResponse s)
            throws IOException {

        s.setContentType("application/json");
        s.getWriter().print(
                "{\"awarded\":[10,20,15,30]," +
                        "\"funds\":[1000,2000,1500,3000]," +
                        "\"reviews\":[5,8,12,20]}"
        );
    }
}
