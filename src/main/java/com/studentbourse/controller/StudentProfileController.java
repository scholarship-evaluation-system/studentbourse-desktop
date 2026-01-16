package com.studentbourse.controller;

import com.studentbourse.dao.UserDAO;
import com.studentbourse.model.Student;
import com.studentbourse.util.Session;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class StudentProfileController {

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField universityField;

    @FXML
    private Label statusLabel;

    private Student student;

    @FXML
    public void initialize() {
        student = Session.getStudent();
        firstNameField.setText(student.firstName);
        lastNameField.setText(student.lastName);
        emailField.setText(student.email);
        phoneField.setText(student.phone);
        universityField.setText(student.university);
    }

    @FXML
    private void saveProfile() {
        boolean success = UserDAO.updateUser(
                student.id,
                firstNameField.getText(),
                lastNameField.getText(),
                emailField.getText(),
                phoneField.getText()
        );

        if (success) {
            student.firstName = firstNameField.getText();
            student.lastName = lastNameField.getText();
            student.email = emailField.getText();
            student.phone = phoneField.getText();
            student.university = universityField.getText();
            statusLabel.setText("Profile updated successfully.");
        } else {
            statusLabel.setText("Failed to update profile.");
        }
    }

    @FXML
    private void goBack() {
        firstNameField.getScene().getWindow().hide();
    }
}
