package com.sergsnmail.level1.lesson8.solvers.parsers;

/**
 * Класс представляющий число
 */
class Digit implements Expression {
    double value;

    public Digit(double value) {
        this.value = value;
    }

    @Override
    public double calc() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
