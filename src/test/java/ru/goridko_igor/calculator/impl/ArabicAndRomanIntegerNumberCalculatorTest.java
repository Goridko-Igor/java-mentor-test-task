package ru.goridko_igor.calculator.impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ArabicAndRomanIntegerNumberCalculatorTest {
    private static ArabicAndRomanIntegerNumberCalculator calculator;

    @BeforeAll
    static void createCalculator() {
        calculator = new ArabicAndRomanIntegerNumberCalculator();
    }

    @Test
    void additionOfArabicIntegerNumbersFromOneToTenShouldBeSuccessful() {
        assertAll("",
                () -> assertEquals("3", calculator.calculateExpression("1 + 2")),
                () -> assertEquals("11", calculator.calculateExpression("10 + 1")),
                () -> assertEquals("13", calculator.calculateExpression("4 + 9")),
                () -> assertEquals("2", calculator.calculateExpression("1 + 1")),
                () -> assertEquals("20", calculator.calculateExpression("10 + 10")),
                () -> assertEquals("7", calculator.calculateExpression("3 + 4")),
                () -> assertEquals("5", calculator.calculateExpression("1 + 4")),
                () -> assertEquals("13", calculator.calculateExpression("3 + 10"))
        );
    }

    @Test
    void subtractionOfArabicIntegerNumbersFromOneToTenShouldBeSuccessful() {
        assertAll("",
                () -> assertEquals("-1", calculator.calculateExpression("1 - 2")),
                () -> assertEquals("9", calculator.calculateExpression("10 - 1")),
                () -> assertEquals("-5", calculator.calculateExpression("4 - 9")),
                () -> assertEquals("0", calculator.calculateExpression("1 - 1")),
                () -> assertEquals("0", calculator.calculateExpression("10 - 10")),
                () -> assertEquals("-9", calculator.calculateExpression("1 - 10")),
                () -> assertEquals("1", calculator.calculateExpression("4 - 3")),
                () -> assertEquals("-7", calculator.calculateExpression("3 - 10"))
        );
    }

    @Test
    void multiplicationOfArabicIntegerNumbersFromOneToTenShouldBeSuccessful() {
        assertAll("",
                () -> assertEquals("2", calculator.calculateExpression("1 * 2")),
                () -> assertEquals("100", calculator.calculateExpression("10 * 10")),
                () -> assertEquals("36", calculator.calculateExpression("4 * 9")),
                () -> assertEquals("1", calculator.calculateExpression("1 * 1")),
                () -> assertEquals("63", calculator.calculateExpression("9 * 7")),
                () -> assertEquals("12", calculator.calculateExpression("6 * 2")),
                () -> assertEquals("32", calculator.calculateExpression("8 * 4")),
                () -> assertEquals("10", calculator.calculateExpression("1 * 10"))
        );
    }

    @Test
    void divisionOfArabicIntegerNumbersFromOneToTenShouldBeSuccessful() {
        assertAll("",
                () -> assertEquals("0", calculator.calculateExpression("1 / 2")),
                () -> assertEquals("1", calculator.calculateExpression("10 / 10")),
                () -> assertEquals("5", calculator.calculateExpression("10 / 2")),
                () -> assertEquals("9", calculator.calculateExpression("9 / 1")),
                () -> assertEquals("2", calculator.calculateExpression("6 / 3")),
                () -> assertEquals("2", calculator.calculateExpression("5 / 2")),
                () -> assertEquals("1", calculator.calculateExpression("8 / 5")),
                () -> assertEquals("0", calculator.calculateExpression("1 / 10"))
        );
    }

    @Test
    void additionOfRomanIntegerNumbersFromOneToTenShouldBeSuccessful() {
        assertAll("",
                () -> assertEquals("III", calculator.calculateExpression("I + II")),
                () -> assertEquals("XI", calculator.calculateExpression("X + I")),
                () -> assertEquals("XIII", calculator.calculateExpression("IV + IX")),
                () -> assertEquals("II", calculator.calculateExpression("I + I")),
                () -> assertEquals("XX", calculator.calculateExpression("X + X")),
                () -> assertEquals("VII", calculator.calculateExpression("III + IV")),
                () -> assertEquals("V", calculator.calculateExpression("I + IV")),
                () -> assertEquals("XI", calculator.calculateExpression("III + VIII"))
        );
    }

    @Test
    void subtractionOfRomanIntegerNumbersFromOneToTenShouldBeSuccessful() {
        assertAll("",
                () -> assertEquals("I", calculator.calculateExpression("II - I")),
                () -> assertEquals("VII", calculator.calculateExpression("X - III")),
                () -> assertEquals("II", calculator.calculateExpression("IV - II")),
                () -> assertEquals("III", calculator.calculateExpression("VIII - V")),
                () -> assertEquals("III", calculator.calculateExpression("IX - VI")),
                () -> assertEquals("I", calculator.calculateExpression("V - IV")),
                () -> assertEquals("III", calculator.calculateExpression("VII - IV")),
                () -> assertEquals("VIII", calculator.calculateExpression("X - II"))
        );
    }

    @Test
    void multiplicationOfRomanIntegerNumbersFromOneToTenShouldBeSuccessful() {
        assertAll("",
                () -> assertEquals("II", calculator.calculateExpression("I * II")),
                () -> assertEquals("C", calculator.calculateExpression("X * X")),
                () -> assertEquals("XXXVI", calculator.calculateExpression("IV * IX")),
                () -> assertEquals("I", calculator.calculateExpression("I * I")),
                () -> assertEquals("LXIII", calculator.calculateExpression("IX * VII")),
                () -> assertEquals("XII", calculator.calculateExpression("VI * II")),
                () -> assertEquals("XXXII", calculator.calculateExpression("VIII * IV")),
                () -> assertEquals("X", calculator.calculateExpression("I * X"))
        );
    }

    @Test
    void divisionOfRomanIntegerNumbersFromOneToTenShouldBeSuccessful() {
        assertAll("",
                () -> assertEquals("I", calculator.calculateExpression("III / II")),
                () -> assertEquals("I", calculator.calculateExpression("X / X")),
                () -> assertEquals("V", calculator.calculateExpression("X / II")),
                () -> assertEquals("IX", calculator.calculateExpression("IX / I")),
                () -> assertEquals("II", calculator.calculateExpression("VI / III")),
                () -> assertEquals("II", calculator.calculateExpression("V / II")),
                () -> assertEquals("I", calculator.calculateExpression("VIII / V")),
                () -> assertEquals("I", calculator.calculateExpression("I / I"))
        );
    }
}