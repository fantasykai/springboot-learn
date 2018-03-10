package com.fantasykai.springboot.thymeleaf.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * <p>
 *
 * @author Created by makai on 2018/03/10 .
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String index(ModelMap map) {
        map.addAttribute("message", "Hello Thymeleaf");
        return "hello";
    }


}
