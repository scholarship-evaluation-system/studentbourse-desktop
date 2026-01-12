package com.studentbourse.db;

import java.sql.*;

public class DB {
    private static final String URL =
            "jdbc:postgresql://localhost:5432/studentbourse";
    private static final String USER = "postgres";
    private static final String PASS = "Ak41629#";

    public static Connection get() throws Exception {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
