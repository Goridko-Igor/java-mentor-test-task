package ru.goridko_igor.number.impl;

public class InputArabicIntegerNumber extends ArabicIntegerNumber {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 10;

    public InputArabicIntegerNumber(int value) {
        super(value);
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new NumberFormatException("Значение value должно быть " +
                    "в интервале [" + MIN_VALUE + ", " + MAX_VALUE + "].");
        }
    }

    public InputArabicIntegerNumber(String arabicValue) {
        this(Integer.parseInt(arabicValue));
    }
}
