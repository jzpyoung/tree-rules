package org.jzp.code.tree.rules.element;

import org.jzp.code.tree.rules.context.Context;

/**
 * 条件
 * <p>本身不能有状态，数据通过上下文来传递
 *
 * @author jiazhipeng
 * @version 1.0
 * @date 2016-11-08
 * @see Context
 */
public interface Condition extends Element {

    /**
     * 计算条件，返回结果。
     *
     * @param context 上下文。
     * @return 如果满足条件，返回true；否则返回false。
     */
    boolean getResult(Context context);
}
