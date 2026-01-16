package com.studentbourse.controller;

import com.studentbourse.MainApp;
import com.studentbourse.dao.UserDAO;
import com.studentbourse.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import com.studentbourse.model.Student;
import com.studentbourse.util.Session;

public class StudentLoginController {

    @FXML private TextField emailField;
    @FXML private PasswordField passwordField;
    @FXML private HBox headerIcons;

    @FXML
    public void onCreateAccountClick(ActionEvent event) {
        MainApp.show("createaccount-student.fxml", "Create Account");
    }

    @FXML
    private void goBack() {
        MainApp.show("cover-page.fxml", "StudentBourse");
    }

    @FXML
    public void onLoginClick(ActionEvent event) {

        String email = emailField.getText();
        String password = passwordField.getText();

        if (email == null || email.isBlank()) {
            showError("Email is required");
            return;
        }

        if (password == null || password.isBlank()) {
            showError("Password is required");
            return;
        }

        User user = UserDAO.login(email, password);

        if (user == null) {
            showError("Invalid email or password");
            return;
        }

        System.out.println("LOGIN SUCCESS: " + user.email + " (" + user.role + ")");

        if ("student".equals(user.role)) {

            Session.setUser(user);

            Student s = new Student();
            s.id = user.id;
            s.firstName = user.firstName;
            s.lastName = user.lastName;
            s.email = user.email;
            s.phone = user.phone;

            Session.setStudent(s);

            MainApp.show("student-dashboard.fxml", "Student Dashboard");

        } else {
            showError("Unsupported role: " + user.role);
        }
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Login Failed");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
