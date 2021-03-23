package com.cfy.learn.algorithm.datastruct.common.exception;

/**
 * @Description: 数据结构为空
 * @Author chenfuyuan
 * @Date 2021/3/23 15:28
 */
public class DataStructEmptyException extends RuntimeException{

    public DataStructEmptyException() {
        super("对象为空，无法获取到数据;");
    }

    public DataStructEmptyException(String message) {
        super(message);
    }

}
