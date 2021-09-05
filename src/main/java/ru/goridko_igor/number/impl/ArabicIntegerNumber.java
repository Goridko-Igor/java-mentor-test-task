package ru.goridko_igor.number.impl;

import ru.goridko_igor.number.IntegerNumber;

public class ArabicIntegerNumber implements IntegerNumber {
    private final int value;

    public ArabicIntegerNumber(int value) {
        this.value = value;
    }

    public ArabicIntegerNumber(String arabicValue) {
        this(Integer.parseInt(arabicValue));
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public IntegerNumber add(IntegerNumber addend) {
        int resultValue = this.value + addend.getValue();
        return new ArabicIntegerNumber(resultValue);
    }

    @Override
    public IntegerNumber subtract(IntegerNumber subtrahend) {
        int resultValue = this.value - subtrahend.getValue();
        return new ArabicIntegerNumber(resultValue);
    }

    @Override
    public IntegerNumber multiply(IntegerNumber multiplier) {
        int resultValue = this.value * multiplier.getValue();
        return new ArabicIntegerNumber(resultValue);
    }

    @Override
    public IntegerNumber divide(IntegerNumber divisor) {
        int resultValue = this.value / divisor.getValue();
        return new ArabicIntegerNumber(resultValue);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
