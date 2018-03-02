package com.fantasykai.springboot.springbootlearn;

import com.fantasykai.springboot.springbootlearn.common.ConsProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * <p>
 *
 * @author Created by makai on 2018/03/02 .
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesTest {

    @Resource
    private ConsProperties properties;


    @Test
    public void testProperties() throws Exception {
        System.out.println("name_not_null: " + properties.getName_not_null());
    }


}
