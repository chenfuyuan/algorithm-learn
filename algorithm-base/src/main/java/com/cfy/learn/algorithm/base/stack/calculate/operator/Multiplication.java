package com.cfy.learn.algorithm.base.stack.calculate.operator;

import com.uptool.core.util.CalculateUtil;

/**
 * @Description: 乘法
 * @Author chenfuyuan
 * @Date 2021/3/19 16:38
 */
public class Multiplication extends Operator {


    /**
     * 根据乘法规则进行计算
     * @param vals 计算值集合
     * @return 计算结果
     */
    @Override
    protected double calculateResult(Double... vals) {
        return CalculateUtil.multiply(vals[0], vals[1]);
    }
}
