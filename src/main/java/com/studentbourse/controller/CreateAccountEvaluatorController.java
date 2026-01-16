package com.studentbourse.controller;

import com.studentbourse.MainApp;
import com.studentbourse.dao.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

public class CreateAccountEvaluatorController {

    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField emailField;
    @FXML private TextField phoneField;
    @FXML private PasswordField passwordField;
    @FXML private PasswordField confirmPasswordField;

    @FXML private HBox headerIcons;

    @FXML
    public void goToEvaluatorLogin(ActionEvent event) {
        MainApp.show("evaluator-login.fxml", "Evaluator Login");
    }

    @FXML
    private void goBack() {
        MainApp.show("cover-page.fxml", "StudentBourse");
    }

    @FXML
    public void onRegisterClick(ActionEvent event) {

        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        if (firstName == null || firstName.isBlank()) {
            showError("First name is required");
            return;
        }

        if (lastName == null || lastName.isBlank()) {
            showError("Last name is required");
            return;
        }

        if (email == null || !email.contains("@")) {
            showError("Please enter a valid email address");
            return;
        }

        if (phone == null || !phone.matches("[+0-9]+")) {
            showError("Phone number must contain only digits or +");
            return;
        }

        if (password == null || password.length() < 8) {
            showError("Password must be at least 8 characters long");
            return;
        }

        if (!password.equals(confirmPassword)) {
            showError("Passwords do not match");
            return;
        }

        if (UserDAO.emailExists(email)) {
            showError("An account with this email already exists");
            return;
        }

        boolean created = UserDAO.createEvaluator(
                firstName,
                lastName,
                email,
                phone,
                password
        );

        if (!created) {
            showError("Failed to create evaluator account. Please try again.");
            return;
        }

        System.out.println("EVALUATOR CREATED: " + email);
        MainApp.show("evaluator-dashboard.fxml", "Evaluator Dashboard");
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Validation Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
