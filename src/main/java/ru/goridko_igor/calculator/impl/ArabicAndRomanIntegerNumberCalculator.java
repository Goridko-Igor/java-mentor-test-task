package ru.goridko_igor.calculator.impl;

import ru.goridko_igor.calculator.Calculator;
import ru.goridko_igor.exception.ExpressionBuilderException;
import ru.goridko_igor.exception.ExpressionCalculationException;
import ru.goridko_igor.expression.Expression;
import ru.goridko_igor.expression.ExpressionBuilder;
import ru.goridko_igor.expression.impl.ArabicAndRomanIntegerNumberExpressionBuilder;

public class ArabicAndRomanIntegerNumberCalculator implements Calculator {
    private static final ExpressionBuilder EXPRESSION_BUILDER = new ArabicAndRomanIntegerNumberExpressionBuilder();

    @Override
    public String calculateExpression(String expression) {
        String result = null;

        try {
            Expression arabicAndRomanNumberExpression = EXPRESSION_BUILDER.buildExpression(expression);
            result = arabicAndRomanNumberExpression.calculate().toString();
        } catch (ExpressionBuilderException | ExpressionCalculationException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        return result;
    }
}
