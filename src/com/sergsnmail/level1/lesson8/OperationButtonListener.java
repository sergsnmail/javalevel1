package com.sergsnmail.level1.lesson8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperationButtonListener implements ActionListener {

    SupportOperation supportOperation;

    public OperationButtonListener(SupportOperation supportOperation) {
        this.supportOperation = supportOperation;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        switch (button.getText()) {
            case "sqrt":
                supportOperation.updateExpressionFieldValue(ExpressionHelper.append(supportOperation.getExpressionFieldValue(), "sqr"));
                break;
            case "x^y":
                supportOperation.updateExpressionFieldValue(ExpressionHelper.append(supportOperation.getExpressionFieldValue(), "^"));
                break;
            case ",":
                supportOperation.updateExpressionFieldValue(ExpressionHelper.append(supportOperation.getExpressionFieldValue(), "."));
                break;
            default: // Other action (digits + - * /)
                supportOperation.updateExpressionFieldValue(ExpressionHelper.append(supportOperation.getExpressionFieldValue(), button.getText()));
        }
    }
}
