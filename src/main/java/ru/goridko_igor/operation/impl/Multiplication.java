package ru.goridko_igor.operation.impl;

import ru.goridko_igor.number.IntegerNumber;
import ru.goridko_igor.operation.Operation;

public class Multiplication implements Operation {
    @Override
    public IntegerNumber apply(IntegerNumber multiplicand, IntegerNumber multiplier) {
        return multiplicand.multiply(multiplier);
    }
}
