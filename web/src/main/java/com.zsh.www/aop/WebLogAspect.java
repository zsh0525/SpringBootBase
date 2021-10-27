package com.zsh.www.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author zsh
 * @description 控制层日志切面
 * @date 2021.10.26
 */
@Aspect
@Component
class WebControllerLogAspect {

    private final Logger logger = LoggerFactory.getLogger(WebControllerLogAspect.class);

    private final ObjectMapper mapper;

    WebControllerLogAspect(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    // 切入面所在位置的描述

    /**
     * (public * com.zsh.www.controller..*.*(..))
     * 任意返回类型 com.zsh.www.controller.任意类.任意方法(任意参数)
     */
    @Pointcut("execution (public * com.zsh.www.controller..*.*(..))")
    public void aspectBase() {
    }

    // 前置通知：在切入面前操作
    @Before("aspectBase()")
    public void logBeforeController(JoinPoint joinPoint) {
        logger.info("*****Before测试*****");
        // 这个RequestContextHolder是Springmvc提供来获得请求的东西
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        // 记录下请求内容
        logger.info("ip : {},uri : {},method : {}",
                request.getRemoteAddr(),
                request.getRequestURI(),
                request.getMethod());
        logger.info("-args : " + Arrays.toString(joinPoint.getArgs()));
        logger.info("*****Before结束*****");
    }

    // 后置通知：在切入面之后操作
    @After("aspectBase()")
    public void logAfterController(JoinPoint joinPoint) throws IOException {
        // 注：无法在这打印参数。因为返回值已经返回了
        logger.info("--------------请求结束----------------");
    }

    // 环绕通知：@before和@After的结合体。
    @Around("aspectBase()")
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("*****Around测试*****");
        logger.info("class:{}", proceedingJoinPoint.getSignature().getDeclaringTypeName());
        logger.info("className:{}", proceedingJoinPoint.getSignature().getDeclaringType().getName());
        logger.info("args:{}", proceedingJoinPoint.getArgs());
        Object result = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
        logger.info("response:{}", mapper.writeValueAsString(result));
        logger.info("*****Around结束*****");
        return result;
    }

    // @After之前执行
    @AfterReturning(pointcut = "aspectBase()", returning = "response")
    public void logAfterReturn(Object response) throws JsonProcessingException {
        if (response != null) {
            logger.info("AfterReturning return:" + mapper.writeValueAsString(response));
        }
    }

    // 异常通知：操作发生异常时执行
    @AfterThrowing(pointcut = "aspectBase()", throwing = "ex")
    public void logAfterThrowing(Throwable ex) {
        logger.error(ex.getStackTrace().toString());
    }


}
