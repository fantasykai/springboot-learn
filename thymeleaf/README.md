### Thymeleaf
> Thymeleaf 是一款用于渲染 XML/XHTML/HTML 5 内容的模板引擎。类似 JSP、Velocity、FreeMaker 等，
它也可以轻易的与 Spring MVC 等 Web 框架进行集成作为 Web 应用的模板引擎。
与其他模板引擎相比，Thymeleaf 最大的特点是能够直接在浏览器中打开并正确显示模板页面，而不需要启动整个 Web 应用。

### 特点

Thymeleaf 是一个跟 Velocity、FreeMarker 类似的模板引擎，它可以完全替代 JSP 。相较与其他的模板引擎，它有如下三个极吸引人的特点：

- Thymeleaf 在有网络和无网络的环境下皆可运行，即它可以让美工在浏览器查看页面的静态效果，也可以让程序员在服务器查看带数据的动态页面效果。这是由于它支持 html 原型，然后在 html 标签里增加额外的属性来达到模板+数据的展示方式。浏览器解释 html 时会忽略未定义的标签属性，所以 Thymeleaf 的模板可以静态地运行；当有数据返回到页面时，Thymeleaf 标签会动态地替换掉静态内容，使页面动态显示。

- Thymeleaf 开箱即用的特性。它提供标准和 Spring 标准两种方言，可以直接套用模板实现 JSTL、 OGNL 表达式效果，避免每天套模板、改 jstl、改标签的困扰。同时开发人员也可以扩展和创建自定义的方言。

- Thymeleaf 提供 Spring 标准方言和一个与 SpringMVC 完美集成的可选模块，可以快速的实现表单绑定、属性编辑器、国际化等功能。

Thymeleaf 是与众不同的，因为它使用了自然的模板技术。这意味着 Thymeleaf 的模板语法并不会破坏文档的结构，模板依旧是有效的 XML 文档。

模板还可以用作工作原型，Thymeleaf 会在运行期替换掉静态值。Velocity 与 FreeMarker 则是连续的文本处理器。

下面的代码示例分别使用 Velocity、FreeMarker 与 Thymeleaf 打印出一条消息：

        Velocity: <p>$message</p>
        FreeMarker: <p>${message}</p>
        Thymeleaf: <p th:text="${message}">Hello World!</p>
        从上面可以看出来 Thymeleaf 的作用域在 html 标签内，类似标签的一个属性来使用，这就是它的特点。

- 注意，由于 Thymeleaf 使用了 XML DOM 解析器，因此它并不适合于处理大规模的 XML 文件。


### 简单用法

#### 导入依赖

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>

#### 在 application.properties 中添加配置：

spring.thymeleaf.cache=false

#### 编写一个简单的页面 
> 见 hello.html

#### 编写Controller 
> 见 HelloController

### 页面布局

> 简单 介绍 见 copyright.html  index.html 

> 简单布局： footer.html header.html  left.html layout.html
