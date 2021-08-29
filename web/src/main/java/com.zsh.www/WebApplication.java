package com.zsh.www;

import com.zsh.www.config.swagger.Swagger3Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
/**
 * 注：申明以Swagger2启动,排除Swagger3
 * */
@ComponentScan(value = "com.zsh.www.*", excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {Swagger3Config.class}))
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}
