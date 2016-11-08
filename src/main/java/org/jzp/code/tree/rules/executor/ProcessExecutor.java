package org.jzp.code.tree.rules.executor;

import org.jzp.code.tree.rules.context.Context;
import org.jzp.code.tree.rules.element.Element;

import java.util.List;

/**
 * 过程执行器
 *
 * @author jiazhipeng
 * @version 1.0
 * @date 2016-11-08
 */
public interface ProcessExecutor {

    /**
     * 执行Element列表
     * <p>这里的Element列表由元数据Tree中序遍历而来
     *
     * @param elementList 元素列表
     * @param context     上下文
     */
    void execute(List<Element> elementList, Context context);
}
