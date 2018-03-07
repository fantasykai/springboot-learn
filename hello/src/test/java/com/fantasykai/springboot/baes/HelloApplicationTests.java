package com.fantasykai.springboot.baes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void hello() {
        System.out.println("Hello SpringBoot");
    }

}
