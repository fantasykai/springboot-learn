## JPA | Java Persistence API

> JPA 是在充分吸收了现有 Hibernate、TopLink、JDO 等 ORM 框架的基础上发展而来的，具有易于使用、伸缩性强等优点.
简化了现有的持久化开发工作和整合ORM技术，结束现在了Hibernate、Top-Link、JDO 等ORM 框架各自为营的局面。

### Spring Data JPA
> Spring Data JPA 是 Spring 基于 ORM 框架、JPA 规范的基础上封装的一套 JPA 应用框架，
可使开发者用极简的代码即可实现对数据的访问和操作。它提供了包括增删改查等在内的常用功能，且易于扩展！
学习并使用 Spring Data JPA 可以极大提高开发效率！

Spring Data JPA 让我们解脱了 DAO 层的操作，基本上所有 CRUD 都可以依赖于它来实现。

#### 添加依赖

        <dependency>
            <groupId>org.Springframework.boot</groupId>
            <artifactId>Spring-boot-starter-data-jpa</artifactId>
        </dependency>
         <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>

#### 配置数据库链接等

- 详细见 application.properties 

#### 编写Entity 

> 使用 @Entity @Id @GeneratedValue @Column 等注解 进行数据库和实体类的映射

#### DAO层

Dao 只要继承 JpaRepository 类就可以，几乎可以不用写方法，

可以根据方法名来自动的生产 SQL，如 findByUserName 会自动生产一个以 userName 为参数的查询方法，

如 findAll 自动会查询表里面的所有数据，如自动分页等等。

- 注意 Entity 中不需要映射成数据库中列的字段 需要加 @Transient 注解，不加注解也会映射成列

### 使用简介

#### 基本查询

基本查询分为两种
 
- Spring Data 默认实现
- 根据查询的方法来自动解析成 SQL

##### 预先生成方法
Spring Data JPA 默认预先生成了一些基本的 CURD 的方法，如增、删、改等。

继承 JpaRepository：

        public interface UserRepository extends JpaRepository<User, Long> {
        }
        

已经实现的基本查询

        userRepository.findAll();
        userRepository.findOne(1l);
        userRepository.save(user);
        userRepository.delete(user);
        userRepository.count();
        userRepository.exists(1l);    
        
##### 自定义简单查询

自定义的简单查询就是根据方法名来自动生成 SQL，主要的语法是 findXXBy、readAXXBy、queryXXBy、countXXBy、getXXBy 后面跟属性名称：

>  User findByUserName(String userName);
            
**具体的关键字，使用方法和生产成 SQL 如下表所示：**

| Keyword           | Sample                                  | JPQL snippet                                                 |
| ----------------- | --------------------------------------- | ------------------------------------------------------------ |
| And               | findByLastnameAndFirstname              | … where x.lastname = ?1 and x.firstname = ?2                 |
| Or                | findByLastnameOrFirstname               | … where x.lastname = ?1 or x.firstname = ?2                  |
| Is,Equals         | findByFirstnameIs,findByFirstnameEquals | … where x.firstname = ?1                                     |
| Between           | findByStartDateBetween                  | … where x.startDate between ?1 and ?2                        |
| LessThan          | findByAgeLessThan                       | … where x.age < ?1                                           |
| LessThanEqual     | findByAgeLessThanEqual                  | … where x.age ⇐ ?1                                           |
| GreaterThan       | findByAgeGreaterThan                    | … where x.age > ?1                                           |
| GreaterThanEqual  | findByAgeGreaterThanEqual               | … where x.age >= ?1                                          |
| After             | findByStartDateAfter                    | … where x.startDate > ?1                                     |
| Before            | findByStartDateBefore                   | … where x.startDate < ?1                                     |
| IsNull            | findByAgeIsNull                         | … where x.age is null                                        |
| IsNotNull,NotNull | findByAge(Is)NotNull                    | … where x.age not null                                       |
| Like              | findByFirstnameLike                     | … where x.firstname like ?1                                  |
| NotLike           | findByFirstnameNotLike                  | … where x.firstname not like ?1                              |
| StartingWith      | findByFirstnameStartingWith             | … where x.firstname like ?1 (parameter bound with appended %) |
| EndingWith        | findByFirstnameEndingWith               | … where x.firstname like ?1 (parameter bound with prepended %) |
| Containing        | findByFirstnameContaining               | … where x.firstname like ?1 (parameter bound wrapped in %)   |
| OrderBy           | findByAgeOrderByLastnameDesc            | … where x.age = ?1 order by x.lastname desc                  |
| Not               | findByLastnameNot                       | … where x.lastname <> ?1                                     |
| In                | findByAgeIn(Collection<Age> ages)       | … where x.age in ?1                                          |
| NotIn             | findByAgeNotIn(Collection<Age> age)     | … where x.age not in ?1                                      |
| TRUE              | findByActiveTrue()                      | … where x.active = true                                      |
| FALSE             | findByActiveFalse()                     | … where x.active = false                                     |
| IgnoreCase        | findByFirstnameIgnoreCase               | … where UPPER(x.firstame) = UPPER(?1)                        |


> 在实际的开发中需要用到分页、筛选、连表等查询的时候就需要特殊的方法或者自定义 SQL。

#####  分页查询

Spring Data JPA 已经帮我们实现了分页的功能，在查询的方法中，需要传入参数 Pageable，当查询中有多个参数的时候 Pageable 建议做为最后一个参数传入：

        @Query("select u from User u")
        Page<User> findALL(Pageable pageable);
        
        Page<User> findByNickName(String nickName, Pageable pageable);
        
Pageable 是 Spring 封装的分页实现类，使用的时候需要传入页数、每页条数和排序规则。

@Test
public void testPageQuery(){
    int page=1,size=10;
    Sort sort = new Sort(Direction.DESC, "id");
    Pageable pageable = new PageRequest(page, size, sort);
    userRepository.findALL(pageable);
    userRepository.findByNickName("testName", pageable);
}

有时候我们只需要查询前 N 个元素，或者只取前一个实体。

        User findFirstByOrderByLastnameAsc();
        
        User findTopByOrderByAgeDesc();
        
        Page<User> queryFirst10ByLastname(String lastname, Pageable pageable);
        
        List<User> findFirst10ByLastname(String lastname, Sort sort);
        
        List<User> findTop10ByLastname(String lastname, Pageable page        
        
#### 自定义 SQL 查询

使用 Spring Data 大部分的 SQL 都可以根据方法名定义的方式来实现，但是由于某些原因我们想使用自定义的 SQL 来查询，Spring Data 也可以完美支持；
在 SQL 的查询方法上面使用 @Query 注解，如涉及到删除和修改需要加上 @Modifying，也可以根据需要添加 @Transactional 对事物的支持，查询超时的设置等。

- 见 UserRepository.java

#### 多表查询
多表查询在 Spring Data JPA 中有两种实现方式

- 利用 hibernate 的级联查询来实现

- 创建一个结果集的接口来接收连表查询后的结果

> 在运行中 Spring 会给接口（UserInfo）自动生产一个代理类来接收返回的结果，代码中使用 getXX 的形式来获取。

见  UserInfo UserDetailRepository 

####  使用枚举
使用枚举的时候，希望数据库中存储的是枚举对应的 String 类型，而不是枚举的索引值，需要在属性上面添加 @Enumerated(EnumType.STRING) 注解：

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private UserSexEnum sex;

多数据源见 jpa-multi