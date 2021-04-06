package com.cfy.learn.algorithm.search.symboltable;

/**
 * @Description: 符号表工厂
 * @Author: chenfuyuan
 * @Date: 2021/4/6 21:40
 */
public class SymbolTableFactory {

    /**
     * 解析字符串获取对应符号表
     * @param className 类名
     * @return 符号表对象
     * @throws ClassNotFoundException 类未找到
     * @throws IllegalAccessException 参数错误
     * @throws InstantiationException 实例化错误
     */
    public SymbolTable getSymbolTable(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
            Class<?> symbolTableClass = Class.forName(className);
            return (SymbolTable) symbolTableClass.newInstance();
    }

    /**
     * 解析Class对象获取对应符号表
     * @param classType 类
     * @return 符号表对象
     * @throws IllegalAccessException 参数错误
     * @throws InstantiationException 实例化错误
     */
    public SymbolTable getSymbolTable(Class<SymbolTable> classType) throws IllegalAccessException, InstantiationException {
        return classType.newInstance();
    }


}
