package com.sergsnmail.level1.lesson8.solvers;

import com.sergsnmail.level1.lesson8.solvers.parsers.ScriptExpressionParser;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Данный класс реализует вычисление выражения на основе ScriptEngine
 */
public class Script implements Solver {

    @Override
    public String solve(String expression) {

        ScriptExpressionParser parser = new ScriptExpressionParser(expression);
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("Nashorn");
        Object expResult1 = null;
        try {
            expResult1 = scriptEngine.eval(parser.toString());
        } catch (ScriptException e) {
            e.printStackTrace();
        }

        return expResult1.toString();
    }

    @Override
    public String toString() {
        return "Script";
    }
}
