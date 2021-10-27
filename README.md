# _**# SpringBoot（多模块单应用）说明**_<br>
 该示例项目集成了最基本的Web开发架构技术，里面含控制层丶服务层丶切面示例丶拦截器示例丶测试用例（如何测接口丶如何测服务）、支持生成环境的日志配置丶swagger配置丶一系列常见的工具类 <br><font color=red> **仅供学习和参考**

# **项目环境说明** <br>
* JDK8+ <BR>
* SpringBoot 2.5.4 <br>
* Maven 3.6.5 <br>
* junit 4.13.2 <br>
* aop 2.5.4 <br>
* lombok 1.18.2 <br>
* swagger2 2.9.2（使用人最多） 和 swagger3 3.0.0<br>
   - 两者区别：
       - 依赖不同，swagger3 只需配置一项依赖
       - 启动不同，新版本使用@EnableOpenApi，老版本使用@EnableSwagger2
       - Docket文档摘要信息不同配置文件，新版本OAS_3，老版本SWAGGER_2
       - 默认访问地址不一样：swagger2:/swagger-ui.html swagger3: /sagger-ui/index.html
       - 注：可能会存在部分依赖冲突。具体介意升级前看下版本信息。
           - Web模块下用的是swagger3,可同时集成swagger2,含Swagger2和3的启动程序。 <font color=red>**具体细节看代码注释**
* swagger-bootstrap-ui 1.8.4(com.github.xiaoymin)
   - 注：觉得默认UI不好看的，可自行在github选择合适的UI。个人觉得这个UI好看些。
   默认访问地址：/doc.html

 
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
            - WebLogAspect: 日志切面，用于打印请求信息.具体见注释
        
# **项目资源说明** 
* web/resources
    - log-config:
        - logback-spring.xml，logback一些高级设置对XML的支持>yml或properties，详细见注释。
            - 解释：
                - springBoot Web应用自带日志组件，默认为Logback，原因：spring-boot-starter-web已经依赖了spring-boot-starter-logging，非Web包应用则需要引入该jar包。
                - 默认读取logback-spring.xml, logback-spring.groovy 2种文件（约定大于配置），也可指定配置文件。
        - log4j2.yml 支持log4j2日志，支持yml丶properties丶xml格式，需引入spring-boot-starter-log4j依赖，若是web应用则需要去掉spring-boot-starter-logging
        - <font color=red /> 注1：该模块下使用默认支持的（没找到集成两种的方式，包会存在冲突，后续会在其他模块中使用）
        - <font color=red /> 注2：看个人喜好吧，两者都有优势，log4j2可在运行时指定，网上说法不一，保持中立 
    - application.yml 主入口 
        - application-dev.yml 开发环境用到的相关配置信息
        - application-prod.yml 正式环境用到的相关配置信息
        - application-test.yml 测试环境用到的相关配置信息