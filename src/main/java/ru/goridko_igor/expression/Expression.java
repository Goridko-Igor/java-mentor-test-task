package ru.goridko_igor.expression;

import ru.goridko_igor.exception.ExpressionCalculationException;
import ru.goridko_igor.number.IntegerNumber;

public interface Expression {
    IntegerNumber calculate() throws ExpressionCalculationException;
}
