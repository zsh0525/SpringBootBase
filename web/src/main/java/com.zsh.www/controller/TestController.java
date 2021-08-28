package com.zsh.www.controller;

import com.zsh.www.result.ResponseResult;
import com.zsh.www.result.ResultCodeEnum;
import com.zsh.www.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping(value = "/hellWorld", produces = "application/json; charset=utf-8")
    public ResponseResult hellWorld() {
        return new ResponseResult(ResultCodeEnum.SUCCESS, testService.getTestEntity());
    }
}
