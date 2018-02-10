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

    @RequestMapping("/hello")
    public String sayHello() {
        return "Hello SprintBoot";
    }

    @RequestMapping("/sayHello")
    public String index(String name) {
        return "Hello " + name;
    }

}
