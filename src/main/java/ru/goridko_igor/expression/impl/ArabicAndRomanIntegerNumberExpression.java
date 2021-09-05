package ru.goridko_igor.expression.impl;

import ru.goridko_igor.exception.ExpressionCalculationException;
import ru.goridko_igor.expression.Expression;
import ru.goridko_igor.number.IntegerNumber;
import ru.goridko_igor.operation.Operation;

public class ArabicAndRomanIntegerNumberExpression implements Expression {
    private final IntegerNumber operand1;
    private final IntegerNumber operand2;
    private final Operation operation;

    public ArabicAndRomanIntegerNumberExpression(
            IntegerNumber operand1,
            IntegerNumber operand2,
            Operation operation) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operation = operation;
    }

    @Override
    public IntegerNumber calculate() throws ExpressionCalculationException {
        IntegerNumber result;

        try {
            result = operation.apply(operand1, operand2);
        } catch (RuntimeException e) {
            throw new ExpressionCalculationException("Ошибка при вычислении выражения.", e);
        }

        return result;
    }
}
