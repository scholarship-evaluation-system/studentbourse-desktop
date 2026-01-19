package com.studentbourse.service;

public class ManualEvaluationService {

    public float manualEvaluate(
            float academic,
            float financial,
            float exam,
            float extracurricular,
            float universityBonus,
            float academicWeight,
            float financialWeight,
            float examWeight,
            float extracurricularWeight,
            float universityWeight
    ) {
        return ScoreCalculator.calculateWeightedScore(
                academic,
                financial,
                exam,
                extracurricular,
                universityBonus,
                academicWeight,
                financialWeight,
                examWeight,
                extracurricularWeight,
                universityWeight
        );
    }
}
