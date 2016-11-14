# tree-rules API文档

+ 解析script表达式:
	
	```Java
	Map<String, List<Element>> process = scriptParser.parse(script);
	```
	
+ 获取指定流程：

    ```Java
    List<Element> elementList = process.get(BusinessPhaseKeys.KEY_DEAL.getValue());
    ```
    
+ 构造上下文：

    ```Java
    Context context = new Context();
    context.put(CommonContextNames.NAME_IN_TEST, "test");
    ```
    
+ 执行流程：

    ```Java
    processExecutor.execute(elementList, context);
    ```
    
+ 返回结果：

    ```Java
    String promotion = context.get(CommonContextNames.NAME_OUT_TEST);
    ```