package com.sergsnmail.level1.lesson8.solvers.parsers;

/**
 * Класс предстваляющий выражение вида: [правое выражение][оператор][левое выражение]
 * Где:
 *      [правое выражение] и [левое выражение] любое выражение типа Expression
 *      [оператор] лбюой оператор из множества (+,-,*,/,^)
 */
class Operation implements Expression {
    private Expression left, right;
    private String operation;
    private int priority;

    public Operation(String operation, int priority) {
        this.operation = operation;
        this.priority = priority;
    }

    /**
     * Метод вычисления выражения
     * @return Результат типа double
     */
    @Override
    public double calc() {
        switch (operation) {
            case "+":
                return left.calc() + right.calc();
            case "-":
                return left.calc() - right.calc();
            case "*":
                return left.calc() * right.calc();
            case "/":
                return left.calc() / right.calc();
            case "^":
                return Math.pow(left.calc(), right.calc());
            default:
                return 0;
        }
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    public void setLeft(Expression left) {
        this.left = left;
    }

    public void setRight(Expression right) {
        this.right = right;
    }

    public int getPriority() {
        return priority;
    }

    public String getOperation() {
        return operation;
    }

    @Override
    public String toString() {
        return left.toString() + operation + right.toString();
    }
}
