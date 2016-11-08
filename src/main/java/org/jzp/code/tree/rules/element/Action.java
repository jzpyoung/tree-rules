package org.jzp.code.tree.rules.element;

import org.jzp.code.tree.rules.context.Context;

/**
 * 动作
 * <p>本身不能有状态，数据通过上下文来传递
 *
 * @author jiazhipeng
 * @version 1.0
 * @date 2016-11-08
 * @see Context
 */
public interface Action extends Element {

    /**
     * 执行动作。
     *
     * @param context 上下文。
     */
    void action(Context context);
}
