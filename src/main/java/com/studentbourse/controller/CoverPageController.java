package com.studentbourse.controller;

import com.studentbourse.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class CoverPageController {

    @FXML
    private void handleNextButton(ActionEvent event) {
        MainApp.show("role-selection.fxml", "Role Selection");
    }
}
