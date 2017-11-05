#  盒模型、定位、伪类

> 龚梅         **gongmei@redorock.team**

## CSS —— 盒模型（**标准盒模型和IE盒模型** ）

盒模型是CSS的基石之一，它指定HTML元素如何显示，页面上的每一个元素都可以看被看做一个矩形框，这个框由元素的内容（content）、内边距（padding）、边框（border）和外边距（margin）组成。

###  **标准盒模型：**

###### ![](./box.jpg)

### **IE盒模型： **（IE8以下版本）

![IE盒模型](box2.jpg)

* 从上图可以看到 IE盒模型的范围也包括 margin、border、padding、content，和标准盒模型不同的是：IE盒子模型的 content 部分包含了 border 和 padding。

  > 例：一个盒子的 margin: 20px; border: 1px; padding: 10px; width为 200px、height为 50px.
  >
  >  假如用标准盒模型解释，那么这个盒子需要占据的位置为：
  >
  > ​					宽 20 * 2 + 1 * 2 + 10 * 2 + 200 = 262px 
  >
  > ​					高 20 * 2 + 1 * 2 * 10 * 2 + 50 = 112px
  >
  > ​     盒子的实际大小为：宽 1 * 2 + 10 * 2 + 200 = 222px
  >
  > ​					高 1 * 2 + 10 * 2 + 50 = 72px；
  >
  > 假如用IE盒模型，那么这个盒子需要占据的位置为：
  >
  > ​					宽 20 * 2 + 200 = 240px
  >
  > ​					高 20 * 2 + 50 = 70px，
  >
  > ​     盒子的实际大小为：宽 200px、高 50px。

  公式：标准盒模型：**元素的width和height = content**

  ​	        IE盒模型：**元素的width和height = ( content + border + padding )**

* 内容区域

  * width（常用单位：px，em，%）
    * px ：像素
    * em：根据浏览器默认字体大小，浏览器默认font-size为16px，1em=16px，若父元素设置了font-size值，em会变化为1em=父元素font-size值
    * %：根据父元素的width、height而变化
  * height（同上）


* padding
  * padding: top    right    bottom    left;
  * padding: top    right&&left    bottom;
  * padding: top&&bottom    right&&left;
  * padding: top&&right&&bottom&&left;
  * padding-left(top, right, bottom)
* border（5种写法）
* margin （5种写法）
  * 可以设置负外边距（padding不可以！！）
  * 外边距叠加（BFC）（<a href="http://www.jianshu.com/p/acf76871d259">也许你们想看看BFC？</a>
    * 两个相邻的外边距都是正数时，折叠结果是它们两者之间较大的值。
    * 两个相邻的外边距都是负数时，折叠结果是两者绝对值的较大值。
    * 两个外边距一正一负时，折叠结果是两者的相加的和。
  * 百分数与外边距：百分数是相对于父元素的width计算的





## CSS —— display

display常用属性值：

| 值            | 描述                         |
| :----------- | :------------------------- |
| none         | 此元素不会被显示。                  |
| block        | 此元素将显示为块级元素，此元素前后会带有换行符。   |
| inline       | 默认。此元素会被显示为行内元素，元素前后没有换行符。 |
| inline-block | 行内块级元素。（CSS2.1 新增的值）       |
| inherit      | 规定应该从父元素继承 display 属性的值。   |

（还有一个很棒的属性值叫 “flex” ，是用来做弹性布局的，暂不讲，<a href="http://www.ruanyifeng.com/blog/2015/07/flex-grammar.html">这是一个介绍flex布局的链接 </a>

- 块级元素与行内元素那些事儿：
  - **块级元素可以设置width, height属性.**
  - **行内元素设置width,height属性无效，它的宽高主要根据内容决定.**
  - **块级元素即使设置了宽度, 仍然是独占一行.**
  - **块级元素可以设置margin和padding属性.**
  - **行内元素的margin和padding属性,水平方向的padding-left,padding-right,margin-left,margin- right都产生边距效果,但竖直方向的padding-top,padding-bottom,margin-top,margin-bottom却不 会产生边距效果**
- inline-block（可以让元素具有块级元素和行内元素的特性：既可以设置长宽，可以让padding和margin生效，又可以和其他行内元素并排





## CSS —— 定位

* CSS中有3种基本的定位机制：普通流、浮动和绝对定位。

  * 文档流
    * 将窗体自上而下分成一行行, 并在每行中按从左至右的顺序排放元素,即为文档流
    * 块级元素（block）独占一行，行内元素（inline）不独占一行，相邻的行内元素会排列在同一行里,直到一行排不下，才会换行，其宽度随元素的内容而变化

* CSS中的position

  * static（默认值）
  * absolute
    * 脱离文档流，元素本身所占的位置不会保留
  * relative
    *  没有脱离文档流的，所以元素本身所占的位置会保留，无论设置top等值
    *  ![](http://pic002.cnblogs.com/images/2012/407398/2012070915493457.jpg)
    *  父元素是否设置padding值对子元素设置的absolute和relative的起始位置的影响
  * fixed
  * inherit

  | 值        | 描述                                       |
  | -------- | ---------------------------------------- |
  | absolute | 生成绝对定位的元素，相对于 static 定位以外的第一个父元素进行定位。元素的位置通过 "left", "top", "right" 以及 "bottom" 属性进行规定。 |
  | fixed    | 生成绝对定位的元素，相对于浏览器窗口进行定位。元素的位置通过 "left", "top", "right" 以及 "bottom" 属性进行规定。 |
  | relative | 生成相对定位的元素，相对于其正常位置进行定位。因此，"left:20" 会向元素的 left 位置添加 20 像素。 |
  | static   | 默认值。没有定位，元素出现在正常的流中（忽略 top, bottom, left, right 或者 z-index 声明）。 |
  | inherit  | 规定应该从父元素继承 position 属性的值。                |

* 浮动






## CSS —— 伪类

CSS伪类是用来添加一些选择器的特殊效果。

伪类的语法：

```
selector:pseudo-class {property: value}
```

CSS 类也可与伪类搭配使用。

```
selector.class:pseudo-class {property: value}
```

举个例子：

> - a:link {color: #FF0000;} 		 */* 未访问的链接 /
> - a:visited {color: #00FF00;}           */* 已访问的链接 */*
> - a:hover {color: #FF00FF;}             */* 鼠标划过链接 */*
> - a:active {color: #0000FF;}            */* 已选中的链接 */*

| 选择器                                      | 示例                    | 示例说明                        |
| ---------------------------------------- | --------------------- | --------------------------- |
| [:checked](http://www.runoob.com/cssref/sel-checked.html) | input:checked         | 选择所有选中的表单元素                 |
| [:disabled](http://www.runoob.com/css/cssref/sel-disabled.html) | input:disabled        | 选择所有禁用的表单元素                 |
| [:empty](http://www.runoob.com/cssref/sel-empty.html) | p:empty               | 选择所有没有子元素的p元素               |
| [:enabled](http://www.runoob.com/cssref/sel-enable.html) | input:enabled         | 选择所有启用的表单元素                 |
| [:first-of-type](http://www.runoob.com/cssref/sel-first-of-type.html) | p:first-of-type       | 选择每个父元素是p元素的第一个p子元素         |
| [:in-range](http://www.runoob.com/cssref/sel-in-range.html) | input:in-range        | 选择元素指定范围内的值                 |
| [:invalid](http://www.runoob.com/cssref/sel-invalid.html) | input:invalid         | 选择所有无效的元素                   |
| [:last-child](http://www.runoob.com/cssref/sel-last-child.html) | p:last-child          | 选择所有p元素的最后一个子元素             |
| [:last-of-type](http://www.runoob.com/cssref/sel-last-of-type.html) | p:last-of-type        | 选择每个p元素是其母元素的最后一个p元素        |
| [:not(selector)](http://www.runoob.com/cssref/sel-not.html) | :not(p)               | 选择所有p以外的元素                  |
| [:nth-child(n)](http://www.runoob.com/cssref/sel-nth-child.html) | p:nth-child(2)        | 选择所有p元素的第二个子元素              |
| [:nth-last-child(n)](http://www.runoob.com/cssref/sel-nth-last-child.html) | p:nth-last-child(2)   | 选择所有p元素倒数的第二个子元素            |
| [:nth-last-of-type(n)](http://www.runoob.com/cssref/sel-nth-last-of-type.html) | p:nth-last-of-type(2) | 选择所有p元素倒数的第二个为p的子元素         |
| [:nth-of-type(n)](http://www.runoob.com/cssref/sel-nth-of-type.html) | p:nth-of-type(2)      | 选择所有p元素第二个为p的子元素            |
| [:only-of-type](http://www.runoob.com/cssref/sel-only-of-type.html) | p:only-of-type        | 选择所有仅有一个子元素为p的元素            |
| [:only-child](http://www.runoob.com/cssref/sel-only-child.html) | p:only-child          | 选择所有仅有一个子元素的p元素             |
| [:optional](http://www.runoob.com/cssref/sel-optional.html) | input:optional        | 选择没有"required"的元素属性         |
| [:out-of-range](http://www.runoob.com/cssref/sel-out-of-range.html) | input:out-of-range    | 选择指定范围以外的值的元素属性             |
| [:read-only](http://www.runoob.com/cssref/sel-read-only.html) | input:read-only       | 选择只读属性的元素属性                 |
| [:read-write](http://www.runoob.com/cssref/sel-read-write.html) | input:read-write      | 选择没有只读属性的元素属性               |
| [:required](http://www.runoob.com/cssref/sel-required.html) | input:required        | 选择有"required"属性指定的元素属性      |
| [:root](http://www.runoob.com/cssref/sel-root.html) | root                  | 选择文档的根元素                    |
| [:target](http://www.runoob.com/cssref/sel-target.html) | #news:target          | 选择当前活动#news元素(点击URL包含锚的名字)  |
| [:valid](http://www.runoob.com/cssref/sel-valid.html) | input:valid           | 选择所有有效值的属性                  |
| [:link](http://www.runoob.com/cssref/sel-link.html) | a:link                | 选择所有未访问链接                   |
| [:visited](http://www.runoob.com/cssref/sel-visited.html) | a:visited             | 选择所有访问过的链接                  |
| [:active](http://www.runoob.com/cssref/sel-active.html) | a:active              | 选择正在活动链接                    |
| [:hover](http://www.runoob.com/cssref/sel-hover.html) | a:hover               | 把鼠标放在链接上的状态                 |
| [:focus](http://www.runoob.com/cssref/sel-focus.html) | input:focus           | 选择元素输入后具有焦点                 |
| [:first-letter](http://www.runoob.com/cssref/sel-firstletter.html) | p:first-letter        | 选择每个<p> 元素的第一个字母            |
| [:first-line](http://www.runoob.com/cssref/sel-firstline.html) | p:first-line          | 选择每个<p> 元素的第一行              |
| [:first-child](http://www.runoob.com/cssref/sel-firstchild.html) | p:first-child         | 选择器匹配属于任意元素的第一个子元素的 <]p> 元素 |
| [:before](http://www.runoob.com/cssref/sel-before.html) | p:before              | 在每个<p>元素之前插入内容              |
| [:after](http://www.runoob.com/cssref/sel-after.html) | p:after               | 在每个<p>元素之后插入内容              |
| [:lang(*language*)](http://www.runoob.com/cssref/sel-lang.html) | p:lang(it)            | 为<p>元素的lang属性选择一个开始值        |



