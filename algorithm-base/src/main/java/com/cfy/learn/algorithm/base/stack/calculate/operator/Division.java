package com.cfy.learn.algorithm.base.stack.calculate.operator;

import com.uptool.core.util.CalculateUtil;

/**
 * @Description: 除法
 * @Author chenfuyuan
 * @Date 2021/3/19 16:51
 */
public class Division extends Operator{

    /**
     * 根据除法规则进行计算
     * @param vals 计算值集合
     * @return 计算结果
     */
    @Override
    protected double calculateResult(Double... vals) {
        return CalculateUtil.divide(vals[0], vals[1]);
    }
}
