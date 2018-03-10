> JPA基本简介及总结，jpa 模块，此模块主要针对多数据源配置进行简单总结

### 多数据源的支持

在项目开发中，常常需要在一个项目中使用多个数据源，因此需要配置 Spring Data JPA 对多数据源的使用，一般分为以下三步：

- 配置多数据源
- 不同源的 repository 放入不同包路径
- 声明不同的包路径下使用不同的数据源、事务支持

#### 配置数据源
具体配置两个数据源 见 application.properties

#### 编写数据源配置类

config 包中的 DataSourceConfig PrimaryConfig SecondaryConfig