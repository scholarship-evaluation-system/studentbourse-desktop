package com.studentbourse.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/studentbourse";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Ak41629#";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

//    public static void main(String[] args) {
//        try {
//            Connection conn = getConnection();
//            System.out.println("CONNECTED: " + conn);
//            conn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}
