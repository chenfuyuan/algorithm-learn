package com.cfy.learn.algorithm.base.stack.calculate.operator;

/**
 * @Description:
 * @Author chenfuyuan
 * @Date 2021/3/19 16:26
 */
public class CalculateValListException extends RuntimeException{

    public CalculateValListException() {
        super("操作数数量错误;");
    }

    public CalculateValListException(String message) {
        super(message);
    }
}
