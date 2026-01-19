package com.studentbourse.controller;

import com.studentbourse.dao.ApplicationDAO;
import com.studentbourse.model.Application;
import com.studentbourse.service.RankingService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ScholarshipResultsController {

    @FXML private TableView<Application> resultsTable;
    @FXML private TableColumn<Application, Integer> applicationCol;
    @FXML private TableColumn<Application, Float> scoreCol;
    @FXML private TableColumn<Application, String> statusCol;

    private static int SCHOLARSHIP_ID = 1;

    private final RankingService rankingService = new RankingService();

    public static void setScholarshipId(int id) {
        SCHOLARSHIP_ID = id;
    }

    @FXML
    public void initialize() {
        applicationCol.setCellValueFactory(
                new PropertyValueFactory<>("id"));
        scoreCol.setCellValueFactory(
                new PropertyValueFactory<>("totalScore"));
        statusCol.setCellValueFactory(
                new PropertyValueFactory<>("status"));

        resultsTable.setItems(
                FXCollections.observableArrayList(
                        ApplicationDAO.findByScholarship(SCHOLARSHIP_ID)
                )
        );
    }

    @FXML
    private void onFinalize() {
        rankingService.rankScholarship(SCHOLARSHIP_ID, 3);
        resultsTable.setItems(
                FXCollections.observableArrayList(
                        ApplicationDAO.findByScholarship(SCHOLARSHIP_ID)
                )
        );
    }
}
