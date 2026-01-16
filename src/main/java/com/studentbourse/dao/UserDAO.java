package com.studentbourse.dao;

import com.studentbourse.model.User;
import com.studentbourse.util.DB;
import com.studentbourse.util.PasswordUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    public static boolean emailExists(String email) {
        String sql = "select 1 from users where email = ?";

        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static boolean createStudent(
            String firstName,
            String lastName,
            String email,
            String phone,
            String password
    ) {
        String sql = """
            insert into users (role, first_name, last_name, email, phone, password)
            values ('student', ?, ?, ?, ?, ?)
        """;

        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, email);
            ps.setString(4, phone);
            ps.setString(5, PasswordUtil.hashPassword(password));

            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean createEvaluator(
            String firstName,
            String lastName,
            String email,
            String phone,
            String password
    ) {
        String sql = """
            insert into users (role, first_name, last_name, email, phone, password)
            values ('evaluator', ?, ?, ?, ?, ?)
        """;

        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, email);
            ps.setString(4, phone);
            ps.setString(5, PasswordUtil.hashPassword(password));

            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static User login(String email, String password) {
        String sql = "select * from users where email = ? and password = ?";

        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setString(2, PasswordUtil.hashPassword(password));

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User u = new User();
                u.id = rs.getInt("id");
                u.role = rs.getString("role");
                u.firstName = rs.getString("first_name");
                u.lastName = rs.getString("last_name");
                u.email = rs.getString("email");
                u.phone = rs.getString("phone");
                return u;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static boolean updateUser(
            int id,
            String firstName,
            String lastName,
            String email,
            String phone
    ) {
        String sql = """
            update users
            set first_name = ?, last_name = ?, email = ?, phone = ?
            where id = ?
        """;

        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, email);
            ps.setString(4, phone);
            ps.setInt(5, id);

            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
