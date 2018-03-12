### Thymeleaf
> Thymeleaf 是一款用于渲染 XML/XHTML/HTML 5 内容的模板引擎。类似 JSP、Velocity、FreeMaker 等，
它也可以轻易的与 Spring MVC 等 Web 框架进行集成作为 Web 应用的模板引擎。
与其他模板引擎相比，Thymeleaf 最大的特点是能够直接在浏览器中打开并正确显示模板页面，而不需要启动整个 Web 应用。

### 特点

Thymeleaf 是一个跟 Velocity、FreeMarker 类似的模板引擎，它可以完全替代 JSP 。相较与其他的模板引擎，它有如下三个极吸引人的特点：

- Thymeleaf 在有网络和无网络的环境下皆可运行，即它可以让美工在浏览器查看页面的静态效果，也可以让程序员在服务器查看带数据的动态页面效果。这是由于它支持 html 原型，

然后在 html 标签里增加额外的属性来达到模板+数据的展示方式。浏览器解释 html 时会忽略未定义的标签属性，所以 Thymeleaf 的模板可以静态地运行；当有数据返回到页面时，Thymeleaf 标签会动态地替换掉静态内容，使页面动态显示。

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

> 简单布局： footer.html header.html  left.html layout.html home.html

> layout.html 就成为一个页面模板，任何页面想使用这样的布局值只需要替换中间的 content 模块即可，例见 home.html

采用页面模板布局的时候有两个关键设置：

- 在模板页面定义需要替换的部分：layout:fragment="content"。
- 在需要引入模板的页面头部写 layout:decorator="layout"" ，再复写 layout:fragment="content" 中的内容。

也可以在引用模版的时候传参：

        <head th:include="layout :: htmlhead" th:with="title='Home'"></head>
        
模板页面需要定义 ${title}来接收：     

        <head th:fragment="htmlhead">
            <meta charset="UTF-8"></meta>
            <title th:text="${title}">Layout</title>
        </head>   
        
${title} 值也可以设置默认值，比如这样：
        
        <title th:text="${title}!=null?${title}:'Layout'">Layout</title>        
        
### 常用语法

见  DemoController、demo.html 

#### 赋值、字符串拼接

        <p th:text="${userName}">neo</p>
        <span th:text="'Welcome to our application, ' + ${userName} + '!'"></span>
        
可以使用|| 简介的写法    

        <span th:text="|Welcome to our application, ${userName}!|"></span>        
        
#### 条件判断 If/Unless    

Thymeleaf 中使用 th:if 和 th:unless 属性进行条件判断，下面的例子中，<a>标签只有在 th:if 中条件成立时才显示：

        <a th:if="${flag == 'yes'}"  th:href="@{/home}"> home </a>
        <a th:unless="${flag != 'no'}" th:href="@{http://www.ityouknow.com/}" >ityouknow</a>     
        
> th:unless 与 th:if 恰好相反，只有表达式中的条件不成立，才会显示其内容。

也可以使用 (if) ? (then) : (else) 这种语法来判断显示的内容

#### for 循环

        <table>
            <tr  th:each="user,iterStat : ${users}">
                <td th:text="${user.name}">neo</td>
                <td th:text="${user.age}">6</td>
                <td th:text="${user.pass}">213</td>
                <td th:text="${iterStat.index}">index</td>
            </tr>
        </table>

iterStat 称作状态变量，属性有：

- index：当前迭代对象的 index（从 0 开始计算）
- count：当前迭代对象的 index（从 1 开始计算）
- size：被迭代对象的大小
- current：当前迭代变量
- even/odd：布尔值，当前循环是否是偶数/奇数（从 0 开始计算）
- first：布尔值，当前循环是否是第一个
- last：布尔值，当前循环是否是最后一个


####  URL
URL 在 Web 应用模板中占据着十分重要的地位，需要特别注意的是 Thymeleaf 对于 URL 的处理是通过语法 @{...} 来处理的。
 如果需要 Thymeleaf 对 URL 进行渲染，那么务必使用 th:href、th:src 等属性，下面举一个例子：

        <a  th:href="@{http://www.ityouknow.com/{type}(type=${type})}">link1</a>
        
        <a href="details.html" th:href="@{http://www.ityouknow.com/{pageId}/can-use-springcloud.html(pageId=${pageId})}">view</a>
        

#### 设置背景：

        <div th:style="'background:url(' + @{${img}} + ');'">        

               
#### 根据属性值改变背景：

        <div class="media-object resource-card-image"  th:style="'background:url(' + @{(${collect.webLogo}=='' ? 'img/favicon.png' : ${collect.webLogo})} + ')'" ></div>
        
几点补充说明：

- 上例中 URL 最后的 (pageId=${pageId}) 表示将括号内的内容作为 URL 参数处理，该语法避免使用字符串拼接，大大提高了可读性。
- @{...} 表达式中可以通过 {pageId} 访问 Context 中的 pageId 变量。
- @{/order} 是 Context 相关的相对路径，在渲染时会自动添加上当前 Web 应用的 Context 名字，假设 context 名字为 app，那么结果应该是 /app/order。
        
#### 内联 [ [ ] ]

内联文本：[[...]] 内联文本的表示方式，使用时，必须先用在 th:inline="text/javascript/none" 激活，
th:inline 可以在父级标签内使用，甚至作为 body 的标签。内联文本尽管比 th:text 的代码少，不利于原型显示。

文本内联：

        <div th:inline="text" >
            <h1>内联js</h1>
            <p>Hello, [[${userName}]]</p>
            <br/>
        </div>

脚本内联，脚本内联可以在 js 中取到后台传过来的参数：

        <script th:inline="javascript">
            var name = [[${userName}]] + ', Sebastian';
            alert(name);
        </script>        
        
内嵌变量

为了模板更加易用，Thymeleaf 还提供了一系列 Utility 对象（内置于 Context 中），可以通过 # 直接访问：

- dates：java.util.Date 的功能方法类
- calendars： 类似 #dates，面向 java.util.Calendar
- numbers：格式化数字的功能方法类
- strings：字符串对象的功能类，contains、startWiths、prepending/appending 等
- objects：对 objects 的功能类操作
- bools： 对布尔值求值的功能方法
- arrays：对数组的功能类方法
- lists：对 lists 的功能类方法
- sets
- maps
...        

下面用一段代码来举例一些常用的方法：

dates

        <p th:text="${#dates.format(date, 'dd/MMM/yyyy HH:mm')}">neo</p>
        <p th:text="${#dates.createToday()}">neo</p>
        <p th:text="${#dates.createNow()}">neo</p>
        
strings

        <p th:text="${#strings.isEmpty(userName)}">userName</p>
        <p th:text="${#strings.listIsEmpty(users)}">userName</p>
        <p th:text="${#strings.length(userName)}">userName</p>
        <p th:text="${#strings.concat(userName)}"></p>
        
        <p th:text="${#strings.randomAlphanumeric(count)}">userName</p>       

常用 th 标签都有那些？

| 关键字      | 功能介绍                                     | 案例                                                         |
| ----------- | -------------------------------------------- | ------------------------------------------------------------ |
| th:id       | 替换id                                       | `<input th:id="'xxx' + ${collect.id}"/>`                     |
| th:text     | 文本替换                                     | `<p th:text="${collect.description}">description</p>`        |
| th:utext    | 支持html的文本替换                           | `<p th:utext="${htmlcontent}">conten</p>`                    |
| th:object   | 替换对象                                     | `<div th:object="${session.user}">`                          |
| th:value    | 属性赋值                                     | `<input th:value="${user.name}" />`                          |
| th:with     | 变量赋值运算                                 | `<div th:with="isEven=${prodStat.count}%2==0"></div>`        |
| th:style    | 设置样式                                     | `th:style="'display:' + @{(${sitrue} ? 'none' : 'inline-block')} + ''"` |
| th:onclick  | 点击事件                                     | `th:onclick="'getCollect()'"`                                |
| th:each     | 属性赋值                                     | `tr th:each="user,userStat:${users}">`                       |
| th:if       | 判断条件                                     | `<a th:if="${userId == collect.userId}" >`                   |
| th:unless   | 和th:if判断相反                              | `<a th:href="@{/login}" th:unless=${session.user != null}>Login</a>` |
| th:href     | 链接地址                                     | `<a th:href="@{/login}" th:unless=${session.user != null}>Login</a> />` |
| th:switch   | 多路选择 配合th:case 使用                    | `<div th:switch="${user.role}">`                             |
| th:case     | th:switch的一个分支                          | `<p th:case="'admin'">User is an administrator</p>`          |
| th:fragment | 布局标签，定义一个代码片段，方便其它地方引用 | `<div th:fragment="alert">`                                  |
| th:include  | 布局标签，替换内容到引入的文件               | `<head th:include="layout :: htmlhead" th:with="title='xx'"></head> />` |
| th:replace  | 布局标签，替换整个标签到引入的文件           | `<div th:replace="fragments/header :: title"></div>`         |
| th:selected | selected选择框 选中                          | `th:selected="(${xxx.id} == ${configObj.dd})"`               |
| th:src      | 图片类地址引入                               | `<img class="img-responsive" alt="App Logo" th:src="@{/img/logo.png}" />` |
| th:inline   | 定义js脚本可以使用变量                       | `<script type="text/javascript" th:inline="javascript">`     |
| th:action   | 表单提交的地址                               | `<form action="subscribe.html" th:action="@{/subscribe}">`   |
| th:remove   | 删除某个属性                                 | `<tr th:remove="all">` 1.all:删除包含标签和所有的子节点。2.body:不包含标记删除,但删除其所有的子节点。3.tag:包含标记的删除,但不删除它的子节点。4.all-but-first:删除所有包含标签的子节点,除了第一个。5.none:什么也不做。这个值是有用的动态评估 |
| th:attr     | 设置标签属性，多个属性可以用逗号分隔         | 比如 `th:attr="src=@{/image/aa.jpg},title=#{logo}"`，此标签不太优雅，一般用的比较少 |

还有非常多的标签，这里只列出最常用的几个，由于一个标签内可以包含多个th:x属性，其生效的优先级顺序为:

        include,each,if/unless/switch/case,with,attr/attrprepend/attrappend,value/href,src ,etc,text/utext,fragment,remove。

总结

> Thymeleaf 是一个非常灵活和优秀的前端页面模板引擎，使用 Thymeleaf 可以非常灵活的对页面进行布局，复用通用页面。Thymeleaf 提供了各种常用的语法.

     