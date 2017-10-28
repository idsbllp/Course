# 设计与开发

------

## 网页设计师还是网页开发师？
#### 1. 网页的前世今生(对于一个结构成熟的开发团队来说)

>  产品：挖取需求设计产品原型
&nbsp;产品交互逻辑
&nbsp;产品界面布局

![成绩查询产品原型1][1]

![成绩查询产品原型2][2]


> 视觉：界面视觉或美学设计
&nbsp;界面图层


![成绩查询视觉效果图1][3]

![成绩查询视觉效果图1][4]


> web：看不见的编码设计
&nbsp;将视觉的图变活，通过交互开发让它动起来
&nbsp;将产品的功能实现，通过逻辑开发让产品实际运行


```html
  <div class="content">
    <div class="error bk-error">
      <img src="/MagicLoop/Addons/InquiryExam/View/default/Public/img/bkError.png" alt="">
      <p class="err-info1">您暂时还没有考试消息哦～</p></div>
    <div class="foot">
      <p class="copyright">©红岩网校&智慧教务</p></div>
  </div>
  <!-- 补考查询 -->
  <div class="content">
    <div class="error bk-error">
      <img src="/MagicLoop/Addons/InquiryExam/View/default/Public/img/bkError.png" alt="">
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

<iframe src="http://wx.idsbllp.cn/MagicLoop/index.php/addon/InquiryExam/InquiryExam/test?stuId=2015211535" width="587px" height="1035px" frameborder="0" scrolling="no"> </iframe>

> 产品：项目线上运营


#### 2. 我们扮演的角色是什么？

![网页设计师与开发师职能区别][6]

> 创意来自于团队中的每一位同学，在功能设计方面来说我们是角色定义是灵活的，但是在视觉设计与产品开发上是明确定义了的，我们属于开发方向。

> 视觉与前端的联系区别：请自行脑补 图片素材 与 PPT 的联系区别

![红岩网校工作招贤纳士][7]<iframe src="http://wx.idsbllp.cn/joinus2017/" width="320px" height="569px" frameborder="0" scrolling="no"> </iframe>

  [1]: ../../content/intro/img/logic-product.png
  [2]: ../../content/intro/img/display-product.jpg
  [3]: ../../content/intro/img/display-view.png
  [4]: ../../content/intro/img/component-view.png
  [5]: ../../content/intro/img/html-web.png
  [6]: ../../content/intro/img/design-develop.png
  [7]: ../../content/intro/img/joinus.png
  [8]: ../../content/intro/img/joinus2.gif
  [9]: https://wx.idsbllp.cn/joinus2017/?ref=activity