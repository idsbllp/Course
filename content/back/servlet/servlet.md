### Servlet

- Servlet简介

  - Servlet是服务器端的小程序，它是相对于Applet而言的，Applet是客户端小程序。 应用传统的CGI（Common Gateway Interface , 公共网关接口）程序，针对每个HTTP请求都要启动一个新的进程。如果CGI程序自身相对比较简单，那么启动进程的开销会占用大部分执行时间。而使用servlet，Java虚拟机会一直运行，并用轻量级的Java线程处理每个请求，而非重量级的操作系统进程。
  - Servlet是接受来自网络的请求（form表单或其他的请求），并作出响应。  
  - Servlet可以实现动态的页面，可以针对不同的请求作出不同的响应，可以实现页面的流转，Servlet可以充当MVC模式中的Ctrl(控制器)模块，可以控制信息的流向。

- Web服务器

  1. 介绍

     Servlet 运行在 web 容器中， web 容器可以控制 Servlet 对象的生命周期，控制请求由
     Servlet 对象处理。
     web 服务器是软件，常用的 web 服务器有 Tomcat，JBoss 等，我们所用的 Tomcat 是
     一个开源的服务器，用 java 语言编写的 web 服务器，所以需要有相应的 java 运行环境，也就是 JVM，还要配置 tomcat 的具体路径。

  2. 配置

     就以我们用的开发工具IDEA为例:

     - 首先,我们要先新建一个Project

       ![新建工程][1]

       ![新建java web工程][2]

       往下输入名字然后next就创建成功了

     - **然后就要开始配置Tomcat了**

       首先,点开如图所示的Edit Configurations

        ![配置Tomcat-1][3]

       然后,添加Tomcat server,如图

        ![配置Tomcat-2][4]

       接下来就是对其做配置

        ![Tomcat-3][5]

       如果在执行时遇到port相关的报错,可以尝试把HTTP port改成其他的比如8081等

       然后就可以点击右上角的运行按钮运行了

  3. 导入jar包

     1. 第一种,可以将jar文件放入jdk1.8.xxx/jre/lib里
     2. 第二种,可以看下[这篇文章](http://blog.csdn.net/qq_26525215/article/details/53239123)
     3. 第三种,可以点击file->project Structured,打开窗口,点击Libraries后单击加号添加lib的文件


- Servlet的生命周期(书 Headfirst Servlet&JSP p99)

  - Servlet的处理流程(图文描述可看书 p42-43)

    1. 客户端使用浏览器(GET/POST等)提交页面,服务器接收到请求后,如果该Servlet第一次被调用,会先实例化这个Servlet,调用Servlet对象的init()方法初始化Servlet信息,init()方法只会被调用一次(GET/POST请求描述见书 p12-19 p110-122)
    2. 服务器调用该Servlet对象的service()方法(即响应请求,service()会根据情况委托任务给doGet(),doPost()方法来处理请求)
    3. Servlet产生动态的回复内容
    4. 服务器发送回复内容给客户浏览
    5. 在长时间没有被调用或者服务器被关闭的时候,会调用destroy()方法销毁Servlet对象

     ![处理流程1][6]

    ![处理流程2][7]

- Servlet的配置

  - web服务器接受到用户发出的请求，会根据用户访问的路径，从web.xml配置文件中查找所需要的类，服务器会从web应用的WEB-INF文件夹下的classes文件夹中搜索要加载的class文件。

  - web.xml文件的配置，一个web.xml中可以配置多个Servlet (web.xml的描述在书 p48-49 也叫做部署描述文件)

    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xmlns:web="http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" version="3.0">
      <servlet>          
         <servlet-name>servlet的名字</servlet-name>        
         <servlet-class>servlet类全名</servlet-class>    
      </servlet> 
      <servlet-mapping>   
        <servlet-name>servlet的名字（要和servlet标签中的相同） 
        </servlet-name>          
        <url-pattern>指定servlet相对于应用目录的路径</url-pattern>    
      </servlet-mapping>
    </web-app>
    ```

    其实现在的Servlet配置已经不用web.xml设置这么多servlet的值了

    只需要在Servlet的类上面加@WebServlet(name="servlet的名字" , value="指定servlet相对于应用目录的路径")就可以包含上面的操作了,如图

    ![][8]

    当然,web.xml还有其他的作用,以上操作只是简化了关于servlet的一些设置

    当然,web.xml还有其他的作用,以上操作只是简化了关于servlet的一些设置

    ​

- Servlet的接口

  - servlet接口中的方法

    实现Servlet接口

    ```java
    public class TestServlet implements Servlet { 
        ServletConfig config;   
        public void init(ServletConfig config) throws ServletException {   
            this.config=config;   
        } 
        public ServletConfig getServletConfig() {  
            return this.config;   
        }   
        public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {    
            ...;
            //这个方法是用来处理请求的核心方法 
        }   
        public String getServletInfo() {   
          	return "....";//这个是用来写Servlet信息的，用来写作者，以及版本信息
    	}   
      	public void destroy() {   
          ...;//这个方法是用来销毁Servlet对象的   
        }  
    }
    ```

    ​	HttpServlet和GenericServlet都实现了Servlet接口。  HttpServlet中的service(HttpServletRequest request，HttpServletResponse response)方法是通过service(ServletRequest request,ServletResponse response)方法的调用来实现对请求的处理。

    ​	当然,我们不用这么麻烦些这么一大堆,参考书上实例(p89),我们现在大多数写法只需要继承HttpServlet方法就可以很快的用上Servlet

    ​	以下代码列出了常用的两个方法的覆写

    ```java
    public class TestServlet extends HttpServlet{
      	//覆写doGet()方法
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            ...;
        }
      	//覆写doPost方法
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            ...;
        }
    }
    ```

- Servlet&JSP(简单说说)

  - Servlet怎么和JSP交互数据

    Servlet和JSP交互数据需要用到JSP的九大内置对象

    ```xml
    request           请求对象　            类型 javax.servlet.ServletRequest        作用域 Request
    response          响应对象              类型 javax.servlet.SrvletResponse        作用域 Page
    pageContext       页面上下文对象        类型 javax.servlet.jsp.PageContext       作用域 Page
    session           会话对象              类型 javax.servlet.http.HttpSession      作用域 Session
    application       应用程序对象          类型 javax.servlet.ServletContext        作用域 Application
    out               输出对象              类型 javax.servlet.jsp.JspWriter         作用域 Page
    config            配置对象              类型 javax.servlet.ServletConfig         作用域 Page
    page              页面对象              类型 javax.lang.Object                   作用域 Page
    exception         例外对象              类型 javax.lang.Throwable                作用域 page
    “exception” 对象则代表了JSP文件运行时所产生的例外对象，此对象不能在一般JSP文件中直接使用，而只能在使用了“<%@ page isErrorPage="true "%>”的JSP文件中使用。
    ```

    详细在这个[博客](http://blog.csdn.net/u013142781/article/details/50756419)了解下,今天的重点是Servlet

    我们在Servlet通常使用requset.setAttribute()方法和getRequestDispatcher("地址").forward(request,response)将我们的request和response参数转交给JSP的request和response处理

  - JSP怎么显示我们通过Servlet显示的数据

    1. JSP表达式语言(EL-Expression Language)(书p366-396)

       一个很方便的操作JSP内置对象的语言

       功能:

       ​	与<jsp:getProperty />类似

       ​	简化<jsp:getProperty />

       语法:

       ​	${expression}

       ​	\${bean.name} 或 ${bean['name']}

    2. JSTL(JavaServerPages Standard Tag Livrary)(书第九章)

       一个强大的定制标记

  ​

- Servlet的响应

  - HttpServletRequest和HttpServletResponse(书 p106 p126-140)

    - HttpServletRequest的常用方法

      1. requset.getParameter(String name)方法

         ```
         <input type="text" name="name" value="${ LoginForm.name }"  size=11/>  
         ```

         读取请求中传送的值，可以获得form表单中指定名字的参数，多参数同名时，只取一个。 

         getParameterNames()， 取得所有参数的名字，可以获得一个迭代器Enumeration，通过这个迭代器，来获得form表单中参数的名字。

         注：不存在时，会返回null。

      2. request.getContextPath()方法

         getContextPath()获得应用的路径，用动态获取应用路径  

         getServletPath()获得Servlet路径，也就是form中的action，如果使用确切路径那么就会是这个Servlet配置的url-pattern。  

         getPathInfo()使用模糊路径匹配时会返回匹配模糊部分。    

         注意：  在form表单的action中，如果使用了扩展名匹配，一定要写明/xxxxx/xxx.xx，不要写成/xxxx/*.xx  在form的action中要尽量使用绝对路径，也就是要用应用名/xxx.xx或者应用名/xxx

      3. request.setAttribute(String name,Object o)方法

         可以使用HttpServletRequest对象来携带信息。  通过getAttribute(String name)方法来获得携带的信息。  这两个方法类似于map中的存取方法，setAttribute方法给数据加上标识，getAttribute方法则是通过这个标识来获取数据，可以使用这一对方法的前提就是要保证是同一个请求对象（HttpServletRequest）

      4. request.getInputStream()方法  (书 p128-129

         可以获得一个由Socket得来的输入流，可以使用这个流来实现文件的上传。type=”file”

      5. request.getRequestDispatcher()方法

         意思是处理完了，分发到下一个JSP页面或者下一个Action继续处理。

         后面可加	forward(),是request中的参数继续传递,如果不加则没有

      6. 等等......

    - HttpServletResponse的常用方法

      1. setContentType(String type) 

         设置响应的内容类型为type

      2. setCharacterEncoding(Stirng charset) 

         设置响应的编码字符

      3. getWriter()  

         利用这个可以向客户端输出文本

      4. sendRedirect(String location)

         向客户端发送一个重定向的请求

      5. setStatus(int status)

         定制Status code

      6. Response.sendRedirect()

         HttpServletResponse 是用来回应用户的操作的,它可以实现页面重定向 ,sendRedirect(String location)是用这个方法指定要访问的 servlet，其参数是 Servlet 的 url-pattern 的值。

         如果使用了重定向，就不会保留原有的Request对象

         eg: Response.sendRedirect (“/WEB-INF/student/ctrl”);

      7. 等等......

  ​





[1]: ./image/1.png
[2]: ./image/2.png
[3]: ./image/3.png
[4]: ./image/4.png
[5]: ./image/5.png
[6]: ./image/6.png
[7]: ./image/7.png
[8]: ./image/8.png