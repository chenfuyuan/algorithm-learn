package com.cfy.learn.algorithm.sort;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description: 排序工厂
 * @Author: chenfuyuan
 * @Date: 2021/3/25 15:13
 */
public class SortFactory {

    public static void sort(String sortType, Comparable[] array) {
        try {
            Class<?> sortClass = Class.forName(sortType);
            sort(sortClass, array);
        } catch (ClassNotFoundException e) {
            System.out.println("查询不到对应排序类");
        }
    }

    public static void sort(Class<?> sortClass, Comparable[] array) {
        try {
            Method sortMethod = sortClass.getDeclaredMethod("sort", Comparable[].class);
            sortMethod.invoke(null,(Object)array);
        } catch (NoSuchMethodException e) {
            System.out.println("排序类无排序方法");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void sort(String sortType, Comparable[] array,int low,int hight) {
        try {
            Class<?> sortClass = Class.forName(sortType);
            sort(sortClass, array,low,hight);
        } catch (ClassNotFoundException e) {
            System.out.println("查询不到对应排序类");
        }
    }

    public static void sort(Class<?> sortClass, Comparable[] array,int low,int hight) {
        try {
            Method sortMethod = sortClass.getDeclaredMethod("sort", Comparable[].class,int.class,int.class);
            sortMethod.invoke(null,(Object)array,low,hight);
        } catch (NoSuchMethodException e) {
            System.out.println("排序类无排序方法");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
