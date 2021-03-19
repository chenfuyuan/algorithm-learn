package com.cfy.learn.algorithm.base.stack.calculate.operator;

import com.uptool.core.Exception.ArgumentEmptyException;
import com.uptool.core.util.NumberUtil;

/**
 * @Description: 计算对象
 * @Author chenfuyuan
 * @Date 2021/3/19 16:07
 */
public abstract class Operator {

    /**
     * 操作数集合大小 2
     */
    protected static final int VALS_SIZE_TWO = 2;
    /**
     * 操作数集合大小 1
     */
    protected static final int VALS_SIZE_ONE = 1;


    /**
     * 根据自身规则进行计算
     * @param vals 计算值集合
     * @return 计算结果
     */
    public double calculate(Double... vals){
        checkValList(vals);
        return calculateResult(vals);
    }


    /**
     * 校验操作数集合
     * @param vals 操作数
     * @exception ArgumentEmptyException 参数为空，抛出异常
     * @exception CalculateValListException 操作数数量不为2抛出异常
     */
    private void checkValList(Double... vals) {
        if (vals == null) {
            throw new ArgumentEmptyException("操作数集合为空;");
        }

        checkValLength(vals.length);

    }

    /**
     * 校验操作数集合长度是否符合要求
     * @param length
     */
    protected void checkValLength(int length){
        if (length != VALS_SIZE_TWO) {
            throw new CalculateValListException();
        }
    }

    /**
     * 根据子类规则计算结果
     * @param vals 操作数集合
     * @return 计算结果
     */
    protected abstract double calculateResult(Double... vals);
}
