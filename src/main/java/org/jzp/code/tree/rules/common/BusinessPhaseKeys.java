package org.jzp.code.tree.rules.common;

/**
 * 业务阶段Key帮助类（举例）
 *
 * @author jiazhipeng
 * @version 1.0
 * @date 2016-11-14
 */
public enum BusinessPhaseKeys {

    /**
     * 前置处理阶段的key
     */
    KEY_BEFORE("before"),

    /**
     * 处理阶段的key
     */
    KEY_DEAL("deal"),

    /**
     * 后置处理阶段的key
     */
    KEY_AFTER("after");

    private String key;

    BusinessPhaseKeys(String key){
        this.key = key;
    }

    public String getKey(){
        return this.key;
    }
}
