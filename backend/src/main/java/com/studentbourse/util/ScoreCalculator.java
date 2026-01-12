package com.studentbourse.util;

public class ScoreCalculator {
    public static float total(
            float academic,
            float financial,
            float exam,
            float extra,
            float university
    ) {
        return academic + financial + exam + extra + university;
    }
}
