package com.cfy.learn.algorithm.util;

/**
 * @Description: 数字类型工具类
 * @Author chenfuyuan
 * @Date 2021/2/12 11:16
 */
public class NumberUtil {

    /**
     * 零
     */
    public static int ZERO = 0;

    /**
     * 一
     */
    public static int ONE = 1;

    /*=======================isZero()======================*/
    /**
     * 判断整型数据是否为0
     * @param value 值
     * @return 是否为0
     */
    public static boolean isZero(int value) {
        return value == 0;
    }

    /**
     * 判断双精度浮点数数据是否为0
     * @param value 值
     * @return 是否为0
     */
    public static boolean isZero(double value) {
        return value < 1.0E-8D && value > -1.0E-8D;
    }

    /**
     * 判断单精度浮点数数据是否为0
     * @param value 值
     * @return 是否为0
     */
    public static boolean isZero(float value) {
        return value < 1.0E-8 && value > -1.0E-8;
    }

    /**
     * 判断数据是否为0
     * @param value 值
     * @return 是否为0
     */
    public static boolean isZero(short value) {
        return value == 0;
    }

    /**
     * 判断整型数据是否为0
     * @param value 值
     * @return 是否为0
     */
    public static boolean isZero(long value) {
        return value == 0;
    }


}
