package ru.goridko_igor.number;

public interface IntegerNumber {
    int getValue();

    IntegerNumber add(IntegerNumber addend);

    IntegerNumber subtract(IntegerNumber subtrahend);

    IntegerNumber multiply(IntegerNumber multiplier);

    IntegerNumber divide(IntegerNumber divisor);

    String toString();
}
