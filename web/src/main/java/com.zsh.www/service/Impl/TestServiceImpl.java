package com.zsh.www.service.Impl;

import com.zsh.www.entity.TestEntity;
import com.zsh.www.service.TestService;
import org.springframework.stereotype.Service;


@Service
public class TestServiceImpl implements TestService {

    @Override
    public TestEntity getTestEntity() {
        TestEntity testEntity = new TestEntity();
        testEntity.setServiceName("hellWorld");
        testEntity.setServiceVersion("0.0.1");
        return testEntity;
    }
}
