package com.fantasykai.springboot.web.web;

import com.fantasykai.springboot.web.domian.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * <p>
 *
 * @author Created by makai on 2018/03/07 .
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
@RestController
public class WebController {


    @RequestMapping(value = "/oneUser", method = RequestMethod.GET)
    public User getUser() {

        User user = new User();
        user.setName("小黑");
        user.setSex(1);
        user.setAge(18);

        return user;
    }


}
