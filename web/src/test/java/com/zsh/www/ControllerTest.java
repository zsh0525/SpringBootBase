package com.zsh.www;

import com.zsh.www.controller.TestController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration

public class ControllerTest {

    @Autowired
    TestController testController;

    private MockMvc mvc;

    @Before
    public void newMvc() {
        mvc = MockMvcBuilders.standaloneSetup(testController).build();
    }


    @Test
    public void testController() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/test/hellWorld").characterEncoding("utf8"))
                .andExpect(MockMvcResultMatchers.status().isOk()) // 拦截状态
//              .andDo(MockMvcResultHandlers.print()) // 打印相关信息
                .andReturn(); // 返回对象
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
}
