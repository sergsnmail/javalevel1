package com.sergsnmail.level1.lesson8;

import com.sergsnmail.level1.lesson8.solvers.Custom;
import com.sergsnmail.level1.lesson8.solvers.Script;
import com.sergsnmail.level1.lesson8.solvers.Simple;
import com.sergsnmail.level1.lesson8.solvers.Solver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements SupportOperation {

    private JTextField textField;
    private Solver[] solvers;
    private int solverIdx;
    private ActionListener concatenationButtonListener;
    private CalculationListener calculationListener;

    public Calculator() {
        setTitle("Calculator");
        setBounds(0, 0, 500, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());

        concatenationButtonListener = new OperationButtonListener((SupportOperation) this);
        calculationListener = new CalculationListener((SupportOperation) this);

        /**
         * Решатели используемые в калькуляторе
         */
        solvers = new Solver[]{
                new Script(),
                new Simple(),
                new Custom()
        };

        add(initTopContent(), BorderLayout.NORTH);
        add(initCenterContent(), BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel initTopContent() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        textField = new JTextField();
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        panel.add(textField, BorderLayout.CENTER);
        return panel;
    }

    /**
     * Цифровой блок кнопока
     *
     * @return Панель цифрового блока
     */
    private JPanel initDigits() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 3));

        for (int i = 1; i <= 9; i++) {
            JButton btn = new JButton(String.valueOf(i));
            btn.addActionListener(concatenationButtonListener);
            panel.add(btn);
        }

        JButton comma = new JButton(",");
        comma.addActionListener(concatenationButtonListener);
        panel.add(comma);

        JButton zero = new JButton("0");
        zero.addActionListener(concatenationButtonListener);
        panel.add(zero);

        return panel;
    }

    /**
     * Блок операций
     *
     * @return Панель блока операций
     */
    private JPanel initOperations() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 3));

        /**
         * Сервисные кнопки
         */
        JButton switchSolver = new JButton(getSolver().toString());
        switchSolver.addActionListener(calculationListener);
        JButton clear = new JButton("C");
        clear.addActionListener(calculationListener);
        JButton backSpace = new JButton("<<");
        backSpace.addActionListener(calculationListener);
        JButton submit = new JButton("=");
        submit.addActionListener(calculationListener);

        /**
         * Кнопки операций
         */
        JButton plus = new JButton("+");
        plus.addActionListener(concatenationButtonListener);
        JButton minus = new JButton("-");
        minus.addActionListener(concatenationButtonListener);
        JButton multiple = new JButton("*");
        multiple.addActionListener(concatenationButtonListener);
        JButton div = new JButton("/");
        div.addActionListener(concatenationButtonListener);
        JButton sqrt = new JButton("sqrt");
        sqrt.addActionListener(concatenationButtonListener);
        JButton pow = new JButton("x^y");
        pow.addActionListener(concatenationButtonListener);

        panel.add(switchSolver);
        panel.add(clear);
        panel.add(backSpace);
        panel.add(plus);
        panel.add(minus);
        panel.add(multiple);
        panel.add(div);
        panel.add(sqrt);
        panel.add(pow);
        panel.add(submit);

        return panel;
    }

    private JPanel initCenterContent() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(initOperations(), BorderLayout.WEST);
        panel.add(initDigits(), BorderLayout.CENTER);

        return panel;
    }

    /**
     * Задать значение поля выражения
     *
     * @param newValue Новое значение поля выражения
     */
    @Override
    public void updateExpressionFieldValue(String newValue) {
        textField.setText(newValue);
    }

    /**
     * Получить значение поля выражения
     *
     * @return Строка выражения
     */
    @Override
    public String getExpressionFieldValue() {
        return textField.getText();
    }

    /**
     * Получить текщий решатель
     *
     * @return Решатель
     */
    @Override
    public Solver getSolver() {
        return solvers[solverIdx];
    }

    /**
     * Перекллючить решатель на следующий по порядку и получить его имя
     *
     * @return Имя решатель
     */
    @Override
    public String switchSolver() {
        if (solverIdx + 1 > solvers.length - 1) {
            solverIdx = 0;
        } else {
            solverIdx++;
        }
        return solvers[solverIdx].toString();
    }

}
