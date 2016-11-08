package org.jzp.code.tree.rules.element.support;

import org.jzp.code.tree.rules.element.Element;
import org.jzp.code.tree.rules.element.ElementManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 基于Spring的元素管理器
 * <p>内部会从Spring上下文中寻找元素，元素的meta标识为元素在Spring上下文中的beanId
 * <p>对应的metaId模式为:[spring:xxx]
 *
 * @author jiazhipeng
 * @version 1.0
 * @date 2016-11-08
 */
public class SpringElementManager implements ElementManager, ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(SpringElementManager.class);

    /**
     * Spring上下文。
     */
    private ApplicationContext context;

    @Override
    public Element getElement(String metaId) {
        Element element = context.getBean(metaId, Element.class);
        if (element == null) {
            logger.error("spring上下文中不包含ID=[{}]的Bean元素!", metaId);
            throw new RuntimeException("从spring上下文中获取元素失败!");
        }
        return element;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
