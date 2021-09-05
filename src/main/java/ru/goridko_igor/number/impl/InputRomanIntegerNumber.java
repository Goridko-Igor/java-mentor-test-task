package ru.goridko_igor.number.impl;

import java.util.regex.Pattern;

public class InputRomanIntegerNumber extends RomanIntegerNumber {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 10;

    public InputRomanIntegerNumber(int value) {
        super(value);
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new NumberFormatException("Значение value должно быть " +
                    "в интервале [" + MIN_VALUE + ", " + MAX_VALUE + "].");
        }
    }

    public InputRomanIntegerNumber(String romanValue) {
        this(convertValueFromRomanToArabic(romanValue));
        if (!Pattern.compile("^(I|II|III|IV|V|VI|VII|VIII|IX|X)$").matcher(romanValue).matches()) {
            throw new NumberFormatException("Значение value должно быть " +
                    "в интервале [" + MIN_VALUE + ", " + MAX_VALUE + "].");
        }
    }
}
