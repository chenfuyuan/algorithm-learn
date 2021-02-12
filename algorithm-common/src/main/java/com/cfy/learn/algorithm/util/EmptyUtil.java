package com.cfy.learn.algorithm.util;

import java.util.Collection;

/**
 * @Description: 判空工具类
 * @Author chenfuyuan
 * @Date 2021/2/12 11:12
 */
public class EmptyUtil {

    /*==================isEmpty=================*/

    /**
     * 校验对象是否为空
     * @param obj 对象
     * @return 是否为空
     */
    public static boolean isEmpty(Object obj) {
        return obj == null;
    }

    /**
     * 校验数组是否为空
     * @param array 数组
     * @return 是否为空
     */
    public static <T>  boolean isEmpty(T[] array) {
        return array == null || array.length == NumberUtil.ZERO;

    }

    /**
     * 校验数组是否为空
     * @param array 数组
     * @return 是否为空
     */
    public static  boolean isEmpty(String[] array) {
        if (array == null || array.length == NumberUtil.ZERO) {
            return true;
        }

        for (String value : array) {
            if (isNotEmpty(value)) {
                return false;
            }
        }

        return true;
    }

    /**
     * 校验数组是否为空
     * @param array 数组
     * @return 是否为空
     */
    public static  boolean isEmpty(short[] array) {
        if (array == null  || array.length == NumberUtil.ZERO) {
            return true;
        }

        for (short value : array) {
            if (!NumberUtil.isZero(value)){
                return false;
            }
        }

        return true;
    }

    /**
     * 校验数组是否为空
     * @param array 数组
     * @return 是否为空
     */
    public static  boolean isEmpty(int[] array) {
        if (array == null  || array.length == NumberUtil.ZERO) {
            return true;
        }

        for (int value : array) {
            if (!NumberUtil.isZero(value)){
                return false;
            }
        }

        return true;
    }

    /**
     * 校验数组是否为空
     * @param array 数组
     * @return 是否为空
     */
    public static  boolean isEmpty(long[] array) {
        if (array == null  || array.length == NumberUtil.ZERO) {
            return true;
        }

        for (long value : array) {
            if (!NumberUtil.isZero(value)){
                return false;
            }
        }

        return true;
    }



    /**
     * 校验数组是否为空
     * @param array 数组
     * @return 是否为空
     */
    public static  boolean isEmpty(float[] array) {
        if (array == null  || array.length == NumberUtil.ZERO) {
            return true;
        }

        for (float value : array) {
            if (!NumberUtil.isZero(value)){
                return false;
            }
        }

        return true;
    }

    /**
     * 校验数组是否为空
     * @param array 数组
     * @return 是否为空
     */
    public static  boolean isEmpty(double[] array) {
        if (array == null  || array.length == NumberUtil.ZERO) {
            return true;
        }

        for (double value : array) {
            if (!NumberUtil.isZero(value)){
                return false;
            }
        }

        return true;
    }


    /**
     * 校验数组是否为空
     * @param array 数组
     * @return 是否为空
     */
    public static  boolean isEmpty(boolean[] array) {
        return array == null || array.length == NumberUtil.ZERO;
    }


    /**
     * 校验字符串是否为空
     * 当字符串对象为null 或 字符串为空串，或 为'null'时为空
     * @param value 字符串
     * @return 是否为空
     */
    public static boolean isEmpty(String value) {
        return value == null || StringUtil.STRING_EMPTY.equals(value) || StringUtil.STRING_NULL.equals(value);
    }

    /**
     * 判断集合类型是否为空
     * @param collection
     * @return
     */
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }



    /*==================isNotEmpty================*/

    /**
     * 校验对象是否非空
     * @param obj 对象
     * @return 是否非空
     */
    public static<T> boolean isNotEmpty(T obj) {
        return !isEmpty(obj);
    }

    /**
     * 校验对象是否非空
     * @param obj 对象
     * @return 是否非空
     */
    public static boolean isNotEmpty(String obj) {
        return !isEmpty(obj);
    }

    /**
     * 判断数组对象是否非空
     * @param array 数组
     * @return 是否非空
     */
    public static boolean isNotEmpty(short[] array) {
        return !isEmpty(array);
    }

    /**
     * 判断数组对象是否非空
     * @param array 数组
     * @return 是否非空
     */
    public static boolean isNotEmpty(int[] array) {
        return !isEmpty(array);
    }

    /**
     * 判断数组对象是否非空
     * @param array 数组
     * @return 是否非空
     */
    public static boolean isNotEmpty(long[] array) {
        return !isEmpty(array);
    }

    /**
     * 判断数组对象是否非空
     * @param array 数组
     * @return 是否非空
     */
    public static boolean isNotEmpty(float[] array) {
        return !isEmpty(array);
    }

    /**
     * 判断数组对象是否非空
     * @param array 数组
     * @return 是否非空
     */
    public static boolean isNotEmpty(double[] array) {
        return !isEmpty(array);
    }

    /**
     * 判断数组对象是否非空
     * @param array 数组
     * @return 是否非空
     */
    public static boolean isNotEmpty(boolean[] array) {
        return !isEmpty(array);
    }

    /**
     * 判断数组是否非空
     * @param array 数组
     * @param <T> 泛型
     * @return 是否非空
     */
    public static<T> boolean isNotEmpty(T[] array) {
        return !isEmpty(array);
    }

    /**
     * 判断数组是否非空
     * @param array 数组
     * @return 是否非空
     */
    public static boolean isNotEmpty(String[] array) {
        return !isEmpty(array);
    }


    /**
     * 判断集合类型是否非空
     * @param collection 集合类型
     * @return 是否非空
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

}
