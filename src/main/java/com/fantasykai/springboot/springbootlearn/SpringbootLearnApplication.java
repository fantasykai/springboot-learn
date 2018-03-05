package com.fantasykai.springboot.springbootlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringbootLearnApplication extends SpringBootServletInitializer {

    // 有启动类需要添加 Servlet 的支持：
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringbootLearnApplication.class);
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringbootLearnApplication.class, args);
    }
}


