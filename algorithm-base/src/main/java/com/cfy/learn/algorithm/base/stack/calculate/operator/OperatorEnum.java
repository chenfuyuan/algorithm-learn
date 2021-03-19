package com.cfy.learn.algorithm.base.stack.calculate.operator;

/**
 * @Description: 操作符
 * @Author chenfuyuan
 * @Date 2021/3/19 16:05
 */
public enum OperatorEnum {

    /**
     * 加
     */
    ADDITION("+", "加", new Addition()),
    /**
     * 减
     */
    SUBSTRUCTION("-", "减", new Substruction()),
    /**
     * 乘
     */
    Multiplication("*", "乘", new Multiplication()),
    /**
     * 除
     */
    Division("/", "除", new Division());


    /**
     * 符号
     */
    private String sign;


    /**
     * 名称
     */
    private String name;

    /**
     * 对象
     */
    private Operator operator;

    /**
     * 构造函数
     * @param sign 符号
     * @param name 名称
     * @param operator 实例
     */
    OperatorEnum(String sign, String name, Operator operator) {
        this.sign = sign;
        this.name = name;
        this.operator = operator;
    }

    /**
     * 判断是否为操作符
     * @param sign
     * @return
     */
    public static boolean isOperator(String sign) {
        return match(sign)!=null;
    }

    /**
     * 获取操作符对象
     * @return 操作符对象
     */
    public Operator getOperator() {
        return this.operator;
    }

    /**
     * 通过操作符获取对应的操作符对象
     * @param sign 操作符
     * @return 操作符对象
     */
    public static Operator getOperator(String sign) {
        OperatorEnum operatorEnum = match(sign);
        return operatorEnum != null ? operatorEnum.operator : null;
    }

    /**
     * 通过操作符 匹配操作符枚举值
     * @param sign 操作符
     * @return 枚举值
     */
    public static OperatorEnum match(String sign) {
        OperatorEnum[] list = OperatorEnum.values();
        for (OperatorEnum item : list) {
            if (item.sign.equals(sign)) {
                return item;
            }
        }
        return null;
    }


}
