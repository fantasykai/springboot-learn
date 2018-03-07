### @RestController 对JSON的支持

### 参数校验

使用 @Valid + BindingResult 处理参数校验

Spring Boot 的参数校验是依赖于 hibernate-validator 来进行

校验文件：ValidationMessages.properties

### 自定义 Filter

Spring Boot 自动添加了 OrderedCharacterEncodingFilter 和 HiddenHttpMethodFilter，并且可以自定义 Filter。

自定义 Filter 两个步骤：

实现 Filter 接口，实现 Filter 方法 添加@Configuration 注解，将自定义 Filter 加入过滤链

### 自定义 Property

配置在 application.properties 中

使用@Value 赋值，${} 获取配置值