package com.studentbourse.service;

public class ScoreCalculator {

    public static float calculateWeightedScore(
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
        return
                academic * academicWeight / 100f +
                        financial * financialWeight / 100f +
                        exam * examWeight / 100f +
                        extracurricular * extracurricularWeight / 100f +
                        universityBonus * universityWeight / 100f;
    }
}
