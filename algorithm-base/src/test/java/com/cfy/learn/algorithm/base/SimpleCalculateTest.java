package com.cfy.learn.algorithm.base;

import com.cfy.learn.algorithm.base.stack.calculate.SimpleCalculate;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author chenfuyuan
 * @Date 2021/3/19 17:09
 */
public class SimpleCalculateTest {

    private String expression;

    @BeforeEach
    public void before() {
        expression = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
    }

    @Test
    public void calculate() {
        SimpleCalculate simpleCalculate = new SimpleCalculate(expression);
        double calculate = simpleCalculate.calculate();
        System.out.println(expression + "="+calculate);
    }
}
