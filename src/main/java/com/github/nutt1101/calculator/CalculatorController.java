package com.github.nutt1101.calculator;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class CalculatorController {
    String d1, d2;
    /**
     * 0 +
     * 1 -
     * 2 *
     * 3 /
     */
    Integer operation;

    @FXML TextArea displayArea;

    void clear() {
        d1 = d2 = null;
        operation = null;
        displayArea.setText("");
        saved = false;
    }

    static boolean saved;
    void update(String value) {
        String current = displayArea.getText();

        if (d1 != null && !saved) {
            saved = true;
            current = "";
            displayArea.setText(current);
        }

        if (value.equals(".") && (current.isEmpty() || current.contains("."))) return;
        if (value.equals("0") && current.equals("0")) return;

        current += value;

        displayArea.setText(current);
    }

    void save(String value) {
        if (d1 == null) {
            d1 = value;
        } else {
            d2 = value;
        }
    }

    Double calculate(Double first, Double second) {
        return switch (operation) {
            case 0 -> first + second;
            case 1 -> first - second;
            case 2 -> first * second;
            case 3 -> first / second;
            default -> null;
        };
    }

    public void button1() {
        update("1");
    }
    public void button2() {
        update("2");
    }
    public void button3() {
        update("3");
    }
    public void button4() {
        update("4");
    }
    public void button5() {
        update("5");
    }
    public void button6() {
        update("6");
    }
    public void button7() {
        update("7");
    }
    public void button8() {
        update("8");
    }
    public void button9() {
        update("9");
    }
    public void button0() {
        update("0");
    }
    public void buttonPlus() {
        operation = 0;
        save(displayArea.getText());
    }
    public void buttonMin() {
        operation = 1;
        save(displayArea.getText());

    }
    public void buttonMult() {
        operation = 2;
        save(displayArea.getText());
    }
    public void buttonDiv() {
        operation = 3;
        save(displayArea.getText());
    }

    public void buttonCal() {
        save(displayArea.getText());

        if (d1 == null || d2 == null) return;

        Double first = Double.parseDouble(d1),
                second = Double.parseDouble(d2);

        Double r = calculate(first, second);

        if ((Math.abs(r) - Math.abs(r.intValue())) < 1e-6 ) {
            displayArea.setText(String.valueOf(r.intValue()));
            d1 = String.valueOf(r.intValue());
        } else {
            displayArea.setText(String.valueOf(r));
            d1 = String.valueOf(r);
        }

        saved = false;
        d2 = null;
    }
    public void buttonDot() {
        update(".");
    }
    public void buttonC() {
        clear();
    }
}
