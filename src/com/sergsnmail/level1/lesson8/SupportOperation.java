package com.sergsnmail.level1.lesson8;

import com.sergsnmail.level1.lesson8.solvers.Solver;

/**
 * Интерфыйс для работы с диалогом калькулятора
 */
public interface SupportOperation {
    void updateExpressionFieldValue(String newValue);
    String getExpressionFieldValue();
    Solver getSolver();
    String switchSolver();
}
