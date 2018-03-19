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


