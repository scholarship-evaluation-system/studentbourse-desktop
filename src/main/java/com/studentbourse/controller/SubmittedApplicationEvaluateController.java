package com.studentbourse.controller;

import com.studentbourse.service.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SubmittedApplicationEvaluateController {

    @FXML private TextField academicField;
    @FXML private TextField financialField;
    @FXML private TextField examField;
    @FXML private TextField extracurricularField;
    @FXML private TextArea commentsField;

    private final AutoEvaluationService autoService = new AutoEvaluationService();
    private final ManualEvaluationService manualService = new ManualEvaluationService();
    private final EvaluationService evaluationService = new EvaluationService();

    private static int APPLICATION_ID = 1;
    private static final int EVALUATOR_ID = 6;

    public static void setApplicationId(int id) {
        APPLICATION_ID = id;
    }

    @FXML
    public void onAutoEvaluate() {
        float score = autoService.autoEvaluate(
                4.5f,   // GPA
                800,    // income
                85,
                70,
                2,      // university rank
                30, 30, 20, 10, 10
        );

        evaluationService.saveEvaluation(
                APPLICATION_ID,
                EVALUATOR_ID,
                score,
                "Auto evaluated"
        );
    }

    @FXML
    public void onManualEvaluate() {
        float score = manualService.manualEvaluate(
                Float.parseFloat(academicField.getText()),
                Float.parseFloat(financialField.getText()),
                Float.parseFloat(examField.getText()),
                Float.parseFloat(extracurricularField.getText()),
                5,
                30, 30, 20, 10, 10
        );

        evaluationService.saveEvaluation(
                APPLICATION_ID,
                EVALUATOR_ID,
                score,
                commentsField.getText()
        );
    }
}
