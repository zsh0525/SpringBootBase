# _**# SpringBoot后台结构说明**_<br>

# **项目环境说明** <br>
* JDK8+ <BR>
* SpringBoot 2.5.4 <br>
* Maven 3.6.5 <br>
* junit 4.13.2<br>

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
        - config: 配置层，如需自定义加载数据库丶跨域配置丶事务配置丶Swagger配置
        - aop: 切面层
