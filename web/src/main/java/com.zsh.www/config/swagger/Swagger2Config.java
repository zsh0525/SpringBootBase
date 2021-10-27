package com.zsh.www.config.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2配置
 */
@Configuration
@EnableSwagger2
// 申明当前配置在为true的情况生效。
@ConditionalOnProperty(prefix = "swagger", name = "enable", havingValue = "true")
/**
 * 读取配置文件中的swagger节点,
 * 使用@Configuration+@Value。
 * 由于只是读取自定义的配置文件，所以可用。否则需要采用Swagger3Config的方式
 */
public class Swagger2Config {

    @Value("${swagger.path}")
    private String path;
    @Value("${swagger.basePackage}")
    private String basePackage;
    @Value("${swagger.title}")
    private String title;
    @Value("${swagger.contact}")
    private String[] contact;
    @Value("${swagger.version}")
    private String version;
    @Value("${swagger.description}")
    private String description;

    /**
     * 文档摘要信息
     * 重要属性说明：
     * DocumentationType.SWAGGER_2:swagger2标识
     * pathMapping:路径。请求服务URL,一般为/
     * apis:需申明服务Controller所在包
     */
    @Bean
    public Docket createResultApi() {
        return new Docket(DocumentationType.SWAGGER_2).
                apiInfo(apiInfo()).
                pathMapping(path).
                select().
                apis(RequestHandlerSelectors.basePackage(basePackage)).
                paths(PathSelectors.any()).build();
    }

    /**
     * Swagger相关信息
     * 相关属性说明：
     * title:网页标题
     * description:描述
     * Contact:创始人相关信息
     * 1)name:姓名
     * 2)url：可理解为服务地址
     * 3)email：邮箱地址
     * version:自定义的版本号
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(title).
                description("SpringBootBaseTest").
                contact(new Contact(contact[0], contact[1], contact[2])).
                version(version).
                build();
    }

}
