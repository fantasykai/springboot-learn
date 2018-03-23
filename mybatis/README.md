### MyBatis 简介

MyBatis是一个ORM框架，MyBatis本是Apache的一个开源项目IBatis，2010年项目由 Apache Software Foundation 迁移到了 Google Code，并且改名为 MyBatis，2013 年 11 月又迁移到 Github 上

MyBatis 支持普通 SQL 查询，存储过程和高级映射的优秀持久层框架。
MyBatis 消除了几乎所有的 JDBC 代码和参数的手工设置以及对结果集的检索封装。
MaBatis 可以使用简单的 XML 或注解用于配置和原始映射。将接口和 Java 的 POJO（Plain Old Java Objects，普通的 Java 对象）映射成数据库中的记录。

#### mybatis 优点

- SQL 被统一提取出来，便于统一管理和优化
- SQL 和代码解耦，将业务逻辑和数据访问逻辑分离，使系统的设计更清晰，更易维护，更易单元测试
- 提供映射标签，支持对象与数据库的 ORM 字段关系映射
- 提供对象关系映射标签，支持对象关系组件维护
- 灵活书写动态 SQL，支持各种条件来动态生成不同的 SQL

#### mybatis  缺点

- 编写 SQL 语句时工作量很大，尤其是字段多、关联表多时，更是如此
- SQL 语句依赖于数据库，导致数据库移植性差

### mybatis 几个重要的概念


**Mapper 配置：** Mapper 配置可以使用基于 XML 的 Mapper 配置文件来实现，也可以使用基于 Java 注解的 MyBatis 注解来实现，甚至可以直接使用 MyBatis 提供的 API 来实现。

**Mapper 接口：** Mapper 接口是指自行定义的一个数据操做接口，类似于通常所说的 DAO 接口。早期的 Mapper 接口需要自定义去实现，现在 MyBatis 会自动为 Mapper 接口创建动态代理对象。Mapper 接口的方法通常与 Mapper 配置文件中的 select、insert、update、delete 等 XML 结点存在一一对应关系。

**Executor：** MyBatis 中所有的 Mapper 语句的执行都是通过 Executor 进行的，Executor 是 MyBatis 的一个核心接口。

**SqlSession：** SqlSession 是 MyBatis 的关键对象，是执行持久化操作的独享，类似于 JDBC 中的 Connection，SqlSession 对象完全包含以数据库为背景的所有执行 SQL 操作的方法，它的底层封装了 JDBC 连接，可以用 SqlSession 实例来直接执行被映射的 SQL 语句。

**SqlSessionFactory：** SqlSessionFactory 是 MyBatis 的关键对象，它是单个数据库映射关系经过编译后的内存镜像。SqlSessionFactory 对象的实例可以通过 SqlSessionFactoryBuilder 对象类获得，而 SqlSessionFactoryBuilder 则可以从 XML 配置文件或一个预先定制的 Configuration 的实例构建出。

MyBatis 的工作流程如下：

![img](http://www.ityouknow.com/assets/images/2017/chat/mybat.png)

- 首先加载 Mapper 配置的 SQL 映射文件，或者是注解的相关 SQL 内容。
- 创建会话工厂，MyBatis 通过读取配置文件的信息来构造出会话工厂（SqlSessionFactory）。
- 创建会话。根据会话工厂，MyBatis 就可以通过它来创建会话对象（SqlSession）。会话对象是一个接口，该接口中包含了对数据库操作的增删改查方法。
- 创建执行器。因为会话对象本身不能直接操作数据库，所以它使用了一个叫做数据库执行器（Executor）的接口来帮它执行操作。
- 封装 SQL 对象。在这一步，执行器将待处理的 SQL 信息封装到一个对象中（MappedStatement），该对象包括 SQL 语句、输入参数映射信息（Java 简单类型、HashMap 或 POJO）和输出结果映射信息（Java 简单类型、HashMap 或 POJO）。
- 操作数据库。拥有了执行器和 SQL 信息封装对象就使用它们访问数据库了，最后再返回操作结果，结束流程。

在具体的使用过程中，按照上述的流程来执行。

###  MyBatis-Spring-Boot-Starter

MyBatis-Spring-Boot-Starter 是 MyBatis 帮助我们快速集成 Spring Boot 提供的一个组件包。

使用这个组件可以做到以下几点：

构建独立的应用
几乎可以零配置
需要很少的 XML 配置

> 注意：MyBatis-Spring-Boot-Starter 依赖于 MyBatis-Spring 和 Spring Boot，最新版 1.3.1 需要 MyBatis-Spring 1.3 以上，Spring Boot 版本 1.5 以上。

其实就是 MyBatis 看 Spring Boot 这么火热也开发出一套解决方案主动来集成， 但这一集成确实解决了很多问题，使用起来比以前简单顺畅了许多。mybatis-spring-boot-starter主要提供了两种解决方案，一种是简化后的 XML 配置版，一种是使用注解解决一切问题。

MyBatis 以前只有 XML 配置这种使用的形式，到了后来注解使用特别广泛，MyBatis 也顺应潮流提供了注解的支持，从这里可以看出 MyBatis 一直都跟随着主流技术的变化来完善自己。接下来介绍一下如何使用 XML 版本。

### XML 方式

XML 版本保持映射文件的老传统，优化主要体现在不需要实现 Dao 的实现层，系统会自动根据方法名在映射文件中找到对应的 SQL。

#### 相关配置

##### 关键依赖包

当然任何模式都需要首先引入mybatis-spring-boot-starter的 pom 文件

        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>1.3.1</version>
        </dependency>

##### application 配置

application.properties 添加相关配置：

        mybatis.config-locations=classpath:mybatis/mybatis-config.xml
        mybatis.mapper-locations=classpath:mybatis/mapper/*.xml
        mybatis.type-aliases-package=com.fantasykai.springboot.mybatis.entity
        
        
        spring.datasource.driverClassName=com.mysql.jdbc.Driver
        spring.datasource.url=jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC&useSSL=true
        spring.datasource.username=root
        spring.datasource.password=mysql2017
        

- mybatis.config-locations：配置 mybatis-config.xml 路径，mybatis-config.xml 中配置 MyBatis 基础属性。
- mybatis.mapper-locations：配置 Mapper 对应的 XML 文件路径
- mybatis.type-aliases-package：配置项目中实体类包路径
- spring.datasource.*：数据源配置

##### 启动类中增加扫码

在启动类中添加对 Mapper 包扫描@MapperScan，Spring Boot 启动的时候会自动加载包路径下的 Mapper。

```
@Spring BootApplication
@MapperScan("com.fantasykai.springboot.mybatis.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}   
```

> 或者直接在 Mapper 类上面添加注解@Mapper

#### 开发 SQL

##### MyBatis 公共属性

mybatis-config.xml，主要配置常用的 typeAliases，设置类型别名为 Java 类型设置一个短的名字。它只和 XML 配置有关，存在的意义仅在于用来减少类完全限定名的冗余。

```
<configuration>
    <typeAliases>
        <typeAlias alias="Integer" type="java.lang.Integer" />
        <typeAlias alias="Long" type="java.lang.Long" />
        <typeAlias alias="HashMap" type="java.util.HashMap" />
        <typeAlias alias="LinkedHashMap" type="java.util.LinkedHashMap" />
        <typeAlias alias="ArrayList" type="java.util.ArrayList" />
        <typeAlias alias="LinkedList" type="java.util.LinkedList" />
    </typeAliases>
</configuration>
```

这样在使用 Mapper.xml 的时候，需要引入可以直接这样写：

```
resultType="Integer" 
//或者
parameterType="Long"
```

添加 User 的映射文件
 1）指明对应文件的 Mapper 类地址：

        <mapper namespace="com.fantasykai.springboot.mybatis.mapper.UserMapper" >

 2）配置表结构和类的对应关系：

```
    <resultMap id="BaseResultMap" type="com.fantasykai.springboot.mybatis.entity.UserEntity" >
        <id column="id" property="id" jdbcType="BIGINT" />
        <result column="username" property="username" jdbcType="VARCHAR" />
        <result column="password" property="password" jdbcType="VARCHAR" />
        <result column="user_sex" property="userSex" javaType="com.fantasykai.springboot.mybatis.enums.UserSexEnum"/>
        <result column="nickname" property="nickname" jdbcType="VARCHAR" />
    </resultMap>
```
 
这里为了更好的贴近工作情况，故意将类的两个字段和数据库字段设置为不一致，并且有一个使用了枚举。使用枚举有一个非常大的优点，插入此属性的数据会自动进行校验，如果不是枚举的内容会报错。

  3）写具体的 SQL 语句，比如这样：

```
<select id="getAll" resultMap="BaseResultMap"  >
   SELECT 
   *
   FROM users
</select>
```

MyBatisXML 有一个特点是可以复用 XML，比如公用的一些 XML 片段可以提取出来，在其他 SQL 中去引用，如：
```
<sql id="Base_Column_List" >
    id, userName, passWord, user_sex, nick_name
</sql>

<select id="getAll" resultMap="BaseResultMap"  >
   SELECT 
   <include refid="Base_Column_List" />
   FROM users
</select>  
```

这个例子就是，上面定义了需要查询的表字段，下面 SQL 使用 include 引入，避免了写太多重复的配置内容。

#### 编写 Dao 层的代码

```
public interface UserMapper {

    List<UserEntity> getAll();

    List<UserEntity> getList(UserParam userParam);

    int getCount(UserParam userParam);

    UserEntity getOne(Long id);

    void insert(UserEntity user);

    int update(UserEntity user);

    int delete(Long id);
}
```
> 注意：这里的方法名需要和 XML 配置中的 id 属性一致，不然会找不到方法去对应执行的 SQL。   

测试使用

按照Spring 一贯使用形式， 直接将对应的 Mapper 注入即可

    @Resource
    private UserMapper userMapper;

然后直接使用 userMapper 进行数据库操作即可

```
@Test
public void testUser()  {
    //增加
    userMapper.insert(new UserEntity("aa", "a123456", UserSexEnum.MAN));
    //删除
    int count=userMapper.delete(29l);
    //修改
    userMapper.update(user);
    //查询
    List<UserEntity> users = userMapper.getAll();
    UserEntity user = userMapper.getOne(1l);
}
``` 

在示例代码中，写了两份的使用，一个是 Test，一个在 Controller 层，方便查看。

