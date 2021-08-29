package com.zsh.www.controller;

import com.zsh.www.result.ResponseResult;
import com.zsh.www.result.ResultCodeEnum;
import com.zsh.www.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
@CrossOrigin
@Api(value = "测试控制接口", tags = "hellWorld", description = "整体模型控制类描述")
public class TestController {

    @Autowired
    TestService testService;

    /**
     * produces：可用于申明返回格式，目前申明json的格式及编码
     */
    @GetMapping(value = "/hellWorld", produces = "application/json;charset=utf-8")
    public ResponseResult hellWorld() {
        return new ResponseResult(ResultCodeEnum.SUCCESS, testService.getTestEntity());
    }
}
