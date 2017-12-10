# 数据库基础

------

#### 1.数据库设计实例

>  博客系统：用户登录注册、博客的增删改查

> 用户评论

![微信评论][1]

![空间评论][2]

##### 如何通过数据库保存树状结构？

|字段|说说|回复用户|被回复用户|内容|时间|回复的评论|
|--|--|--|--|--|
|说明|所有的回复评论是针对哪一条说说|这个回复是谁发的|这个回复是针对那个用户的|说说内容|发布时间|针对哪一条评论作出的回复|

> 基于角色权限的访问控制

![QQ主要业务][3]

![部分业务权限][4]

![rbac说明][5]

> 排名

![班级排名][6]

![个人排名][7]

#### 2.MySQL跟Navicat的区别

> 装了MySQL就跟装了jdk一样，我们都可以通过命令行的形式去写sql或者java文件，然后运行，但是为什么装了jdk后还要去装idea，因为图形化界面方便快捷、易于管理。Navicat就是MySQL的idea

#### 3.创建数据库 以及 创建表

> 数据类型

###### 数值类型

![数值类型][8]

###### 时间类型

![时间类型][9]

###### 字符类型

![字符类型][10]

#### 4. sql语句 [sql语句知识基础][12]

```sql
//select语法
SELECT[ALL|DISTINCT|DISTINCTROW|TOP] 
{*|talbe.*|[table.]field1[AS alias1][,[table.]field2[AS alias2][,…]]} 
FROM table expression[,…][IN externaldatabase] 
[WHERE…] 
[GROUP BY…] 
[HAVING…] 
[ORDER BY…]

注意 where，group by，having，order by 顺序。
执行步骤：
1.先从from字句一个表或多个表创建工作表
2.将where条件应用于1）的工作表，保留满足条件的行
3.group by 将2）的结果分成多个组
4.having 将条件应用于3）组合的条件过滤，只保留符合要求的组。
5.order by对结果进行排序
```

> 设计范式：[设计范式相关][11]

##### 4.数据库 JDBC 与 Java
> 数据库与Java是两个不同的软件，两者之间需要合做就需要一个桥梁，这个就是JDBC

##### 5.数据库连接
 
```java
 #数据库配置 config.properties
#提供jdbc连接的url：协议、自协议、数据库标示

链接地址：https://hongyan.cqupt.edu.cn/MagicLoop/index.php?s=/addon/CourseTable/CourseTable/index&openid=ouRCyjndQXTkjgtAuzUG4F3MZNa8
数据库地址：jdbc:mysql//127.0.0.1:3306/test?useUnicode=true&characterEncoding=UTF-8&useTimezone=true&serverTimezone=PRC
提供jdbc连接的 协议 自协议 数据库标识

mysql.url=jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&setCharacterEncoding=UTF-8&useTimezone=true&serverTimezone=PRC
mysql.user=root
mysql.password=

//数据库操作类 MySQL.java
public class MySQL {
    private static Connection connection;
   
    static {
        try {
            //加载配置文件
            Properties properties = new Properties();
            properties.load(MySQL.class.getResourceAsStream("/config.properties"));
            String url = properties.getProperty("mysql.url");
            String user = properties.getProperty("mysql.user");
            String password = properties.getProperty("mysql.password”);
            //加载驱动：将需要连接的数据库的驱动通过Class.forname()的形式加载址jvm中
            Class.forName("com.mysql.cj.jdbc.Driver”);
            //建立连接
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
    public static void insert() {
        try {
            //
            Statement statement = connection.createStatement();
            statement.execute("insert into user(username, password) VALUES ('jiangtianxing', 'sdfjsdkfjskfjksd')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```


  [1]: ./image/chat1.png
  [2]: ./image/chat2.png
  [3]: ./image/role1.png
  [4]: ./image/role2.png
  [5]: ./image/role3.png
  [6]: ./image/class-rank.png
  [7]: ./image/person-rank.png
  [8]: ./image/number.png
  [9]: ./image/time.png
  [10]: ./image/string.png      
  [11]: https://www.zhihu.com/question/24696366
  [12]: ./back_demo/tree/sql.html