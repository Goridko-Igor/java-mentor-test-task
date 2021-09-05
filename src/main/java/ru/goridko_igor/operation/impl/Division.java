package ru.goridko_igor.operation.impl;

import ru.goridko_igor.number.IntegerNumber;
import ru.goridko_igor.operation.Operation;

public class Division implements Operation {
    @Override
    public IntegerNumber apply(IntegerNumber dividend, IntegerNumber divisor) {
        return dividend.divide(divisor);
    }
}
