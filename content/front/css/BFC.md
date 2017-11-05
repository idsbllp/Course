# HTML和CSS布局

> tianqiuyi@redrock.team

​                                                                  

## 文档流

文档流：将窗体 **自上而下** 分成一行一行,并在每行中按 **从左至右** 的挨次排放元素,即为文档流。有三种状况将使得元素离开文档流而存在,分别是 **浮动、绝对定位、固定定位.**



## 浮动 float

### float元素带来了哪些好处和坏处？

![img](http://upload-images.jianshu.io/upload_images/33455-4bfccb1bf0e77953.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

- **父元素塌陷**

  `````
  <div class="father">
      <div class="child1"></div>
      <div class="child2"></div>
  </div>

  .father{
      border: solid 2px;
      padding: 10px;
      width: 320px;
  }

  .child1,.child2{
       width: 100px;
       height: 100px;
       border: solid ;
       float: left;
  }
  `````

- **相邻元素错位**


``````
<div class="block1"></div>
<div class="block2"></div> 

.block1{
    width: 300px;
    height: 300px;
    background: black;
}

.block2{
    width: 300px;
    height: 300px;
    background: red;
}

``````



# BFC (Block formatting contexts)

#### [w3c规范中的BFC定义](http://www.w3.org/TR/CSS2/visuren.html#block-formatting)：

> 浮动元素和绝对定位元素，非块级盒子的块级容器（例如 inline-blocks, table-cells, 和 table-captions），以及overflow值不为“visiable”的块级盒子，都会为他们的内容创建新的BFC（块级格式上下文）。
>
> 在BFC中，盒子从顶端开始垂直地一个接一个地排列，两个盒子之间的垂直的间隙是由他们的margin 值所决定的。在一个BFC中，两个相邻的块级盒子的垂直外边距会产生折叠。
>
> 在BFC中，每一个盒子的左外边缘（margin-left）会触碰到容器的左边缘(border-left)（对于从右到左的格式来说，则触碰到右边缘）。

#### BFC的通俗理解：

​      请注意，BFC并不是一个css属性，也不是一段代码，而是css中基于box的一个布局对象，它是页面中的一块渲染区域，并且有一套渲染规则，它决定了其子元素将如何定位，以及和其他元素的关系和相互作用。明确地，它是一个独立的盒子，并且这个独立的盒子内部布局不受外界影响，当然，BFC也不会影响到外面的元素。

**什么时候会触发BFC呢？常见的如下：**

- `float`的值不为`none`。
- `overflow`的值为`auto`,`scroll`或`hidden`。
- `display`的值为`table-cell`, `table-caption`, `inline-block`中的任何一个。
- `position`的值不为`relative`和`static`。




# BFC能解决的问题

## 1.解决浮动带来的影响（清除浮动）

``````
overflow:hidden;
``````

要点：计算BFC高度的时候，浮动元素的高度也计算在内

PS：其他清除浮动的方法

- 添加新的元素 、应用 clear：both；

- after 方法（注意：作用于浮动元素的父亲）

  ``````
  .outer {zoom:1;}
  .outer :after {clear:both;content:'.';display:block;width: 0;height: 0;visibility:hidden;}
  ``````

  ​

## 2. 解决margin collapse(外边距叠加)

什么是外边距叠加？：

> 当**同一个BFC**中的两个盒子同时具有相对方向的外边距时，外边距会发生**叠加**(Margin Collapse)，当兄弟盒子的外边距不一样时，将以最大的那个外边距为准。

解决要点：

- 创建了 BFC 的元素不会和它的子元素发生外边距叠加
- 不同的BFC，他们之间的外边距将不会折叠

总的来讲，外边距叠加本身是由BFC引起的，但是现在我们要用BFC来解决这个问题，颇有点以毒攻毒的味道。



# 常见布局

## 1、单列布局

### 水平居中

**使用inline-block 和 text-align实现 **

```  
.parent{text-align: center;} 
.child{display: inline-block;}
```

优点：兼容性好；

不足：需要同时设置子元素和父元素

**使用margin:0 auto来实现**

```
.child{margin:0 auto;}
```

优点：兼容性好
缺点: 需要指定宽度

**使用绝对定位实现**

```
.parent{position:relative;}
.child {
    width: 150px;
    height: 150px;
    background: black;
    position: absolute;
    left:50%;
    top:50%;
    margin-left:-75px;
    margin-top:-75px;
}
```

## 2、多列布局

### 左列定宽，右列自适应

该布局方式非常常见，适用于定宽的一侧常为导航，自适应的一侧为内容的布局
![图片描述](http://img.mukewang.com/564c16cb00015c4603710131.png)

**利用float+margin实现**

```
.box1{float:left;width:100px;}
.box2{margin-left;margin-left:100px;}
```

### 两侧定宽，中栏自适应

![图片描述](http://img.mukewang.com/564c16f800017fab03750122.png)

**利用float+margin实现**

```
.left,.right{
    width: 100px;
    height: 100px;
    top: 0;
    position: absolute;
}

.left{
    left: 0;
    background: red;
}

.right{
    right: 0;
    background: red;
}

.center{
    margin: 0 100px;
    background: blue;
    height: 100px;
}
```
### 多列等分布局

多列等分布局常出现在内容中，多数为功能的，同阶级内容的并排显示等。

![图片描述](http://img.mukewang.com/564c17120001d2e403610142.png)

html结构如下所示

```
<div class="container">
    <div class="column">1</div>
    <div class="column">1</div>
    <div class="column">1</div>
    <div class="column">1</div>
</div>
```

CSS代码如下所示

``````
.container{
    width:100%;
}

.column{
    float: left;
    width:20%;
    height: 100px;
    margin-left: 5%;
}
``````

