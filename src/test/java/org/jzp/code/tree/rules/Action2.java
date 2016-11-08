package org.jzp.code.tree.rules;

import org.jzp.code.tree.rules.context.Context;
import org.jzp.code.tree.rules.element.Action;

/**
 * 测试动作2
 *
 * @author jiazhipeng
 * @version 1.0
 * @date 2016-11-08
 */
public class Action2 implements Action {

	@Override
	public void action(Context context) {
		System.out.println(2);
	}
}
