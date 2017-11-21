# WebRock-Task4

#前端

## 作业内容	

### 基础

切Task文件夹里的图

* 切到homework.jpg里面的那么多就好

**写一个轮播**

* 不限样式，能跑就行
* 实现左右箭头点击切换的功能

### 进阶

* 轮播实现下方小点变动和点击切换，鼠标放上去停止滚动
* 把你的轮播封装成你自己的方法

如示例：（当然还是不限样式，但是尽量美观）

提示：进阶内容可以去找找慕课学习一个

![轮播示例](./exmaple.png)

## 作业要求

* 切图尽量做到不崩
* 轮播用原生js写
* **提交时不要发附件给我，上传到GitHub之后直接发地址给我**

附：[Git教程地址](https://www.liaoxuefeng.com/wiki/0013739516305929606dd18361248578c67b8067c8c017b000/)

​	[切图psd地址](https://github.com/BlackDriver/WebRockFE-Task4.git)

## DeadLine

本周五2400之前将你的作业的**GitHub地址**提交到wanghongyi@redrock.team



--------------------------------

# 后端

## 容器作业

### 要求

使用这节课学习的容器知识,通过已经给出的接口抽象类,使用Map List Set等容器将整个学校学生信息按照它们之间的关系,循序赋值,将全校的数据压在一个容器里面

层级关系图为:学院->专业->班级->学生

大概的效果是能将输入好的封装在一个Map/List类型的容器里面(即是学校)

记得新建**学生类!!**

然后能通过学校这个变量追溯下去找到某个班的某个同学的信息.

**例 **:如果你使用Map类型输出,那么你需要实现的效果是将变量封装好之后,你能通过你的容器,来输出一个学生的数据或一个班/专业的学生数据



**进阶要求**:实现一个函数,使得你能通过手动输入学号在你封装好的学校容器中找到一个特定的同学,然后在屏幕中输出他的信息.

- 更进阶的一个小要求:尽量使用数据结构和算法的部分知识来优化你的算法,使得你的程序的查询速度越快越好(到这里你就已经实现了一个非常简单的数据库)

其中获取教务在线数据的类已经给出在tools.java里面,下面是对于工具类的说明,请直接调用,由于数据来自于内网,所以使用时需要使用连接内网来进行数据的获取,注意工具类已经被封装好,请不要擅自改动(当然可以自己改一改来爬取别的东西->比如照片)

附:工具类地址:https://github.com/RedrockTeam/Course/blob/master/content/homework/tools.java

### 工具类的几个方法说明

提供的tools类的静态方法说明:

```java
public static Map<String,ArrayList> getCollageToMajorMap() throws IOException
```

该方法返回的是学院到专业的一个HashMap,其中键为学院名,对应的值为包括了该学院所有专业的一个ArrayList

```java
public static ArrayList<String> getCollageList() throws IOException
```

该方法返回的是我们学校的学院列表 返回类型为ArrayList 

```java
public static Map<String, ArrayList> getClassList(String ClassID) throws IOException
```

该方法返回的是某个班级的所有学生信息,所需传入的参数为班级号,例如"01011601",然后返回值为一个包含了该班所有学生信息的HashMap,其中键为学生名字,值为一个包含了该学生所有信息的ArrayList

```java
public static Map<String,List<String>> getMajorToClassList() throws IOException
```

该方法返回的是一个专业到班级号的HashMap,其中键为String类型的专业名,值为一个包含了该专业所有班级号的ArrayList

```java
public static String getData(String strUrl) throws IOException
```

该方法不用管...是用来抓取页面数据的一个方法,静置不动就好



## 截止时间

作业可能稍难,描述上如果有不懂的可以直接私聊我,最近两天比较忙所以现在才将作业发出来,相应的时间也延后一天到**周六晚12点(即11/25 23:59:59之前交) **

### 作业提交

大家可以学习一下git,然后将git地址发到yangruixin@redrock.team

如果不会的话,可以打压缩包将作业发过来

记得在邮件里面写上姓名学号!

## 最后说几句

即使没有做出来,也可以将已经做完的部分和没能做完的原因,就是做作业时候的疑惑打包发到邮箱,不要害怕没做出来,尽人事就好~~



## 关于作业的一些叙述:

作业里面已经给出了大部分的数据以及返回格式,鉴于很多同学还是说没有看懂题目,这里再给一下解释吧,工具类tools里面给出了4个静态方法,他们分别会返回的数据是学院列表(getCollageList),学院到专业的映射表(getCollageToMajorMap),专业到班级的映射表(getMajorToClassList),和单个班级的所有学生数据(getClassList),前三个方法并没有参数,可以直接拿到全校的数据,第四个方法也就是单个班级的学生数据,需要你传入班级号,然后拿到班级内所有学生的List.而你需要做的事,就是将上面四个方法返回的数据,放到一个容器里面,并形成一个层级关系(学院->专业->班级->学生).最后需要实现的效果是,你能通过你的容器,来输出一个学生的数据或一个班/专业的学生数据.//基础要求



提高要求即是能够通过上面你构造的这个容器,然后输入学号就能够查询到这个同学的数据,并打印在屏幕上面

//优化那个的话,可以考虑通过建索引等方法...







