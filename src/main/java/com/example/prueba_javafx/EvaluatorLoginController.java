package com.example.prueba_javafx;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

public class EvaluatorLoginController {

    @FXML
    private TextField emailField;
    
    @FXML
    private PasswordField passwordField;

    @FXML
    private void onLoginClick() {
        // Login logic here
        System.out.println("Evaluator login clicked");
    }

    @FXML
    private void onCreateAccountClick() {
        // Navigate to create account page
    }
}
