package ru.goridko_igor.expression;

import ru.goridko_igor.exception.ExpressionBuilderException;

public interface ExpressionBuilder {
    Expression buildExpression(String expression) throws ExpressionBuilderException;
}
