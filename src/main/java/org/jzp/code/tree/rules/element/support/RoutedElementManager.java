package org.jzp.code.tree.rules.element.support;

import com.google.common.base.Strings;
import org.jzp.code.tree.rules.element.Element;
import org.jzp.code.tree.rules.element.ElementManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 元素管理器路由，负责根据特定metaId路由到相应的元素管理器
 *
 * @author jiazhipeng
 * @version 1.0
 * @date 2016-11-08
 */
public class RoutedElementManager implements ElementManager {

    private static final Logger logger = LoggerFactory.getLogger(RoutedElementManager.class);

    /**
     * 管理器映射
     */
    private Map<String, ElementManager> managerMap;

    //默认的管理器key
    private static final String DEFAULT_MANAGER_KEY = ElementManagerKeys.KEY_SYSTEM;

    @Override
    public Element getElement(String metaId) {
        try {
            if (Strings.isNullOrEmpty(metaId)) {
                logger.error("metaId不能为空!");
                throw new RuntimeException("metaId不能为空!");
            }
            /*
             * 解析metaId
			 * 如：
			 * sys:true
			 * spring:xxx
			 * db:1234
			 * ...
			 */
            String[] array = metaId.split(":");
            String managerKey = null;
            String metaKey = null;
            if (array.length == 2) {
                //获取metaId中的管理器标志
                managerKey = array[0];
                metaKey = array[1];
            }
            //默认走系统定义
            if (Strings.isNullOrEmpty(managerKey)) {
                managerKey = DEFAULT_MANAGER_KEY;
                metaKey = metaId;
            }
            //通过标志获取管理器实例
            ElementManager manager = managerMap.get(managerKey);
            if (manager == null) {
                logger.error("找不到标志为[{}]的ElementManager实例!", managerKey);
                throw new RuntimeException("找不到ElementManager实例!");
            }
            return manager.getElement(metaKey);
        } catch (Exception e) {
            logger.error("获取metaId=[" + metaId + "]的元素失败!", e);
            throw new RuntimeException("获取元素失败!", e);
        }
    }

    public void setManagerMap(Map<String, ElementManager> managerMap) {
        this.managerMap = managerMap;
    }
}
