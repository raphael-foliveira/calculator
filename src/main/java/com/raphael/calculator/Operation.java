
package com.raphael.calculator;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operation {

    static String[] operators = { "*", "/", "+", "-" };

    public static String getResult(String expression) {
        ArrayList<String> currentCalc;
        ArrayList<Double> currentNumbers;
        Matcher matcherCalc;
        Matcher matcherNums;
        Double result;

        expression = expression.replace(",", ".");

        while (expression.contains("*") || expression.contains("+") || expression.contains("/")
                || expression.contains("-")) {
            for (String oper : operators) {
                currentCalc = new ArrayList<>();
                matcherCalc = Pattern.compile(String.format("[\\d.,]+\\%s[\\d.,]+", oper))
                        .matcher(expression);
                while (matcherCalc.find()) {
                    currentCalc.add(matcherCalc.group());
                }
                for (String calc : currentCalc) {
                    currentNumbers = new ArrayList<>();
                    matcherNums = Pattern.compile("[0-9.,]+")
                            .matcher(calc);
                    while (matcherNums.find()) {
                        currentNumbers.add(Double.parseDouble(matcherNums.group()));
                    }
                    if (oper.equals("*")) {
                        result = currentNumbers.get(0) * currentNumbers.get(1);
                    } else if (oper.equals("/")) {
                        result = currentNumbers.get(0) / currentNumbers.get(1);
                    } else if (oper.equals("+")) {
                        result = currentNumbers.get(0) + currentNumbers.get(1);
                    } else {
                        result = currentNumbers.get(0) - currentNumbers.get(1);
                    }

                    expression = expression.replace(calc, String.format("%.2f", result));
                    expression = expression.replace(",", ".");
                }

            }
        }
        return expression;
    }

}
