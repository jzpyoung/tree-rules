package org.jzp.code.tree.rules.parser;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.jzp.code.tree.rules.element.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 脚本解析器
 * <p>用于解析规则工具脚本
 *
 * @author jiazhipeng
 * @version 1.0
 * @date 2016-11-08
 * @see Element
 */
public class ScriptParser {

    private static final Logger logger = LoggerFactory.getLogger(ScriptParser.class);

    /**
     * 元素管理器
     */
    private ElementManager elementManager;

    /**
     * 解析脚本
     *
     * @param script 规则工具中的脚本
     * @return 阶段标识与对应元素列表的映射
     */
    public Map<String, List<Element>> parse(String script) {
        try {
            JsonParser jsonParser = new JsonParser();
            //解析Json格式的脚本。
            JsonElement jsonElement = jsonParser.parse(script);
            //转成Json数组，里面的元素表示phase信息。
            JsonArray phaseJsonArray = jsonElement.getAsJsonArray();
            //根据phaseIndex选择phase元素。
            int phaseSize = phaseJsonArray.size();
            if (phaseSize <= 0) {
                logger.error("脚本中不包含任何phase!");
                throw new RuntimeException("脚本中不包含任何phase!");
            }

            Map<String, List<Element>> processMap = Maps.newHashMap();
            for (int i = 0; i < phaseSize; i++) {
                JsonElement phaseJsonElement = phaseJsonArray.get(i);
                JsonObject phaseJsonObject = phaseJsonElement.getAsJsonObject();
                String phaseKey = phaseJsonObject.get("key").getAsString();
                //获取元素树对象
                JsonObject elementRootJsonObject = phaseJsonObject.get("root").getAsJsonObject();
                //从树中解析元素列表
                ArrayList<Element> elements = Lists.newArrayList();
                /*
                 * 中序遍历树，然后通过节点信息来加载Element
				 * 目的就是把树展开，形成一个Element列表
				 */
                traverse(elementRootJsonObject, elements);
                //减少列表中的空位
                elements.trimToSize();
                //返回不可变的列表
                processMap.put(phaseKey, Collections.unmodifiableList(elements));
            }
            return processMap;
        } catch (Exception e) {
            logger.error("解析脚本失败,script={}", script);
            throw new RuntimeException("解析脚本失败!", e);
        }
    }

    /**
     * 中序遍历元素树
     *
     * @param node     树节点
     * @param elements 元素列表
     */
    private void traverse(JsonObject node, ArrayList<Element> elements) {
        int type = node.get("type").getAsInt();
        //如果是叶子节点，解析元素
        if (type == 1) {
            JsonObject elementJsonObject = node.get("element").getAsJsonObject();
            String elementType = elementJsonObject.get("type").getAsString();
            //获取metaId
            String metaId = elementJsonObject.get("metaId").getAsString();
            Element element = elementManager.getElement(metaId);
            //类型检测
            if (ElementTypes.TYPE_ACTION.equals(elementType)) {
                if (!(element instanceof Action)) {
                    logger.error("MetaId为[{}]的元素类型应该为Action,实际类型为[{}]。", metaId, element.getClass().getName());
                    throw new RuntimeException("元素类型不匹配!");
                }
            } else if (ElementTypes.TYPE_CONDITION.equals(elementType)) {
                if (!(element instanceof Condition)) {
                    logger.error("MetaId为[{}]的元素类型应该为Condition,实际类型为[{}]。", metaId, element.getClass().getName());
                    throw new RuntimeException("元素类型不匹配!");
                }
            } else {
                logger.error("未知的元素类型:[{}]", elementType);
                throw new RuntimeException("元素类型未定义!");
            }
            elements.add(element);
        }
        //非叶子节点
        else if (type == 0) {
            //获取左子节点
            JsonElement leftJsonElement = node.get("left");
            if (leftJsonElement != null) {
                JsonObject leftJsonObject = leftJsonElement.getAsJsonObject();
                traverse(leftJsonObject, elements);
            }

            //处理运算信息
            JsonObject elementJsonObject = node.get("element").getAsJsonObject();
            String op = elementJsonObject.get("op").getAsString();
            Operator operator = Operator.valueOf(op);
            if (Operator.AND.equals(operator)) {
                elements.add(OperatorElement.AND);
            } else if (Operator.OR.equals(operator)) {
                elements.add(OperatorElement.OR);
            } else if (Operator.WHEN.equals(operator)) {
                elements.add(OperatorElement.WHEN);
            } else {
                throw new RuntimeException(operator + "not support!");
            }
            //获取右子节点
            JsonElement rightJsonElement = node.get("right");
            if (rightJsonElement != null) {
                JsonObject rightJsonObject = rightJsonElement.getAsJsonObject();
                traverse(rightJsonObject, elements);
            }
        } else {
            logger.error("未知的Node类型:[{}]", type);
            throw new RuntimeException("Node类型未定义!");
        }
    }

    public void setElementManager(ElementManager elementManager) {
        this.elementManager = elementManager;
    }
}
