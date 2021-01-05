package com.sergsnmail.level1.lesson8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculationListener implements ActionListener {

    private final SupportOperation supportOperation;

    public CalculationListener(SupportOperation supportOperation) {
        this.supportOperation = supportOperation;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        switch (button.getText()) {
            case "C": // Clear expression action
                supportOperation.updateExpressionFieldValue("");
                break;
            case "<<": // Backspace action
                supportOperation.updateExpressionFieldValue(ExpressionHelper.remove(supportOperation.getExpressionFieldValue(), 1));
                break;
            case "=": // Submit action
                String result = supportOperation.getSolver().solve(supportOperation.getExpressionFieldValue());
                supportOperation.updateExpressionFieldValue(result);
                break;
            default:
                String solverName = supportOperation.switchSolver();
                button.setText(solverName);
        }
    }
}
