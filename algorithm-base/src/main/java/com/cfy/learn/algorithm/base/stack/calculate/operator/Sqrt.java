package com.cfy.learn.algorithm.base.stack.calculate.operator;

import com.uptool.core.Exception.ArgumentEmptyException;
import com.uptool.core.util.CalculateUtil;

/**
 * @Description: 开平方根
 * @Author chenfuyuan
 * @Date 2021/3/19 16:56
 */
public class Sqrt extends Operator {


    @Override
    protected void checkValLength(int length) {
        if (length != VALS_SIZE_ONE) {
            throw new CalculateValListException();
        }
    }

    /**
     * 开平方根
     * @param vals 操作数集合
     * @return
     */
    @Override
    protected double calculateResult(Double... vals) {
        return CalculateUtil.sqrt(vals[0]);
    }
}
