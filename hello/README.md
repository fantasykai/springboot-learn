> SpringBoot 

SpringApplication.run(HelloApplication.class, args);  启动SpringBoot服务

@RestController | controller 里面的方法都以 json 格式输出

### 热部署

需要引入：devtools

Spring Boot 提供的一组开发工具包，其中就包含我们需要的热部署功能。但是在使用这个功能之前还需要再做一些配置。

（1）在 dependency 中添加 optional 属性，并设置为 true：

     <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <optional>true</optional>
        </dependency>
    </dependencies>

（2）在 plugin 中配置另外一个属性 fork，并且配置为 true：

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <fork>true</fork>
                </configuration>
            </plugin>
    </plugins>
    </build>
    
（3）配置 Idea

选择 File-Settings-Compiler 勾选 Build project automatically   

快速命令查找（shift + command + a） 输入Registry 找到选项 compile.automake.allow.when.app.running 勾选

### springBoot 单元测试 

在类的上添加 `@SpringBootTest`，系统会自动加载 Spring Boot 容器

使用 MockMvc 进行 web 测试，MockMvc 内置了很多工具类和方法

> MockMvcRequestBuilders可以 post、get 请求
