package org.jzp.code.tree.rules.element.support;

import org.jzp.code.tree.rules.element.Element;
import org.jzp.code.tree.rules.element.ElementManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 系统元素管理器
 * <p>负责管理一些逻辑固定的系统级元素
 * <p>对应的metaId模式为:[sys:xxx]
 *
 * @author jiazhipeng
 * @version 1.0
 * @date 2016-11-08
 */
public class SystemElementManager implements ElementManager {

    private static final Logger logger = LoggerFactory.getLogger(SystemElementManager.class);

    @Override
    public Element getElement(String metaId) {
        if ("true".equals(metaId)) {
            return new TrueCondition();
        } else if ("false".equals(metaId)) {
            return new FalseCondition();
        } else {
            logger.error("找不到meta标识为[{}]的Element!", metaId);
            throw new RuntimeException("找不到Element!");
        }
    }
}
