package com.studentbourse.service;

public class AutoEvaluationService {

    public float autoEvaluate(
            float gpa,
            float income,
            float exam,
            float extracurricular,
            int universityRank,
            float academicWeight,
            float financialWeight,
            float examWeight,
            float extracurricularWeight,
            float universityWeight
    ) {
        float academicScore = gpa * 20;           // scale 0–5 → 0–100
        float financialScore = income < 1000 ? 100 : 50;
        float universityBonus =
                universityRank <= 3 ? 5 :
                        universityRank <= 5 ? 3 : 1;

        return ScoreCalculator.calculateWeightedScore(
                academicScore,
                financialScore,
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
