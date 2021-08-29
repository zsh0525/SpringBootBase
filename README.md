# _**# SpringBoot后台结构说明**_<br>

# **项目环境说明** <br>
* JDK8+ <BR>
* SpringBoot 2.5.4 <br>
* Maven 3.6.5 <br>
* junit 4.13.2<br>
* swagger2 2.9.2（使用人最多） 和 swagger3 3.0.0<br>
   - 两者区别：
       - 依赖不同，swagger3 只需配置一项依赖
       - 启动不同，新版本使用@EnableOpenApi，老版本使用@EnableSwagger2
       - Docket文档摘要信息不同配置文件，新版本OAS_3，老版本SWAGGER_2
       - 默认访问地址不一样：swagger2:/swagger-ui.html swagger3: /swagger-ui/index.html
       - 注：可能会存在部分依赖冲突。具体介意升级前看下版本信息。
           - Web模块下用的是swagger3,可同时集成swagger2,含Swagger2和3的启动程序。 <font color=red>**具体细节看代码注释**
* swagger-bootstrap-ui 1.8.4(com.github.xiaoymin)
   - 注：觉得默认UI不好看的，可自行在github选择合适的UI。个人觉得这个UI好看些。

# **项目结构说明** 
* root：主模块，用于集成环境，便于其他模块使用<br>
    * common-base:用于编写可公用的模块如：<br>
        - tool: 工具类
        - result: 返回格式封装.格式为json格式。<br>
         {
          ”code“:Int,<br>
          "msg":String,<br>
          payload:对象
          }
    * web: 服务模块（接口）编写，MVC结构。目前为测试说明<br>
        - controller：控制层
        - dao: 数据库层
        - service: 业务处理层
        - entity: pojo
        - config: 配置层
            - swagger： swagger2和swagger3配置文件
        - aop: 切面层
