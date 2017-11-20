# 前端上课#

##  [操作符](http://www.w3school.com.cn/js/js_operators.asp)

```
&& => 且
|| => 或
>= 大于等于
<= 小于等于
== 等于 
=== 严格等于
!= 不等于
!== 严格不等于
```

## [语句](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Guide/Loops_and_iteration)

```
if语句
var x = 10;
if(x > 20) { //满足条件执行
  console.log(123);
}else{
  console.log("no")
}

循环语句
while,do-while,for这三是常用的

//while语句
while (condition) {
  statement
}

//do-while语句
do
   statement
while (condition);

//for循环
for ([initialExpression]; [condition]; [incrementExpression])
  statement
  
break语句 //跳出switch语句或循环
return语句 //退出函数
continue //跳出当前这次循环遍历
```







## js中简单的几种数据结构##

#### 一、栈数据结构

后进先出，先进后出

![](http://upload-images.jianshu.io/upload_images/599584-b12fef30803a0c53.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)这种乒乓球z这种存放方式与栈中存取数据的方式如出一辙。处于盒子中最顶层的乒乓球5，它一定是最后被放进去，但可以最先被使用。而我们想要使用底层的乒乓球1，就必须将上面的4个乒乓球取出来，让乒乓球1处于盒子顶层。这就是栈空间先进后出，后进先出的特点。图中已经详细的表明了栈空间的存储原理。



#### 二、堆数据结构

知道名字就拿出来，对象知道key 得到 value，类似知道名字的到个人信息。  后面我会讲

#### 三、队列

在JavaScript中，理解队列数据结构的目的主要是为了清晰的明白事件循环（Event Loop）的机制到底是怎么回事。在后续的章节中我会详细分析事件循环机制。
队列是一种先进先出（FIFO）的数据结构。正如排队过安检一样，排在队伍前面的人一定是最先过检的人。用以下的图示可以清楚的理解队列的原理。

![](http://upload-images.jianshu.io/upload_images/599584-7ca4b641daf48c57.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

## 基本类型和引用类型##

### [基本类型](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Data_structures)###

undefined,null,number,boolean,string

```
var x; //这个时候x没有赋值，x就为undefined  undefined
var x = null; //x为空  null
var x = 123; //x为123 number
var x = true; //boolean
var x = "sadasd"; //string

检测数据的类型 typeof + 变量名
```



**特点**

1.值不会变

```
var name = "change";
name.substr();//hang
console.log(name);//change

```

或许有人会有以下的疑问，看代码：

```
var name = "change";
name = "change1";
console.log(name)//change1
```

这样看起来name的值“改变了”
其实，var name = "change"，这里的基础类型是string，也就是"change",这里的"change"是不可以改变的，name只是指向"change"的一个指针，指针的指向可以改变，所以你可以name = "change1".此时name指向了"change1"，同理，这里的"change1"同样不可以改变，也就是说这里你认为的改变只是“指针的指向改变”。

``` 
"change" <= name //name指向change
"change" //change还存在，只是说name不指向他了，所以说值不变
"change1" <= name //name变了是name的指向变了

name => 变量 
“change” => 这里才是我们说的数据，数据是这里，ok？
不要混淆了！！！
```



2.不可添加属性和方法

3. 基本数据类型的赋值是简单赋值

4.基本数据类型的比较是值的比较

5.基本数据类型是存放在栈区的

### **引用类型**

常见的引用类型  Object 、Array 、Function 、Date、RegExp

创建变量

*Object*

```
var obj = {};
var obj = new Object();
```

*Array*

```
var arr = new Array();
var arr = [];
```

Function

```
var fn = function(x,y) {};
function fn(x,y){};
```

...等，这些菜鸟教程有的自己下去看。

-

说到引用类型我们先来看一下引用数据类型与堆内存

```
//基本类型，指向栈空间
var a1 = 0;   // 变量对象
var a2 = 'this is string'; // 变量对象
var a3 = null; // 变量对象

//引用类型，指向堆空间
var b = { m: 20 }; // 变量b存在于变量对象中，{m: 20} 作为对象存在于堆内存中
var c = [1, 2, 3]; // 变量c存在于变量对象中，[1, 2, 3] 作为对象存在于堆内存中
```

![O](http://upload-images.jianshu.io/upload_images/599584-8e93616d7afcf811.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

因此当我们要访问堆内存中的引用数据类型时，实际上我们首先是从变量对象中获取了该对象的地址引用（或者地址指针），然后再从堆内存中取得我们需要的数据。

理解了JS的内存空间，我们就可以借助内存空间的特性来验证一下引用类型的一些特点了。

我们再来看一个例子

```
　　var obj1 = new Object();

　　var obj2 = obj1;

　　obj2.name = "我有名字了";

　　console.log(obj1.name); // 我有名字了
```

![](http://upload-images.jianshu.io/upload_images/5704367-ec4e9a043c4605bf.PNG?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
从这个例子我们可以看出，引用数据类型的值是可以改变的，开始我们创建了obj1，再把obj2指向obj1，我们可以看出他传递的只是一个引用，obj1，obj2都可以改变这个引用的值。

## Function函数

这里才是重点，前面只是给你们梳理一下概念。

##### 函数的声明

```
//变量提升
function fun(){
      console.log(num); //undefined
      var num = 20;
}
相当于 ---
function fun(){
      var num;
      console.log(num);
      Num = 20;
}
//变量提升就是变量声明跑到作用域顶部。

//再来看一看函数声明

一般来说有下面两种
var fn = function() {};
function fn() {};
其中fn是变量名，这两种有什么区别呢？这里就涉及到了刚刚所说的变量提升了

我们来看看下面的两个例子
fn();
function fn() {console.log(123)}; 
//123
fn && fn();
var fn = function() {console.log(213)}; 
//什么都不执行


第一种情况，声明和定义是一体的，可以理解为fn的定义和定义一起跑到了作用域顶部
而第二种情况，只会声明跑到顶部
```

##### 函数的定义

```
function abs(x) {
    if (x >= 0) {
        return x;
    } else {
        return -x;
    }
}
```

- `function`指出这是一个函数定义；
- `abs`是函数的名称；
- `(x)`括号内列出函数的参数，多个参数以`,`分隔；
- `{ ... }`之间的代码是函数体，可以包含若干语句，甚至可以没有任何语句。

###### 第二种方法

```
var abs = function (x) {
    if (x >= 0) {
        return x;
    } else {
        return -x;
    }
};
```

在这种方式下，`function (x) { ... }`是一个匿名函数，它没有函数名。
但是，这个匿名函数赋值给了变量`abs`，所以，通过变量`abs`就可以调用该函数。

##### 函数的调用

```
abs(10); // 返回10
abs(-9); // 返回9
```

###### 第三种方式

```
var abs = new Function("var x = 10; console.log(x)")
abs();
```

这种使用了Function关键字声明，不常用，知道就行

##### $arguments$

JavaScript还有一个免费赠送的关键字`arguments`，它只在函数内部起作用，
并且永远指向当前函数的调用者传入的所有参数。`arguments`类似`Array`但它不是一个

```
function foo(x) {
    alert(x); // 10
    for (var i=0; i<arguments.length; i++) {
        alert(arguments[i]); // 10, 20, 30
    }
}
foo(10, 20, 30);//这里的话arguments = [10,20,30]，不过这里是类数组 
```

##### $rest$参数

```
function watchArg(a,b,...c) {
  console.log(c);
}

watchArg(1,2,3,4,5); //[3,4,5]
c就是rest参数 而且c是一个数组
```

##### return语句

遇到return语句函数就结束了，而且返回一个值,后面的语句不会再继续执行

```
function psx() {
	return {
		name: "zbl"
	};
	console.log('zz');
}
psx();
```

### 作用域

##### 全局作用域 => (可以理解为不是函数作用域就是全局作用域)

```
var name = 'psx';
var age = 20;
var hobby = "study";
//前面的变量就是在全局作用域，为全局变量
```

##### 函数作用域

```
function foo() {
  var x = 1;
  x = x + 1;
}
console.log(x);
//现在的变量就是在函数作用域，为局部变量
//全局无法访问局部变量,也就是作用域外不能访问作用域内

//函数还可以嵌套
function sayHi() {
  console.log("hi");
}
function hh() {
  function bar() {
    console.log('in bar');
  }
  sayHi();
}

bar(); //error
//作用域外不可以访问作用域内，作用域内可以访问作用域外
```

##### 内部和外部变量冲突问题

------

```
function foo() {
  console.log("global");
}
function bar() {
  function foo() {
    console.log("inner");
  }
  foo();
}
bar(); //inner 
```

当内部变量和外部变量冲突的时候，内部变量会覆盖外部变量

##### 作用域上下文

```
var color = 'blue';

function changeColor() {
    var anotherColor = 'red';

    function swapColors() {
        var tempColor = anotherColor;
        anotherColor = color;
        color = tempColor;
    }

    swapColors();
}

changeColor();
```

 ![](http://upload-images.jianshu.io/upload_images/599584-58d31e5b80737ca0.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

之前我们说过栈，根据上面的图我们可以知道swapColors最后入栈，所以它最先执行。大概的执行上下文就是这样。

## 构造函数

```
应该大家都看过(我前面也写了)，声明函数有两种方式
var obj - {};
var obj = new Object();

声明数组的方式也有两种

var arr = [];
var arr = new Array();
  
```

看到这里，你们应该会很懵逼.......

new 是什么? 函数不是用来调用的吗？ Exo  me？

懵逼也很正常。233333.

javascript这门语言在设计的时候没有类（class）这种说法，new + 函数名 = 构造函数，而构造函数和我们平时用的类差不多，现在es6已经有了类，不过es6没有普及，所以构造函数还是很重要滴。

#### 构造函数是用来创造对象的

构造函数的首字母应该大写,方便我们区分是构造函数还是普通函数

```javascript
function Person(name,age) {
  //特权属性（公有属性）
  this.name = name;
  this.age = age;
  //私有属性
  var hobby = "study";
  var that = this;
  //私有方法
  function sayName() {
	 console.log("llp");
  }
  //特权方法(公有方法)
  this.sayAge = function() {
      console.log(this.age);
  }
}
var llp = new Person("llp",5);
console.log(llp);

现在我们可以发现llp是一个对象，拥有name，age属，sayAge方法
//私有属性，私有方法 就是只有Person函数才有的，实例没有(llp)就没有
//公有方法，公有属性 实例也会继承它
```

##### 原型链



## 数组##

```
常见的两种数组声明方式
var arr = [];
var arr = new Array();

//当然 我们也可以在声明的时候赋值

var arr = [1,2,3,4,5];
var arr = new Array(1,2,3,4,5); //不推荐,别问我为什么

var a = ["world"];     // 从一个元素的数组开始
var value = a[0];      // 读第0个元素
a[1] = 3.14;           // 写第1个元素
var i = 2; 
a[i] = 3;              // 写第2个元素
a[i + 1] = "hello";    // 写第3个元素
a[a[i]] = a[0];        // 读第0个和第2个元素，写第3个元素
console.log(a);

//访问和赋值

//数组的长度
var arr = [1,2,3,4,5]
console.log(arr.length);

//数组的实质其实是对象
我们访问数组就是a[0] = 10,a[1]这种样子
1 => key
10 => value
```

