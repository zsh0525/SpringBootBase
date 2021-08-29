package com.zsh.www.config.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger3配置
 * 由于不介意网上@Configuration与@Value连用，可能会有问题。原因：感兴趣的可以看下类SpringBoot的加载机制
 * 所以：这里采用配置类用@Commonpent+@Value读取配置的属性，放入Spring容器中
 * 在改类中注入。
 */
@Configuration
@EnableOpenApi
// 申明当前配置在为true的情况生效。
@ConditionalOnProperty(prefix = "swagger", name = "enable", havingValue = "true")
public class Swagger3Config {

    @Autowired
    SwaggerYmlConfig swaggerYmlConfig;

    /**
     * 文档摘要信息
     * 重要属性说明：
     * DocumentationType.OAS_30:swagger3标识
     * pathMapping:路径。请求服务URL,一般为/
     * apis:需申明服务Controller所在包
     */
    @Bean
    public Docket createResultApi() {
        return new Docket(DocumentationType.OAS_30).
                apiInfo(apiInfo()).
                pathMapping(swaggerYmlConfig.getPath()).
                select().
                apis(RequestHandlerSelectors.basePackage(swaggerYmlConfig.getBasePackage())).
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
        String[] contact = swaggerYmlConfig.getContact3();
        return new ApiInfoBuilder().title(swaggerYmlConfig.getTitle()).
                description(swaggerYmlConfig.getDescription()).
                contact(new Contact(contact[0], contact[1], contact[2])).
                version(swaggerYmlConfig.getVersion()).
                build();
    }
}
