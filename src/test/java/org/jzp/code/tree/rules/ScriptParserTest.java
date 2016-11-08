package org.jzp.code.tree.rules;

import org.jzp.code.tree.rules.element.Element;
import org.jzp.code.tree.rules.element.ElementManager;
import org.jzp.code.tree.rules.element.support.ElementManagerKeys;
import org.jzp.code.tree.rules.element.support.PrintElementManager;
import org.jzp.code.tree.rules.element.support.RoutedElementManager;
import org.jzp.code.tree.rules.element.support.SystemElementManager;
import org.jzp.code.tree.rules.executor.DefaultProcessExecutor;
import org.jzp.code.tree.rules.parser.ScriptParser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 脚本解析器测试类
 *
 * @author jiazhipeng
 * @version 1.0
 * @date 2016-11-08
 */
public class ScriptParserTest {

    public static void main(String[] args) {
        RoutedElementManager rem = new RoutedElementManager();

        Map<String, ElementManager> hash = new HashMap<String, ElementManager>();
        hash.put("test", new TestElementManager());
        hash.put(ElementManagerKeys.KEY_SYSTEM, new SystemElementManager());
        hash.put(ElementManagerKeys.KEY_PRINT, new PrintElementManager());
        rem.setManagerMap(hash);
        String json = "[{\"key\":\"1\",\"root\":{\"type\":0,\"element\":{\"op\":\"WHEN\"},\"left\":{\"type\":0,\"element\":{\"op\":\"AND\"},\"left\":{\"type\":0,\"element\":{\"op\":\"OR\"},\"left\":{\"type\":1,\"element\":{\"type\":\"condition\",\"metaId\":\"sys:true\"}},\"right\":{\"type\":1,\"element\":{\"type\":\"condition\",\"metaId\":\"sys:false\"}}},\"right\":{\"type\":1,\"element\":{\"type\":\"condition\",\"metaId\":\"sys:true\"}}},\"right\":{\"type\":1,\"element\":{\"type\":\"action\",\"metaId\":\"print:hahahahahahahahaha\"}}}}]";
        //String json = "[{\"key\":\"1\",\"root\":{\"type\":0,\"element\":{\"op\":\"WHEN\"},\"left\":{\"type\":1,\"element\":{\"type\":\"condition\",\"metaId\":\"sys:true\"}},\"right\":{\"type\":1,\"element\":{\"type\":\"action\",\"metaId\":\"print:fuck!\"}}}},{\"key\":\"2\",\"root\":{\"type\":0,\"element\":{\"op\":\"WHEN\"},\"left\":{\"type\":1,\"element\":{\"type\":\"condition\",\"metaId\":\"12345\"}},\"right\":{\"type\":1,\"element\":{\"type\":\"action\",\"metaId\":\"123456\"}}}},{\"key\":\"3\",\"root\":{\"type\":0,\"element\":{\"op\":\"WHEN\"},\"left\":{\"type\":1,\"element\":{\"type\":\"condition\",\"metaId\":\"12345\"}},\"right\":{\"type\":1,\"element\":{\"type\":\"action\",\"metaId\":\"123456\"}}}}]";
        ScriptParser parser = new ScriptParser();
        parser.setElementManager(rem);
        Map<String, List<Element>> processMap = parser.parse(json);
        System.out.println(processMap);
        List<Element> elements = processMap.get("1");
        DefaultProcessExecutor executor = new DefaultProcessExecutor();
        executor.execute(elements, null);
    }
}
