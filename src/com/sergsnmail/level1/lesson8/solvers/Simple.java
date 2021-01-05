package com.sergsnmail.level1.lesson8.solvers;

import com.sergsnmail.level1.lesson8.solvers.parsers.SimpleExpressionParser;

/**
 * Данный класс реализует простое последовательное вычисление выражения, без учета приоритета операций
 */
public class Simple implements Solver {

    @Override
    public String solve(String expression) {
        SimpleExpressionParser parser = new SimpleExpressionParser(expression);
        return String.valueOf(parser.calc());
    }

    @Override
    public String toString() {
        return "Simple";
    }
}
