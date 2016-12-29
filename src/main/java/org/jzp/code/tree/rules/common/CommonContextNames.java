package org.jzp.code.tree.rules.common;

import org.jzp.code.tree.rules.context.Context;
import org.jzp.code.tree.rules.context.Context.Name;

/**
 * 公共上下文Name相关帮助类（举例）
 * <p>定义中带'IN'的表示在引擎执行过程中，外部传入上下文的数据
 * <p>定义中带'OUT'的表示在引擎执行过程中，引擎内部产生，并带到外部的数据
 *
 * @author jiazhipeng
 * @version 1.0
 * @date 2016-11-14
 */
public class CommonContextNames {

    /**
     * 执行结果标识的上下文Name(out)
     */
    public static final Name<Boolean> NAME_OUT_SUCCESS_FLAG = Name.create("out_success_flag");

    /**
     * 错误码的上下文Name(out)
     */
    public static final Name<Integer> NAME_OUT_ERR_CODE = Name.create("out_err_code");

    /**
     * 错误信息的上下文Name(out)
     */
    public static final Name<String> NAME_OUT_ERR_MESSAGE = Name.create("out_err_msg");

    /**
     * ToolCode在上下文中的Name(in)
     */
    public static final Name<String> NAME_IN_TOOL_CODE = Name.create("in_tool_code");

    /**
     * 工具参数上下文在上下文中的Name(in)
     */
    public static final Name<Context> NAME_IN_TOOL_PARAM_CONTEXT = Name.create("in_tool_param_context");

    /**
     * 资源ID在上下文中的Name(in)
     */
    public static final Name<String> NAME_IN_RESOURCE_ID = Name.create("in_resource_id");

    /**
     * 测试上下文的Name(in)
     */
    public static final Name<String> NAME_IN_TEST = Name.create("in_test");

    /**
     * 测试上下文的Name(out)
     */
    public static final Name<String> NAME_OUT_TEST = Name.create("in_out");

    private CommonContextNames() {
    }
}
