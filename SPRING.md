# Spring接入文档
+ 依赖注入：

    ```Java
    /**
     * 脚本解析器
     */
    @Resource
    private ScriptParser scriptParser;
    
    /**
     * 引擎执行器
     */
    @Resource
    private ProcessExecutor processExecutor;
    ```