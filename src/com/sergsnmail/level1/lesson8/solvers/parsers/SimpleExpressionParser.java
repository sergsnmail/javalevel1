package com.sergsnmail.level1.lesson8.solvers.parsers;

public class SimpleExpressionParser {

    /**
     * Строка выражения
     */
    private String expressionStr;

    /**
     * Индекас начала обработки
     */
    private int beginIdx = 0;

    /**
     * Итоговая структура выражений
     */
    private Expression expression;

    public SimpleExpressionParser(String expressionStr) {
        this.expressionStr = expressionStr;
        parse();
    }

    private void parse() {
        expression = getExpression(0);
    }

    public double calc() {
        return expression.calc();
    }

    /**
     * Метод разбора выражения
     *
     * @param prevPriority Предыдущий приоритет операции
     * @return Выражение
     */
    private Expression getExpression(int prevPriority) {
        int currPriority = 0;
        Expression expression = null;
        while (beginIdx < expressionStr.length()) {
            char currCh = expressionStr.charAt(beginIdx);
            if (currCh >= '0' && currCh <= '9') { // обработка цифр
                expression = returnDigit(createDigit());
            } else if (currCh >= 'a' && currCh <= 'z') { // обработка функций
                expression = returnFunction(createFunction());
            } else if (currCh == ',' || currCh == ')') {
                break;
            } else { // обработка операторов
                String operator = String.valueOf(currCh);
                currPriority = getPriority(operator);
                /**
                 * если у предыдущего оператора приоритет меньше создаем новую операци и передаем ей в качестве первого
                 * агрумента созданное выражение.
                 */
                if (currPriority > prevPriority) {
                    beginIdx++;
                    expression = returnOperation(createOperation(expression, operator));
                } else {
                    beginIdx--;
                    break;
                }
            }
            beginIdx++;
        }
        return expression;
    }

    /**
     * Метод создания числа
     *
     * @return Число
     */
    private Digit createDigit() {
        Digit digit;
        int endIdx = expressionStr.length() - 1;
        char currCh;
        for (int i = beginIdx; i < expressionStr.length(); i++) {
            currCh = expressionStr.charAt(i);
            if (!(currCh >= '0' && currCh <= '9') && currCh != '.') {
                endIdx = i - 1;
                break;
            }
        }
        digit = new Digit(Double.parseDouble(expressionStr.substring(beginIdx, endIdx + 1)));
        beginIdx = endIdx;
        return digit;
    }

    /**
     * Метод создания функции
     *
     * @return Функция
     */
    private Function createFunction() {
        Function function;
        int endIdx = expressionStr.length();
        char currCh;
        for (int i = beginIdx; i < expressionStr.length(); i++) {
            currCh = expressionStr.charAt(i);
            if (!(currCh >= 'a' && currCh <= 'z')) {
                endIdx = i;
                break;
            }
        }
        String funcName = expressionStr.substring(beginIdx, endIdx);
        function = new Function(funcName, null);
        beginIdx = endIdx + 1;
        getFunctionArgs(function);
        return function;
    }

    /**
     * Метод для добавления аргументов в функцию
     *
     * @param function Функция
     */
    private void getFunctionArgs(Function function) {
        do {
            function.appendArg(getExpression(0));
        } while (expressionStr.charAt(beginIdx) == ',');
    }

    /**
     * Создание операции
     *
     * @param leftExpr      Левое выражение
     * @param operationName Имя операции
     * @return Операция
     */
    private Operation createOperation(Expression leftExpr, String operationName) {
        Operation operation;
        int priority = getPriority(operationName);
        operation = new Operation(operationName, priority);
        Expression rightExpr = getExpression(priority);
        operation.setRight(rightExpr);
        operation.setLeft(leftExpr);
        changeOrderOperands(operation);
        return operation;
    }

    /**
     * Метод для изменения порядка операндов
     * Для реализации последовательного вычисления выражения
     *
     * @param operation Операция
     */
    public void changeOrderOperands(Operation operation) {
        Expression leftExpr = operation.getLeft();
        Expression rightExpr = operation.getRight();
        if (rightExpr instanceof Operation) {
            operation.setRight(leftExpr);
            operation.setLeft(rightExpr);
        }
    }

    public Expression returnDigit(Digit digit) {
        return digit;
    }

    public Expression returnFunction(Function function) {
        return function;
    }

    public Expression returnOperation(Operation operation) {
        return operation;
    }

    /**
     * Метод возвращающий одинаковый приоритет для всех операций
     *
     * @param operation Имя операция
     * @return Значение приоритета
     */
    public int getPriority(String operation) {
        return 1;
    }

    @Override
    public String toString() {
        return expression.toString();
    }

}
