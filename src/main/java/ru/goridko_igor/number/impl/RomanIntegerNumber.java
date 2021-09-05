package ru.goridko_igor.number.impl;

import ru.goridko_igor.number.IntegerNumber;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class RomanIntegerNumber implements IntegerNumber {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 3999;
    private static final NavigableMap<Integer, String> keyRomanNumbers = new TreeMap<>();
    private static final Map<String, Integer> firstRomanNumbers = Map.of(
            "I", 1,
            "II", 2,
            "III", 3,
            "IV", 4,
            "V", 5,
            "VI", 6,
            "VII", 7,
            "VIII", 8,
            "IX", 9,
            "X", 10
    );

    static {
        keyRomanNumbers.put(1000, "M");
        keyRomanNumbers.put(900, "CM");
        keyRomanNumbers.put(500, "D");
        keyRomanNumbers.put(400, "CD");
        keyRomanNumbers.put(100, "C");
        keyRomanNumbers.put(90, "XC");
        keyRomanNumbers.put(50, "L");
        keyRomanNumbers.put(40, "XL");
        keyRomanNumbers.put(10, "X");
        keyRomanNumbers.put(9, "IX");
        keyRomanNumbers.put(5, "V");
        keyRomanNumbers.put(4, "IV");
        keyRomanNumbers.put(1, "I");
    }

    private final int value;

    public RomanIntegerNumber(int value) {
        this.value = value;
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new RuntimeException("Значение value должно быть " +
                    "в интервале [" + MIN_VALUE + ", " + MAX_VALUE + "].");
        }
    }

    public RomanIntegerNumber(String romanValue) {
        this(convertValueFromRomanToArabic(romanValue));
        if (!Pattern.compile("^(I|II|III|IV|V|VI|VII|VIII|IX|X)$").matcher(romanValue).matches()) {
            throw new RuntimeException("Значение value должно быть " +
                    "в интервале [" + MIN_VALUE + ", " + MAX_VALUE + "].");
        }
    }

    protected static int convertValueFromRomanToArabic(String romanValue) {
        return firstRomanNumbers.get(romanValue);
    }

    private static String convertValueFromArabicToRoman(int arabicValue) {
        int currentKeyRomanNumber = keyRomanNumbers.floorKey(arabicValue);
        if (arabicValue == currentKeyRomanNumber) {
            return keyRomanNumbers.get(arabicValue);
        }
        return keyRomanNumbers.get(currentKeyRomanNumber)
                + convertValueFromArabicToRoman(arabicValue - currentKeyRomanNumber);
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public IntegerNumber add(IntegerNumber addend) {
        int resultValue = this.value + addend.getValue();
        return new RomanIntegerNumber(resultValue);
    }

    @Override
    public IntegerNumber subtract(IntegerNumber subtrahend) {
        int resultValue = this.value - subtrahend.getValue();
        if (resultValue < MIN_VALUE) {
            throw new RuntimeException("Значение value не можеть быть " +
                    "неположительным в римской системе счисления. " +
                    "Значение value должно быть в интервале " +
                    "[" + MIN_VALUE + ", " + MAX_VALUE + "].");
        }
        return new RomanIntegerNumber(resultValue);
    }

    @Override
    public IntegerNumber multiply(IntegerNumber multiplier) {
        int resultValue = this.value * multiplier.getValue();
        return new RomanIntegerNumber(resultValue);
    }

    @Override
    public IntegerNumber divide(IntegerNumber divisor) {
        int resultValue = this.value / divisor.getValue();
        if (resultValue < MIN_VALUE) {
            throw new RuntimeException("Значение value не можеть быть " +
                    "неположительным в римской системе счисления. " +
                    "Значение value должно быть в интервале " +
                    "[" + MIN_VALUE + ", " + MAX_VALUE + "].");
        }
        return new RomanIntegerNumber(resultValue);
    }

    @Override
    public String toString() {
        return convertValueFromArabicToRoman(value);
    }
}
