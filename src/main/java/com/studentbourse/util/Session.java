package com.studentbourse.util;

import com.studentbourse.model.Evaluator;
import com.studentbourse.model.Student;
import com.studentbourse.model.User;

public class Session {

    private static User user;
    private static Student student;
    private static Evaluator evaluator;

    public static void setUser(User u) {
        user = u;
    }

    public static User getUser() {
        return user;
    }

    public static void setStudent(Student s) {
        student = s;
    }

    public static Student getStudent() {
        return student;
    }

    public static void setEvaluator(Evaluator e) {
        evaluator = e;
    }

    public static Evaluator getEvaluator() {
        return evaluator;
    }

    public static boolean isLoggedIn() {
        return user != null;
    }

    public static void clear() {
        user = null;
        student = null;
        evaluator = null;
    }
}
