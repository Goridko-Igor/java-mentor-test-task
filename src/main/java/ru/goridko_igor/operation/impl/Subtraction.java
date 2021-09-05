package ru.goridko_igor.operation.impl;

import ru.goridko_igor.number.IntegerNumber;
import ru.goridko_igor.operation.Operation;

public class Subtraction implements Operation {
    @Override
    public IntegerNumber apply(IntegerNumber minuend, IntegerNumber subtrahend) {
        return minuend.subtract(subtrahend);
    }
}
