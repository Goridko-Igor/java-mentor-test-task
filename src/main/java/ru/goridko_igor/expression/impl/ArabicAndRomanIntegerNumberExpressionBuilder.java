package ru.goridko_igor.expression.impl;

import ru.goridko_igor.exception.ExpressionBuilderException;
import ru.goridko_igor.expression.Expression;
import ru.goridko_igor.expression.ExpressionBuilder;
import ru.goridko_igor.number.IntegerNumber;
import ru.goridko_igor.number.impl.InputArabicIntegerNumber;
import ru.goridko_igor.number.impl.InputRomanIntegerNumber;
import ru.goridko_igor.operation.Operation;
import ru.goridko_igor.operation.impl.Addition;
import ru.goridko_igor.operation.impl.Division;
import ru.goridko_igor.operation.impl.Multiplication;
import ru.goridko_igor.operation.impl.Subtraction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class ArabicAndRomanIntegerNumberExpressionBuilder implements ExpressionBuilder {
    private static final Map<String, Operation> operations = Map.of(
            "+", new Addition(),
            "-", new Subtraction(),
            "*", new Multiplication(),
            "/", new Division()
    );

    @Override
    public Expression buildExpression(String expression) throws ExpressionBuilderException {
        Expression result;

        try {
            if (expression == null) {
                throw new NullPointerException("Выражение expression не может быть null.");
            }

            if (expression.isEmpty()) {
                throw new IllegalStateException("Выражение expression не может быть пустым.");
            }
        } catch (NullPointerException | IllegalStateException e) {
            throw new ExpressionBuilderException("Выражение expression не является математической операцией.", e);
        }

        List<String> expressionParts = splitExpressionIntoParts(expression);

        try {
            if (expressionParts.size() < 3) {
                throw new RuntimeException("Выражение expression содержит менее трёх необходимых элементов.");
            }
        } catch (RuntimeException e) {
            throw new ExpressionBuilderException("Выражение expression не является математической операцией.", e);
        }

        try {
            if (expressionParts.size() > 3) {
                throw new RuntimeException("Выражение expression содержит более трёх необходимых элементов.");
            }
        } catch (RuntimeException e) {
            throw new ExpressionBuilderException("Выражение expression не является поддерживаемой математической " +
                    "операцией. Поддерживаются математические операции с двумя операндами и одним оператором " +
                    "(+, -, /, *).", e);
        }

        IntegerNumber operand1 = buildOperand(expressionParts.get(0));
        IntegerNumber operand2 = buildOperand(expressionParts.get(2));

        Operation operation = null;
        if (Pattern.compile("^[+\\-*/]$").matcher(expressionParts.get(1)).matches()) {
            operation = operations.get(expressionParts.get(1));
        }

        try {
            if (operation == null) {
                throw new RuntimeException("Математический оператор не распознан.");
            }
        } catch (RuntimeException e) {
            throw new ExpressionBuilderException("Математический оператор выражения не распознан.", e);
        }

        try {
            if (operand1.getClass() != operand2.getClass()) {
                throw new RuntimeException("Классы операндов не совпадают.");
            }
        } catch (RuntimeException e) {
            throw new ExpressionBuilderException("Операнды выражения принадлежат разным системам счисления.", e);
        }

        result = new ArabicAndRomanIntegerNumberExpression(operand1, operand2, operation);

        return result;
    }

    private List<String> splitExpressionIntoParts(String expression) {
        expression = expression.trim()
                .replaceAll("\\+", " + ")
                .replaceAll("-", " - ")
                .replaceAll("\\*", " * ")
                .replaceAll("/", " / ")
                .replaceAll("\\s+", " ")
                .toUpperCase();
        return new ArrayList<>(Arrays.asList(expression.split(" ")));
    }

    private IntegerNumber buildOperand(String operand) throws ExpressionBuilderException {
        IntegerNumber result;

        try {
            if (Pattern.compile("^\\d+$").matcher(operand).matches()) {
                result = new InputArabicIntegerNumber(operand);
            } else if (Pattern.compile("^(I|II|III|IV|V|VI|VII|VIII|IX|X)$").matcher(operand).matches()) {
                result = new InputRomanIntegerNumber(operand);
            } else {
                throw new RuntimeException("Операнд operand не является числом.");
            }
        } catch (NumberFormatException e1) {
            throw new ExpressionBuilderException("Значение операнда operand находится вне границ " +
                    "отрезка [1, 10] ([I, X] в римской системе счисления).", e1);
        } catch (RuntimeException e2) {
            throw new ExpressionBuilderException("Операнд operand не является числом.", e2);
        }

        return result;
    }
}
