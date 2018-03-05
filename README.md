### springBoot 学习，练习等
> 核心思想：约定大于配置

### 一般项目结构
- Application.java：建议放到根目录下面，是项目的启动类，Spring Boot 项目只能有一个 main() 方法。
- common：目录建议放置公共的类，如全局的配置文件、工具类等。
- domain：目录主要用于实体（Entity）与数据访问层（Repository）。
- repository：数据库访问层代码。
- service：该层主要是业务类代码。
- web：该层负责页面访问控制。

### resources 目录下：

- static：目录存放 Web 访问的静态资源，如 JS、CSS、图片等。
- templates：目录存放页面模板。
- application.properties：项目的配置信息。

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


### springBoot 单元测试 

在类的上面添加@SpringBootTest，系统会自动加载 Spring Boot 容器

> MockMvcRequestBuilders可以 post、get 请求

### springBoot 天然对 JSON 支持

### 使用 @Valid + BindingResult 解决参数校验问题

> Spring Boot 的参数校验其实是依赖于 hibernate-validator 来进行

### 自定义Filter

> Spring Boot 自动添加了 OrderedCharacterEncodingFilter 和 HiddenHttpMethodFilter，并且可以自定义 Filter。

自定义Filter 两个步骤：

> 实现 Filter 接口，实现 Filter 方法 添加@Configuration 注解，将自定义 Filter 加入过滤链

### 自定义Property

配置在 application.properties 中

### Spring Data JPA 的使用

> JPA 大大解放了对数据库的操作，我们经常使用的 SQL 大部分都已经被预生成，直接使用即可。
另外 JPA 还有一个特点，我们再也不用关心数据库的表结构了，需要更改的时候只需要修改对应 domain 的属性即可。
在微服务架构中，因为服务拆分得越来越小，微服务内部只关心自己的业务，需要复杂查询的场景会越来越少，在微服务架构中更推荐使用 JPA 技术。

程序员的技术学习都是从增删改查开始的。