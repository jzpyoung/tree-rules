package org.jzp.code.tree.rules.element.support;

import org.jzp.code.tree.rules.context.Context;
import org.jzp.code.tree.rules.element.Action;

/**
 * 打印信息的Action，用于调试
 *
 * @author jiazhipeng
 * @version 1.0
 * @date 2016-11-08
 */
public class PrintAction implements Action {

    private String info;

    public PrintAction(String info) {
        super();
        this.info = info;
    }

    @Override
    public void action(Context context) {
        System.out.println(info);
    }
}
