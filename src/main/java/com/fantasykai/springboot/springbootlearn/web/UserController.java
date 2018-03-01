package com.fantasykai.springboot.springbootlearn.web;

import com.fantasykai.springboot.springbootlearn.domain.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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

    /**
     * Gets user.
     *
     * @return the user
     */
    @RequestMapping(value = "/oneUser", method = RequestMethod.GET)
    public User getUser() {
        User user = new User();

        user.setName("小黑");
        user.setAge(20);
        user.setSex(1);

        return user;
    }

    /**
     * Gets users.
     *
     * @return the users
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        User user0 = new User();
        user0.setName("小蓝");
        user0.setAge(18);
        user0.setSex(0);

        User user1 = new User();
        user1.setName("小兰");
        user1.setAge(19);
        user1.setSex(0);

        users.add(user0);
        users.add(user1);
        return users;
    }

    /**
     * Get user.
     *
     * @param name the name
     * @return the user
     */
    @RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
    public User get(@PathVariable String name) {
        User user = new User();
        user.setName(name);
        user.setAge(16);
        user.setSex(0);
        return user;
    }

    /**
     * Save user.
     *
     * @param user   the user
     * @param result the result
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public void saveUser(@Valid User user, BindingResult result) {
        System.out.println("user: " + user);
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                System.out.println(error.getCode() + "-" + error.getDefaultMessage());
            }
        }
    }
}
