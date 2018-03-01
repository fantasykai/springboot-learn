package com.fantasykai.springboot.springbootlearn.web;

import com.fantasykai.springboot.springbootlearn.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * <p>
 *
 * @author Created by makai on 2018/03/01 .
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
@RestController
public class UserController {

    @RequestMapping("/getUser")
    public User getUser() {
        User user = new User();

        user.setName("小黑");
        user.setAge(20);
        user.setPass("123456");

        return user;
    }


}
