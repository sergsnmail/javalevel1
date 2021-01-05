package com.sergsnmail.level1.lesson8.solvers.parsers;

import java.util.Arrays;

/**
 * Класс представляющий функцию вида: [имя функции]([выражение 1],[выражение 2]..[выражение n])
 */
class Function implements Expression {
    private String funcName;
    private Expression[] args;

    public Function(String funcName, Expression[] args) {
        this.funcName = funcName;
        this.args = args;
    }

    @Override
    public double calc() {
        switch (funcName) {
            case "sqr":
                return Math.sqrt(args[0].calc());
            default:
                return 0;
        }
    }

    public void appendArg(Expression arg) {
        if (args == null) {
            args = new Expression[1];
            args[0] = arg;
        } else {
            args = Arrays.copyOf(args, args.length + 1);
            args[args.length - 1] = arg;
        }
    }

    public String getName() {
        return funcName;
    }

    public void setName(String funcName) {
        this.funcName = funcName;
    }

    @Override
    public String toString() {
        StringBuilder argsStr = new StringBuilder();
        for (Expression arg: args) {
            if (argsStr.length() > 0) {
                argsStr.append(',');
            }
            argsStr.append(arg.toString());
        }
        return funcName + '(' + argsStr.toString() + ')';
    }
}
