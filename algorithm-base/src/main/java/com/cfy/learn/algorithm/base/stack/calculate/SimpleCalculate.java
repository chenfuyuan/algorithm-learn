package com.cfy.learn.algorithm.base.stack.calculate;

import com.cfy.learn.algorithm.base.stack.calculate.operator.Operator;
import com.cfy.learn.algorithm.base.stack.calculate.operator.OperatorEnum;

import java.util.Stack;

/**
 * @Description: 通过栈 简单解析表达式，并计算结果
 * @Author chenfuyuan
 * @Date 2021/3/19 15:25
 */
public class SimpleCalculate implements CalculateAble {

    /**
     * 表达式分隔符
     */
    public final static String EXPRESSION_SPLIT = " ";

    /**
     * 表达式
     */
    private String expression;

    /**
     * 计算结果
     */
    private Double result;


    public SimpleCalculate(String expression) {
        this.expression = expression;
    }

    /**
     * 设置表达式
     * @param expression
     */
    public void setExpression(String expression) {
        this.expression = expression;
    }

    /**
     * 进行计算
     */
    @Override
    public double calculate() {
        if (result != null) {
            return result;
        }
        result = calculate(expression);
        return result;
    }

    /**
     * 进行计算
     * @param expression 表达式
     * @return 计算结果
     */
    public static double calculate(String expression) {
        //操作符栈
        Stack<String> opStack = new Stack<>();

        //操作数栈
        Stack<Double> valStack = new Stack<>();

        //根据分隔符分开
        String[] expressionList = expression.split(EXPRESSION_SPLIT);

        for (String item : expressionList) {
            if (BRACKET_LEFT.equals(item)) {
                continue;
            }

            if (isOps(item)) {
                opStack.push(item);
                continue;
            }

            if (BRACKET_RIGHT.equals(item)) {
                //进行计算
                executeOps(opStack,valStack);

                continue;
            }

            valStack.push(Double.parseDouble(item));
        }

        return valStack.pop();
    }

    /**
     * 执行
     * @param opStack 操作数
     * @param valStack 值
     */
    private static void executeOps(Stack<String> opStack, Stack<Double> valStack) {
        String op = opStack.pop();
        Double val = valStack.pop();

        Operator operator = OperatorEnum.getOperator(op);
        if (operator == null) {
            throw new RuntimeException("运算符解析错误;");
        }

        double calculateResult = operator.calculate(valStack.pop(), val);
        valStack.push(calculateResult);
    }


    /**
     * 判断是否相等
     * @param sign 操作符对象
     * @return
     */
    private static boolean isOps(String sign) {
        return OperatorEnum.isOperator(sign);
    }

}
