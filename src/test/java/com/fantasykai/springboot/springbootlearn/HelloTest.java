package com.fantasykai.springboot.springbootlearn;

import com.fantasykai.springboot.springbootlearn.web.HelloSpringBootController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * <p>
 *
 * @author Created by makai on 2018/02/28 .
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
@SpringBootTest
public class HelloTest {

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(new HelloSpringBootController()).build();
    }

    @Test
    public void getHello() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/sayHello?name=张三").accept(MediaType.APPLICATION_JSON_UTF8)).andDo(MockMvcResultHandlers.print());
    }

}
