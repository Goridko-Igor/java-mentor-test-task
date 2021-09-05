package ru.goridko_igor;

import ru.goridko_igor.calculator.Calculator;
import ru.goridko_igor.calculator.impl.ArabicAndRomanIntegerNumberCalculator;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new ArabicAndRomanIntegerNumberCalculator();
        System.out.println(calculator.calculateExpression("1 + 2"));
    }
}
