package com.cfy.learn.algorithm.base.stack.calculate.operator;

import com.uptool.core.util.CalculateUtil;
import com.uptool.core.util.NumberUtil;

/**
 * @Description: 加操作
 * @Author chenfuyuan
 * @Date 2021/3/19 16:10
 */
public class Addition extends Operator {

    /**
     * 根据加法规则进行计算
     * @param vals 计算值集合
     * @return 计算结果
     */
    @Override
    protected double calculateResult(Double... vals) {
        return CalculateUtil.add(vals[0], vals[1]);
    }
}
