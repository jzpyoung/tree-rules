package org.jzp.code.tree.rules;

import org.jzp.code.tree.rules.element.Element;
import org.jzp.code.tree.rules.element.OperatorElement;
import org.jzp.code.tree.rules.element.support.FalseCondition;
import org.jzp.code.tree.rules.element.support.TrueCondition;
import org.jzp.code.tree.rules.executor.DefaultProcessExecutor;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理测试类
 *
 * @author jiazhipeng
 * @version 1.0
 * @date 2016-11-08
 */
public class ExecuteTest {

    public static void main(String[] args) {
        DefaultProcessExecutor executor = new DefaultProcessExecutor();
        List<Element> elements = new ArrayList<>();
        elements.add(new TrueCondition());
        elements.add(OperatorElement.OR);
        elements.add(new FalseCondition());
        elements.add(OperatorElement.AND);
        elements.add(new TrueCondition());
        elements.add(OperatorElement.WHEN);
        elements.add(new Action1());
        elements.add(new FalseCondition());
        elements.add(OperatorElement.OR);
        elements.add(new FalseCondition());
        elements.add(OperatorElement.WHEN);
        elements.add(new Action2());
        executor.execute(elements, null);
    }
}
