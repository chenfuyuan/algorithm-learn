package com.cfy.learn.algorithm.base.stack.calculate;

/**
 * @Description: 计算接口
 * @Author chenfuyuan
 * @Date 2021/3/19 15:41
 */
public interface CalculateAble {

    /**
     * 左括号
     */
    String BRACKET_LEFT = "(";

    /**
     * 右括号
     */
    String BRACKET_RIGHT = ")";


    double calculate();


}
