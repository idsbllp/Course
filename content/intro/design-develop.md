# 关于Web

------

#### 1. 网页的前世今生(对于一个结构成熟的开发团队来说)

>  产品：挖取需求设计产品原型
&nbsp;产品交互逻辑
&nbsp;产品界面布局

![成绩查询产品原型1][1]

![成绩查询产品原型2][2]


> 视觉：界面美学设计
&nbsp;界面图层


![成绩查询视觉效果图1][3]

![成绩查询视觉效果图1][4]


> web：看不见的编码设计
&nbsp;将视觉的图变活，通过交互开发让它动起来
&nbsp;将产品的功能实现，通过逻辑开发让产品实际运行


```html
  <div class="content">
    <div class="error bk-error">
      <img src="./img/bkError.png" alt="">
      <p class="err-info1">您暂时还没有考试消息哦～</p></div>
    <div class="foot">
      <p class="copyright">©红岩网校&智慧教务</p></div>
  </div>
  <!-- 补考查询 -->
  <div class="content">
    <div class="error bk-error">
      <img src="./img/bkError.png" alt="">
      <p class="err-info1">您暂时还没有补考消息哦～</p></div>
    <div class="foot">
      <p class="copyright">©红岩网校&智慧教务</p></div>
  </div>
  <!-- 成绩查询 -->
  <div class="content">
    <div class="content-item score-item">
      <div class="class-name">高等数学A(下)</div>
      <div class="class-score exp-score">45</div>
      <div class="class-sort class-sort-exp">理论</div>
    </div>
    <div class="content-item score-item">
      <div class="class-name">C程序设计能力测评</div>
      <div class="class-score the-score">38</div>
      <div class="class-sort class-sort-the">实验</div>
    </div>
    <div class="foot">
      <p class="copyright">©红岩网校&智慧教务</p>
    </div>
  </div>
```


> 运维：项目部署上线

<iframe src="https://redrock.team/MagicLoop/index.php/addon/InquiryExam/InquiryExam/test?stuId=2015211535" width="587px" height="1035px" frameborder="0" scrolling="no"> </iframe>

> 产品：项目线上运营


#### 2. 我们扮演的角色是什么？

![网页设计师与开发师职能区别][5]

> 创意来自于团队中的每一位同学，在功能设计方面来说我们是角色定义是灵活的，但是我们总体是属于开发方向。可能对于大多数人来说，视觉与前端的定义有些模糊，但从他们的工作结果之间的联系区别来看，恰如“素材”与“PPT”

[招贤纳士][14]

![红岩网校工作招贤纳士][6]![红岩网校工作招贤纳士][7]

#### 3.前后端
> 前端：数据展示、页面交互

<iframe src="../../content/intro/d3/index.html" width="700px" height="600px" frameborder="0" scrolling="no"> </iframe>
<iframe src="http://hexgl.bkcore.com/play/" width="700x" height="600px" frameborder="0" scrolling="no"> </iframe>

> 后端：数据处理、功能逻辑
 
 [给iOS日历添上课表][10]

 ![课表信息接口][8]

###### 如何短时间内高效率地给参加线上线下报名的同学发送短信通知？
 
 ![后端逻辑][9] 

> 整合

###### 点击登录页面链接客户端服务端的基本处理过程
 ![从点击到显示][11] 
###### 登录页面 
 ![登录][12]
###### 登录的后端处理逻辑
 ![登录逻辑][13]  

  [1]: ../../content/intro/img/logic-product.png
  [2]: ../../content/intro/img/display-product.jpg
  [3]: ../../content/intro/img/display-view.png
  [4]: ../../content/intro/img/component-view.png
  [5]: ../../content/intro/img/design-develop.png
  [6]: ../../content/intro/img/joinus.png
  [7]: ../../content/intro/img/joinus2.gif
  [8]: ../../content/intro/img/courseTable.png
  [9]: ../../content/intro/img/message-backend.jpg
  [10]: https://www.zeroling.com/gei-ioszi-dai-ri-li-tian-jia-ke-cheng-biao/
  [11]: ../../content/intro/img/server.png
  [12]: ../../content/intro/img/login.png
  [13]: ../../content/intro/img/login-backend.png
  [14]: https://redrock.team/joinus2017/