package com.fantasykai.springboot.web.web;

import com.fantasykai.springboot.web.domian.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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


    /**
     * Gets user.
     *
     * @return the user
     */
    @RequestMapping(value = "/oneUser", method = RequestMethod.GET)
    public User getUser() {

        User user = new User();
        user.setName("小黑");
        user.setSex(1);
        user.setAge(18);

        return user;
    }

    /**
     * Gets users.
     *
     * @return the users
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUsers() {
        List<User> users = new ArrayList<User>();

        User user1 = new User();
        user1.setName("小黑");
        user1.setSex(1);
        user1.setAge(18);

        User user2 = new User();
        user2.setName("小红");
        user2.setSex(2);
        user2.setAge(19);

        User user3 = new User();
        user2.setName("小白");
        user2.setSex(1);
        user2.setAge(20);

        users.add(user1);
        users.add(user2);
        users.add(user3);

        return users;
    }

    /**
     * Gets user by name.
     *
     * @param name the name
     * @return the user by name
     */
    @RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
    public User getUserByName(@PathVariable String name) {
        User user = new User();
        user.setName(name);
        user.setAge(16);
        user.setSex(1);
        return user;
    }

}
