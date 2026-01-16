package com.studentbourse.controller;

import com.studentbourse.MainApp;
import com.studentbourse.dao.UniversityDAO;
import com.studentbourse.dao.UserDAO;
import com.studentbourse.model.University;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

public class CreateAccountStudentController {

    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField emailField;
    @FXML private TextField phoneField;
    @FXML private PasswordField passwordField;
    @FXML private PasswordField confirmPasswordField;

    @FXML private ComboBox<University> universityComboBox;
    @FXML private HBox headerIcons;

    @FXML
    public void initialize() {
        universityComboBox.getItems().addAll(
                UniversityDAO.findAll()
        );
    }

    @FXML
    private void goBack() {
        MainApp.show("cover-page.fxml", "StudentBourse");
    }

    @FXML
    public void goToStudentLogin(ActionEvent event) {
        MainApp.show("student-login.fxml", "Student Login");
    }

    @FXML
    public void onRegisterClick(ActionEvent event) {

        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();
        University university = universityComboBox.getValue();

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

        if (password == null || password.length() < 8) {
            showError("Password must be at least 8 characters long");
            return;
        }

        if (!password.equals(confirmPassword)) {
            showError("Passwords do not match");
            return;
        }

        if (university == null) {
            showError("Please select a university");
            return;
        }

        if (phone == null || !phone.matches("[+0-9]+")) {
            showError("Phone number must contain only digits or +");
            return;
        }

        if (UserDAO.emailExists(email)) {
            showError("An account with this email already exists");
            return;
        }

        boolean created = UserDAO.createStudent(
                firstName,
                lastName,
                email,
                phone,
                password
        );

        if (!created) {
            showError("Failed to create account. Please try again.");
            return;
        }

        System.out.println("STUDENT INSERTED INTO DB: " + email);
        MainApp.show("student-dashboard.fxml", "Student Dashboard");
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Validation Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
