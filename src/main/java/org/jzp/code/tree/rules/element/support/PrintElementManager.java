package org.jzp.code.tree.rules.element.support;

import org.jzp.code.tree.rules.element.Element;
import org.jzp.code.tree.rules.element.ElementManager;

/**
 * 用于调试
 * <p>对应的metaId模式为:[print:xxx]
 *
 * @author jiazhipeng
 * @version 1.0
 * @date 2016-11-08
 * @see PrintAction
 */
public class PrintElementManager implements ElementManager {

    @Override
    public Element getElement(String metaId) {
        return new PrintAction(metaId);
    }
}
