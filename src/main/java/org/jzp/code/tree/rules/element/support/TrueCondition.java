package org.jzp.code.tree.rules.element.support;

import org.jzp.code.tree.rules.context.Context;
import org.jzp.code.tree.rules.element.Condition;

/**
 * 永远为true的条件
 *
 * @author jiazhipeng
 * @version 1.0
 * @date 2016-11-08
 */
public class TrueCondition implements Condition {

    @Override
    public boolean getResult(Context context) {
        return true;
    }
}
