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
import com.studentbourse.model.Evaluator;
import com.studentbourse.util.Session;

public class EvaluatorLoginController {

    @FXML private TextField emailField;
    @FXML private PasswordField passwordField;
    @FXML private HBox headerIcons;

    @FXML
    private void goBack() {
        MainApp.show("cover-page.fxml", "StudentBourse");
    }

    @FXML
    public void onCreateAccountClick(ActionEvent event) {
        MainApp.show("createaccount-evaluator.fxml", "Create Evaluator Account");
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

        if (user == null || !"evaluator".equals(user.role)) {
            showError("Invalid evaluator credentials");
            return;
        }

        System.out.println("EVALUATOR LOGIN SUCCESS: " + user.email);

        Session.setUser(user);

        Evaluator e = new Evaluator();
        e.id = user.id;
        e.firstName = user.firstName;
        e.lastName = user.lastName;
        e.email = user.email;
        e.phone = user.phone;

        Session.setEvaluator(e);

        MainApp.show("evaluator-dashboard.fxml", "Evaluator Dashboard");
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Login Failed");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
