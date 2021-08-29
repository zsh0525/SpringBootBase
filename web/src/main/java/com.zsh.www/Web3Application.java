package com.zsh.www;

import com.zsh.www.config.swagger.Swagger2Config;
import com.zsh.www.config.swagger.Swagger3Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication

/**
 * 注：申明以Swagger3启动，排除Swagger2
 * */
@ComponentScan(value = "com.zsh.www.*", excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {Swagger2Config.class}))
public class Web3Application {
    public static void main(String[] args) {
        SpringApplication.run(Web3Application.class, args);
    }
}
