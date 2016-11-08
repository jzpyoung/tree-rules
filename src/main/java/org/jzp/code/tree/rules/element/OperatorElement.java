package org.jzp.code.tree.rules.element;

/**
 * 运算元素
 * <p>包括AND、OR和WHEN
 *
 * @author jiazhipeng
 * @version 1.0
 * @date 2016-11-08
 */
public class OperatorElement implements Element {

    /**
     * 与运算元素
     */
    public static final OperatorElement AND = new OperatorElement(Operator.AND);

    /**
     * 或运算元素
     */
    public static final OperatorElement OR = new OperatorElement(Operator.OR);

    /**
     * when运算元素
     */
    public static final OperatorElement WHEN = new OperatorElement(Operator.WHEN);

    /**
     * 运算符
     */
    private Operator operator;

    public Operator getOperator() {
        return operator;
    }

    private OperatorElement(Operator operator) {
        this.operator = operator;
    }
}
