package org.jzp.code.tree.rules.executor;

import org.jzp.code.tree.rules.context.Context;
import org.jzp.code.tree.rules.element.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 默认的过程执行器实现
 *
 * @author jiazhipeng
 * @version 1.0
 * @date 2016-11-08
 */
public class DefaultProcessExecutor implements ProcessExecutor {

    private static final Logger logger = LoggerFactory.getLogger(DefaultProcessExecutor.class);

    @Override
    public void execute(List<Element> elementList, Context context) {

        int size = elementList.size();

		/*
         * 上一个条件的结果
		 */
        boolean preConditionResult = true;

		/*
         * 上一个操作符
		 */
        Operator preOp = Operator.AND;

        for (int i = 0; i < size; i++) {
            Element element = elementList.get(i);
            if (element instanceof Condition) {
                if (preOp == Operator.AND) {
                    if (!preConditionResult) {
                        return;
                    } else {
                        Condition condition = (Condition) element;
                        //算出当前条件结果
                        if (logger.isDebugEnabled()) {
                            logger.debug("开始执行Condition-{}", condition.getClass().getName());
                        }
                        preConditionResult = condition.getResult(context);
                    }
                } else if (preOp == Operator.OR) {
                    Condition condition = (Condition) element;
                    //算出当前条件结果
                    if (logger.isDebugEnabled()) {
                        logger.debug("开始执行Condition-{}", condition.getClass().getName());
                    }
                    if (!preConditionResult && !(preConditionResult = condition.getResult(context))) {
                        return;
                    }
                } else if (preOp == Operator.WHEN) {
                    Condition condition = (Condition) element;
                    //算出当前条件结果
                    if (logger.isDebugEnabled()) {
                        logger.debug("开始执行Condition-{}", condition.getClass().getName());
                    }
                    preConditionResult = condition.getResult(context);
                } else {
                    throw new RuntimeException("Unsupported Op : " + preOp);
                }

            } else if (element instanceof Action) {
                Action action = (Action) element;
                /*
                 * 无条件执行Action
				 * 如果Action前的条件不成立，会在WHEN元素退出
				 */
                if (logger.isDebugEnabled()) {
                    logger.debug("开始执行Action-{}", action.getClass().getName());
                }
                action.action(context);
            } else if (element instanceof OperatorElement) {
                OperatorElement operatorElement = (OperatorElement) element;
                Operator op = operatorElement.getOperator();
                if (logger.isDebugEnabled()) {
                    logger.debug("处理运算符-{}", op);
                }
                if (Operator.AND.equals(op)) {
                    //之前的条件不成立，退出
                    if (!preConditionResult) {
                        return;
                    }
                    preOp = Operator.AND;
                } else if (Operator.OR.equals(op)) {
                    //下个Condition无条件执行
                    preOp = Operator.OR;
                } else if (Operator.WHEN.equals(op)) {
                    if (!preConditionResult) {
						/*
						 * 如果之前的条件不成立，退出
						 */
                        return;
                    }
                    preOp = Operator.WHEN;
                } else {
                    throw new RuntimeException("Unsupported Op : " + preOp);
                }
            } else {
                throw new RuntimeException("Unsupported Element : " + element.getClass().getName());
            }
        }
    }
}
