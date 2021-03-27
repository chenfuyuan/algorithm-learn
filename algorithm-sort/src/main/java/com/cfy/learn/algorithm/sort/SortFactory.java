package com.cfy.learn.algorithm.sort;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description: 排序工厂
 * @Author: chenfuyuan
 * @Date: 2021/3/25 15:13
 */
public class SortFactory {

    /**
     * 排序
     * @param sortType 排序类型
     * @param array 数组
     */
    public static void sort(String sortType, Comparable<?>[] array) {
        try {
            Class<?> sortClass =  Class.forName(sortType);
            sort(sortClass, array);
        } catch (ClassNotFoundException e) {
            System.out.println("查询不到对应排序类");
        }
    }

    /**
     * 排序
     * @param sortClass 排序类
     * @param array 数组
     */
    public static void sort(Class<?> sortClass, Comparable<?>[] array) {
        try {
            Method sortMethod = sortClass.getDeclaredMethod("sort", Comparable[].class);
            //当参数是最后一个时,数组需要转换成Oject对象不然会被 Oject[]参数数组传递过去。
            sortMethod.invoke(null,(Object)array);
        } catch (NoSuchMethodException e) {
            System.out.println("排序类无排序方法");
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 排序
     * @param sortType 排序类型
     * @param array 排序数组
     * @param startIndex 开始位置
     * @param length 排序长度
     */
    public static void sort(String sortType, Comparable<?>[] array,int startIndex,int length) {
        try {
            Class<?> sortClass = Class.forName(sortType);
            sort(sortClass, array,startIndex,length);
        } catch (ClassNotFoundException e) {
            System.out.println("查询不到对应排序类");
        }
    }

    /**
     * 排序
     * @param sortClass 排序类
     * @param array 数组
     * @param startIndex 开始位置
     * @param length 长度
     */
    public static void sort(Class<?> sortClass, Comparable<?>[] array,int startIndex,int length) {
        try {
            Method sortMethod = sortClass.getDeclaredMethod("sort", Comparable[].class,int.class,int.class);

            sortMethod.invoke(null,array,startIndex,length);
        } catch (NoSuchMethodException e) {
            System.out.println("排序类无排序方法");
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
