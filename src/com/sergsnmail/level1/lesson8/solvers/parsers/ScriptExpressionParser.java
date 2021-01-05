package com.sergsnmail.level1.lesson8.solvers.parsers;

public class ScriptExpressionParser extends CustomExpressionParser {
    public ScriptExpressionParser(String expressionStr) {
        super(expressionStr);
    }

    /**
     * Перепопределяем метод для замены имени функции
     *
     * @param function
     * @return
     */
    @Override
    public Expression returnFunction(Function function) {
        if (function.getName().equals("sqr")) {
            renameFunc(function);
        }
        return function;
    }

    /**
     * Переопределяем метод для конвертации операции в функцию с аргументами
     *
     * @param operation
     * @return
     */
    @Override
    public Expression returnOperation(Operation operation) {
        if (operation.getOperation().equals("^")) {
            return convertToFunction(operation);
        }
        return super.returnOperation(operation);
    }

    /**
     * Метод преобразования операции в функцию
     *
     * @param operation Операция
     * @return Функция
     */
    private Function convertToFunction(Operation operation) {
        String name = operation.getOperation();
        Expression[] args = new Expression[]{operation.getLeft(), operation.getRight()};
        switch (name) {
            case "^":
                return new Function("Math.pow", args);
            default:
                return new Function(name, args);
        }
    }

    /**
     * Метод переименования функции
     *
     * @param function Функция
     */
    private void renameFunc(Function function) {
        String funcName = function.getName();
        switch (funcName) {
            case "sqr":
                function.setName("Math.sqrt");
        }
    }

}
