package com.sergsnmail.level1.lesson8.solvers;

import com.sergsnmail.level1.lesson8.solvers.parsers.CustomExpressionParser;

public class Custom implements Solver{
    @Override
    public String solve(String expression) {
        CustomExpressionParser parser = new CustomExpressionParser(expression);
        return String.valueOf(parser.calc());
    }

    @Override
    public String toString() {
        return "Custom";
    }
}
