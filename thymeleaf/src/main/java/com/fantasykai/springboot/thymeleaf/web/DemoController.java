package com.fantasykai.springboot.thymeleaf.web;

import com.fantasykai.springboot.thymeleaf.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * <p>
 *
 * @author Created by makai on 2018/03/12 .
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
@Controller
public class DemoController {

    @RequestMapping("/demo")
    public String index(ModelMap map) {

        map.addAttribute("userName", "kai");
        map.addAttribute("flag", "yes");
        map.addAttribute("users", getUserList());
        map.addAttribute("type", "link");
        map.addAttribute("pageId", "springboot-learn");
        map.addAttribute("img", "https://ws1.sinaimg.cn/large/7108d6c2ly1fpa2r0d18xj21z418gwqe.jpg");
        map.addAttribute("count", 12);
        map.addAttribute("date", new Date());
        return "demo";
    }

    public List<User> getUserList() {

        List<User> list = new ArrayList<User>();

        User user1 = new User("xiaohei", 1, 20);
        User user2 = new User("xiaohong", 0, 19);
        User user3 = new User("xiaoli", 0, 18);

        list.add(user1);
        list.add(user2);
        list.add(user3);

        return list;
    }


}
