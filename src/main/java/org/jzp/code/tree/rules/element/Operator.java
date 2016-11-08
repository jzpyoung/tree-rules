package org.jzp.code.tree.rules.element;

/**
 * 运算符
 * <p>脚本引擎中的最基本单元
 *
 * @author jiazhipeng
 * @version 1.0
 * @date 2016-11-08
 * @see Action
 * @see Condition
 */
public enum Operator implements Element {

    /**
     * 与运算
     */
    AND,

    /**
     * 或运算
     */
    OR,

    /**
     * when运算，连接Condition和Action
     * <p>当前面的Condition成立时才执行后面的Action
     */
    WHEN
}
