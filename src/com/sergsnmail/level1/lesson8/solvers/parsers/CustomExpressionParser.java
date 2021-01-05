package com.sergsnmail.level1.lesson8.solvers.parsers;

/**
 * Класс разбора выражения с учетом приоритета операций
 */
public class CustomExpressionParser extends SimpleExpressionParser {

    public CustomExpressionParser(String expressionStr) {
        super(expressionStr);
    }

    /**
     * Метод для изменения операндов местами в выражении
     * @param operation Операция
     */
    @Override
    public void changeOrderOperands(Operation operation) {
        Expression leftExpr = operation.getLeft();
        Expression rightExpr = operation.getRight();
        if (rightExpr instanceof Operation) {
            int priority = operation.getPriority();
            int rightOperationPriority = ((Operation) rightExpr).getPriority();
            /**
             * обработка выражения вида 5/5/5 -> (5/5)/5 или 5*5/5 -> (5*5)/5
             */
            if (rightOperationPriority == priority) {
                operation.setRight(leftExpr);
                operation.setLeft(rightExpr);
            }
        }
    }

    /**
     * Метод определения приоритета операции
     * @param operation Операция
     * @return Приоритет
     */
    @Override
    public int getPriority(String operation) {
        switch (operation) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            case "^":
            case "sqr":
                return 3;
            default:
                return 0;
        }
    }
}
