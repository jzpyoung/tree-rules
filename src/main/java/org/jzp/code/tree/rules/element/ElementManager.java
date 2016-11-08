package org.jzp.code.tree.rules.element;

/**
 * 元素管理器
 * <p>脚本引擎中的最基本单元
 *
 * @author jiazhipeng
 * @version 1.0
 * @date 2016-11-08
 * @see Element
 */
public interface ElementManager {

    /**
     * 通过metaId获取元素实例。
     *
     * @param metaId 元数据ID。
     * @return 对应的元素实例。
     */
    Element getElement(String metaId);
}
