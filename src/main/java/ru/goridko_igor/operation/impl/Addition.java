package ru.goridko_igor.operation.impl;

import ru.goridko_igor.number.IntegerNumber;
import ru.goridko_igor.operation.Operation;

public class Addition implements Operation {
    @Override
    public IntegerNumber apply(IntegerNumber augend, IntegerNumber addend) {
        return augend.add(addend);
    }
}
