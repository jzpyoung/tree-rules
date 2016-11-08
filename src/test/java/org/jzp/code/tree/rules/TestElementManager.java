package org.jzp.code.tree.rules;

import org.jzp.code.tree.rules.element.Element;
import org.jzp.code.tree.rules.element.ElementManager;

/**
 * 元素管理器测试类
 *
 * @author jiazhipeng
 * @version 1.0
 * @date 2016-11-08
 */
public class TestElementManager implements ElementManager {

	@Override
	public Element getElement(String metaId) {
		if("1".equals(metaId)){
			return new Action1();
		}else if("2".equals(metaId)){
			return new Action2();
		}else{
			throw new RuntimeException("unknown metaId : " + metaId);
		}
	}
}
