
package com.raphael.calculator;

public class Operation {
    static double num1;
    static double num2;
    static String operator;

    public static double getResult() {
        if (operator.equals("-")) {
            return num1 - num2;
        } else if (operator.equals("+")) {
            return num1 + num2;
        } else if (operator.equals("*")) {
            return num1 * num2;
        } else if (operator.equals("/")) {
            return num1 / num2;
        }
        return num1;
    }

    public static double parseOperation(String string) {
        String[] numbers = string.split("\\" + operator);
        num1 = Double.parseDouble(numbers[0]);
        num2 = Double.parseDouble(numbers[1]);
        return getResult();
    }

    public static double getNum1() {
        return num1;
    }

    public static void setNum1(double num1) {
        Operation.num1 = num1;
    }

    public static double getNum2() {
        return num2;
    }

    public static void setNum2(double num2) {
        Operation.num2 = num2;
    }

    public static String getOperator() {
        return operator;
    }

    public static void setOperator(String operator) {
        Operation.operator = operator;
    }

}
