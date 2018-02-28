package com.fantasykai.springboot.springbootlearn.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * <p>
 *
 * @author Created by makai on 2018/02/10 .
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
@RestController
public class HelloSpringBootController {

    /**
     * 返回固定字符串
     *
     * @return
     */
    @RequestMapping("/hello")
    public String sayHello() {
        return "Hello SprintBoot";
    }

    /**
     * 传递参数
     * /sayHello?name=java
     *
     * @param name
     * @return
     */
    @RequestMapping("/sayHello")
    public String index(String name) {
        return "Hi, " + name + ", this is spring boot Test";
    }

}
