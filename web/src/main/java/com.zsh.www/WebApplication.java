package com.zsh.www;

import com.zsh.www.config.swagger.Swagger3Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import java.util.ArrayList;

@SpringBootApplication
/**
 * 注：申明以Swagger2启动,排除Swagger3
 * */
@ComponentScan(value = "com.zsh.www.*", excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {Swagger3Config.class}))
public class WebApplication {
    private static Logger logger = LoggerFactory.getLogger(WebApplication.class);

    public WebApplication(){
        logger.info("构造方法执行了");
        logger.error("构造方法了，但就要让他报错");
        logger.warn("构造方法了，但就要让他报警告");
    }

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}
