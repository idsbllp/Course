### 面向对象简介

- 什么是面向对象

  -  世界的每一个具体事物都可以看成是一个对象。把某些对象的相同的属性和行为特性集合起来构成一个抽象概念叫做类。比如人类，人都有五官，四肢，都能直立行走，会独立思考。这些特性把人和别的物种区分开来。其中，五官和四肢是人的属性的一部分，行走和思考是人的行为特性。人类只是一个抽象的概念，它并不对应具体的物体。而真实存在的某个人，比如张三、李四，才是可以称作是一个对象。

    ​


- 什么是类
    - 一个类可以被定义为描述行为的模板

- 什么是对象
    - 任何具有状态和行为的实体都称为对象。 例如：椅子，钢笔，桌子，键盘，自行车等。它可以是物理和逻辑的。

- 类和对象的关系
    - 类与对象的关系就如模具和铸件的关系，类的实例化的结果就是对象，而对对象的抽象就是类，类描述了一组有相同特性（属性）和相同行为的对象。
- 面向对象包括哪些特征
    - 对象
    - 类
    - 继承
    - 多态性
    - 抽象
    - 封装

---

### 数据类型
- 数据类型
    - 基本类型
        - byte
        - short
        - int
        - long
        - float
        - double
        - boolean
        - char

        - 类型转换
            - 隐式转换
                ```java
                隐式转换

                特征：
                从小到大，可以隐式转换，数据类型将自动提升。
                byte,short,char -->int-->long-->float-->double
                例 :
                byte a=10;
                int b = a;
                当编译int b = a 时，
                a隐式转换为int类型。jvm帮我们自动提升了变量类型
                ```

            - 强制转换

                ```
                特征:
                从大到小（如果你明确知道数据是可以用该数据类型来表示的，可以用强制转换）
                格式：
                int a = 1;
                byte b = (byte)a;
                （转换后的数据类型）变量或者值。
                注：一般情况下，根本不推荐使用强制类型转换,因为会造成精度损失。
                ```

                ​

            - 运算

                ```java
                整型、实型（常量）、字符型数据可以混合运算。
                运算中，不同类型的数据先转化为同一类型，然后进行运算。

                int a = 1;
                byte b = 2;
                int c = a * b;
                这里进行a * b运算的时候先把b转换成int类型然后在进行运算 
                具体转换到那种类型根据表达式里面最大的数据类型来决定
                比如 
                double d = 1.0;
                double c = d * a * b;
                那么a b 被提升成double类型
                ```

    ----

    - 引用类型

      - 在Java中，引用类型的变量非常类似于C/C++的指针。引用类型指向一个对象，指向对象的变量是引用变量。这些变量在声明时被指定为一个特定的类型，比如Employee、Puppy 等。

        ```java
        例如:
        Example exampl = new Example();
        new Example().
        这里new Example()代表一个类实例化变成对象
        而=在JAVA中代表赋值操作
        把实例化的对象交给一个Example类型名字为example的一个引用(变量名)来操作
        ```

        - 特例

          String是一种引用类型

    - 对象、数组都是引用数据类型。

    - 所有引用类型的默认值都是null。

    - 一个引用变量可以用来引用与任何与之兼容的类型。

- 数据类型转换必须满足如下规则：

    - 不能对boolean类型进行类型转换。
    - 不能把对象类型转换成不相关类的对象。   
    - 在把容量大的类型转换为容量小的类型时必须使用强制类型转换。
    - 转换过程中可能导致溢出或损失精度，例如：

    ```java
     int i =128;   
     byte b = (byte)i;
     byte 能存储长度是-128 ---- 127 造成精度损失
    ```

    ​

---



- 连接符
```java
+是java中的连接符,如果+前后是一个非String的基本数据类型 代表的是执行加操作
int a = 1;
int b = 2;
System.out.println(a+b);
打印结果是3
如果+前后有字符串类型那么这个+ 代表的是连接操作
int a = 1;
String b = "123";
System.out.println(a+b);
打印结果是1123;
```

---

### 面向对象

- 类(class)
    - 以类作为构造程序的基本单位。
        ```java
        class A{
            属性
            方法
        }

        //每一个文件必须要包含一个与文件名相同的public class
        //一个.java文件可以包含若干个class

        public class StudentUser{
            ....
              String stuName
              void getUse(){}
        }

        class B{
            ....
        }

        class C{
            ....
        }
        ```
    - Java中的类可以包含：
        - 字段
        - 方法
        - 构造函数
        - 代码块
        - 嵌套类和接口

    ​
- 对象
  对象是类实例化的表现,new Student()就是把Student这个类实例化一个对象

- 引用
```java
为了操作方便我们把new出来的对象赋值给一个引用,
Student stu = new Student();
stu便是一个引用，刚刚被new出来的对象复制给了它，我们可以操作stu去执行一些方法或者其他操作
例如
stu.get();
stu.i = 1;
```
- 代码块
```java
用一对花括号括起来
class A{
    int b = 0;
    
    void get(int b){
        int a =1;
    }
    
    //代码块
    {
        int a = 1;
    }    
}
    
```

- - -
- 成员变量和局部变量
    - 成员变量：在类体中变量定义部分所声明的变量为类的成员变量
        - 实例变量(无static修饰的变量)

        - 类变量(有static修饰的变量)

        ```java
        class A{
            int a;
            static int b;
        }
        a是实例变量 static修饰了b b叫做类变量
        实例变量属于对象所有,而类变量属于类所有，对所有对象是共享的

        实例变量调用举例
        A aA = new A();
        aA.a
        类变量调用举例
        A.b
        aA.b
        一般常用第一种
        ```
    - 局部变量
        - 方法体里定义的变量
        - 形式参数
        - 在代码块定义的变量



---

this

- this表示的是“调用方法的那个对象”的引用

- this关键字只能在方法内部调用

- 只有需要明确指出对当前对象的引用时，才需要使用this

- 如果在方法内部调用同一个类的另一个方法时，直接调用即可，不必使用this

- 举个例子

  ```java
  public class TestThis {
      public static void main(String[] args) {
          Banana a = new Banana();
          Banana b = new Banana();
          a.peel("a").peel("a1");
          b.peel("b").anotherPeel();
          Banana c = new Banana();
  //        c.anotherPeel().peel();

          a.poll(b);
          a.poll(a);
      }
  }
  class Banana{
      Banana peel(String name){
          System.out.println(name);
          //哪个引用调用 就返回哪个引用
          return this;
      }

      void anotherPeel(){
          System.out.println("anotherPeel");
      }

      void poll(Banana banana){
          System.out.println(this == banana);
      }

  }
  ```

  ​

---



权限修饰符

- 用来修饰类、成员变量、方法

- public

  -  public可以修饰类，数据成员，构造方法，方法成员。被public修饰的成员，可以在任何一个类中被调用，不管同包或不同包，是权限最大的一个修饰符。

- protected

  - 被protected修饰的成员，能在定义它们的类中、同包的类中被调用。如果有不同包的类想调用它们，那么这个类必须是定义它们的类的子类

- private

  - private可以修饰数据成员，构造方法，方法成员，不能修饰类（此处指外部类，不考虑内部类）。被private修饰的成员，只能在定义它们的类中使用，在其他类中不能调用。

- default

  - 类，数据成员，构造方法，方法成员，都能够使用默认权限，即不写任何关键字。默认权限即同包权限，同包权限的元素只能在定义它们的类中，以及同包的类中被调用。
  - 例如定义一个方法

  ```java
  int getInt(){
      
  }
  ```

- 权限修饰符图示

```java
访问权限   类   包  子类  其他包

public     ∨   ∨   ∨     ∨

protected    ∨   ∨   ∨     ×

default    ∨   ∨   ×     ×

private    ∨   ×   ×     ×
```

- 权限修饰符作用
  - 隐藏不希望别人看到或者去操作你的方法或者变量
  - 一般类使用 public 和默认修饰符,不使用private protected 
  - 使用默认修饰符修饰类的话，要确保调用者和被调用者在同一个包下调用
  - 正常开发流程下，一个.java文件里只有一个类，这个类会用public修饰



---





- 封装

    ​

    - 封装可以被认为是一个保护屏障，防止该类的代码和数据被外部类定义的代码随机访问。

      ​

    - 封装可以让使用者更加方便，我们将复杂的代码封装起来，只提供一个外部接口，告诉调用者，你使用这个结果就会得到相应的结果，而那些复杂的代码不向外部暴露。

      - 好比一辆车的油门，我们使用者不需要去知道这个友们是怎么加速的，加速的复杂实现是由汽车厂家帮我们实现的，他们吧这个功能最后以油门的形式暴露给我们，我们只需要使用油门就可以去加速了。

    - 适当的封装可以让程式码更容易理解与维护，也加强了程式码的安全性。

      ​

    - 封装步骤

      - 修改属性的可见性来限制对属性的访问（一般限制为private），例如：

        ```java
        public class Person {
            private String name;
            private int age;
        }
        这段代码中，将 name 和 age 属性设置为私有的，只能本类才能访问，其他类都访问不了，如此就对信息进行了隐藏。
        ```

        ​

      - 对每个值属性提供对外的公共方法访问，也就是创建一对赋取值方法，用于对私有属性的访问，例如：

        ```java
        public class Person{
            private String name;
            private int age;
            
            public int getAge(){
              return age;
            }

            public String getName(){
              return name;
            }

            public void setAge(int age){
              this.age = age;
            }

            public void setName(String name){
              this.name = name;
            }
        }

        以上实例中public方法是外部类访问该类成员变量的入口。
        通常情况下，这些方法被称为getter和setter方法。
        因此，任何要访问类中私有成员变量的类都要通过这些getter和setter方法。

        采用 this 关键字是为了解决实例变量（private String name）和局部变量（setName(String name)中的name变量）之间发生的同名的冲突。
        ```

        ​

    ​

---



- 构造方法
    - 构造函数是一种特殊的函数。其主要功能是用来在创建对象时初始化对象， 即为对象成员变量赋初始值，总与new运算符一起使用在创建对象的语句中。构造函数与类名相同，可重载多个不同的构造函数。
    ```java
    public class A{  
       public A(){  
          System.out.println("调用了无参的构造函数");  
       }  
       public A(String mess){  
          System.out.println("调用了有参的构造函数\n"+  
             "参数内容为："+mess);  
       }  
    }  
    ```
    - 构造器必须与类同名

    - 每个类可以有一个以上的构造器

    - 如果不写构造器编译器会自动为我们默默的添加一个无参构造器
      如果写了构造器编译器就不会默默添加了

    - 构造器可以有0个、1个或1个以上的参数

    - 构造器没有返回值

    - 构造器总是伴随着new操作一起调用

      ​

---



- 重载
    - 用同一个方法名写出几个功能不同的方法
        ```java
        比如我想写一个洗衣服的方法
        void clean(){
            
        }
        然而我又想写一个谁在洗衣服的方法
        int clean(){
            ....
        }
        void clean(int name){
            ....
        }
        void clean(String name,int a){
            ....
        }
        void clean(int i,String name){
            ....
        }
        ```

    - 对一个方法重载，重载方法要和这个方法的名字保持一致

    - 重载可以发生在构造器上，也可以发生在普通方法上

    - 好处：使得代码更加简洁，优美 

    - 如何区分重载
        - 参数类型
        - 参数个数
        - 参数顺序

    - 返回值和形参名不能作为判断重载的标志

        ​





---



- static
    - static意思是全局的

      ​

    - static修饰的变量属于类而不属于对象,这个变量是这个类实例化出来的所有对象所共享的

      ​

    - static方法内不能直接调用其它的非静态方法，除非把引用当作参数传入,或者直接在方法体内部实例化一个对象，点调用的方式进行

      ​

    - static 方法体内也不能直接调用非静态成员变量

      ​

    - 无论实例化多少对象,该类体内用static修饰的变量只会在第一次类加载的时候初始化

      ​

    - 实质：![image](C:\Users\win8.1\Pictures\redrock_lesson\refence.png)


------



- 继承
    - 继承就是子类继承父类的特征和行为，使得子类对象（实例）具有父类的实例域和方法，或子类从父类继承方法，使得子类具有父类相同的行为。

        ​

    - 所有类默认继承了类Object 这个类是Java中的超类,是所有类的父类

        ​

    - 关键字 extends

        ​

    - 继承后子类具有父类当中的属性和方法，子类就不会存在重复的代码，维护性也提高，代码也更加简洁，提高代码的复用性。

        ​

    - 继承的特性
        - 类的继承是单一继承，也就是说，一个子类只能拥有一个父类，所以extends 只能继承一个类。

          ​

        - 子类拥有父类非private的属性，方法。

          ​

        - 子类可以拥有自己的属性和方法，即子类可以对父类进行扩展。

          ​

        - 子类可以用自己的方式实现父类的方法即重写。

          ​

        - Java的继承是单继承，但是可以多重继承，利用接口方式。
---



重写

- 有时子类并不想原封不动地继承父类的方法，而是想作一定的修改，这就需要采用方法的重写。方法-重写又称方法覆盖。

  ​

- 重写需要返回值、方法名、参数列表保持一致

  ​

- 重写时访问权限不能比父类中被重写的方法的访问权限更低。例如：如果父类的一个方法被声明为public，那么在子类中重写该方法就不能声明为protected。否则子类中的重写就并不是重写了，而是写了一个新的方法。



---



- super
    - super关键字：我们可以通过super关键字来实现对父类成员的访问,用super()或者super(参数)来调用父类的构造器,用super. 的形式来调用父类的变量或方法。

        ​

    - super与构造器
        - 子类不能继承父类的构造器（构造方法或者构造函数），但是父类的构造器带有参数的，则必须在子类的构造器中显式地通过super关键字调用父类的构造器并配以适当的参数列表。
---



final

- 最终的,不可变的。

  ​

- final关键字可以用于成员变量、局部变量、代码块、方法以及类。

  ​

- 凡是对成员变量声明为final的都叫作final变量。final变量经常和static关键字一起使用，作为常量。

  ​

- 你不能够对final变量再次赋值。

  ​

- final成员变量必须在声明的时候初始化或者在构造器中初始化，否则就会报编译错误。

  ​

- final 关键字声明类可以把类定义为不能继承的，即最终类；或者用于修饰方法，该方法不能被子类重写。

  ​

- final也可以声明方法。方法前面加上final关键字，代表这个方法不可以被子类的方法重写。如果你认为一个方法的功能已经足够完整了，子类中不需要改变的话，你可以声明此方法为final。



---





- 多态

    - 了解多态前先知道什么是向上转型

      ​

    - 向上转型

      - 子类引用的对象转换为父类类型称为向上转型。通俗地说就是是将子类对象转为父类对象。此处父类对象可以是接口。

        ```java
        class A{
            
        }
        class B extends A{
            
        }

        A a = new B();
        B被向上转型为A类型
        ```

      - 向上转型的好处

        - 减少重复代码，使代码变得简洁,提高系统扩展性。

        - 举个栗子

          ```java
          假如我们有一只乐队的乐手类
          我们创建了吉他手 贝斯手 让他们都继承乐手类
          他们都重写了演奏方法

          public class BandPlayer {
          //乐队有演奏方法
              public void play(){}
          }

          //吉他手类
          class GuitarPlayer extends BandPlayer{
              @Override
              public void play() {
                  System.out.println("吉他手演奏");
              }
          }
          //贝斯手类
          class BassPlayer extends BandPlayer{
              @Override
              public void play() {
                  System.out.println("贝司手演奏");
              }
          }

          class Play{
              void play(GuitarPlayer guitarPlayer){
                  guitarPlayer.play();
              }
              void play(BassPlayer bassPlayer){
                  bassPlayer.play();
              }
              //如果此时再加入个主唱,是不是我们要在为主唱添加一个演奏方法
              void play(Singer singer){
                  singer.play();
              }
              //如果有再多的人员加入乐队,就要添加更多的方法很麻烦
              
              //此时我们写一个万能方法 我们尝试把参数类型缩小到这几个乐手的基类类型
              
              //如果传进来的子类能被父类的参数所接受 那这可太有意思了
              //这说明子类是一种特殊的父类
              void play(BandPlayer bandPlayer){
                  bandPlayer.play();
                }
              public static void main(String[] args) {
                  GuitarPlayer guitarPlayer = new GuitarPlayer();
                  guitarPlayer.play();
                  BassPlayer bassPlayer = new BassPlayer();
                  bassPlayer.play();
                  Singer singer = new Singer();
                  singer.play();
          		
                  //现在使用向上转型
                  Play plays = new Play();
                  BandPlayer guitarPlayer = new GuitarPlayer();
                  BandPlayer bassPlayer = new BassPlayer();
                  BandPlayer singer = new Singer();
                  plays.play(guitarPlayer);
                  plays.play(bassPlayer);
                  plays.play(singer);

              }
          }
          ```

      - 必备条件

        - 必须要有继承

        - 父类引用指向子类对象

          ​

      - 注意

        - 向上转型会窄化对象,即如果子类里面有不同于父类的方法，向上转型后不能调用子类里面那个不同于父类的方法

          ​



- 再看多态

  ​

  - 指允许不同类的对象对同一消息做出响应。即同一消息可以根据发送对象的不同而采用多种不同的行为方式。（发送消息就是函数调用）

    ​

  - 如何确定出现了多态（三者缺一不可）

    - 要有继承

      ​

    - 父类的引用指向子类的对象

      ​

    - 子类重写了父类的方法  

      ​

    - 例子

      ```java
       public class Father{
                    public void eat(){
                        System.out.println("father在吃饭");
                    }
                    public void playBass(){
                        System.out.println("father在弹bass");
                    }
                }
             class Child extends Father{
               public void eat(){
                        System.out.println("child在吃饭");
                    }

                    public void dance(){
                        System.out.println("child在跳舞");
                    }
                }
             class Child2 extends Father{
                public void eat(){
                        System.out.println("child2在吃饭");
                    }

                    public void sing(){
                        System.out.println("child2在唱歌");
                    }

                }

                class Test{
                    public static void main(String args[]){
                        Father father = new Child();
                        father.eat();
                        father.playBass();

                        father = new Child2();
                        father.eat();

                    }
                }
      这里引用father指向不同的对象(Child Child2),调用同一个方法却能得到不同的响应,这就是一种多态
      ```

      ​

- 补充下JAVA中引用变量在不同时期的不同状态

    ​

    - 编译时类型，由声明该变量时使用的类型决定；

      ```
      Father father;
      father编译时的类型是Father
      ```

      ​


    - 运行时类型，由实际赋给该变量的对象决定；

      ```
      father = new Child();
      运行时father类型是Child类型
      ```

      ​

    - 在编译时类型与运行时类型**不一致**时，就可能出现——多态

      ​

    - 多态的实现

      - 动态绑定

        - 父类引用指向的子类对象不能再编译时期确定,只能程序跑起来的时候才知道指向了哪个子类对象。
        - 这时调用方法的话，父类会根据实际指向的对象来调用那个对象里面的方法。

    - 注意

      - 当父类引用变量指向子类对象时，被引用对象的类型决定了调用谁的成员方法，引用变量类型决定可调用的方法。如果子类中没有覆盖该方法，那么会去父类中寻找。

      ​



---



### 抽象类

- 在面向对象的概念中，所有的对象都是通过类来描绘的，但是反过来，并不是所有的类都是用来描绘对象的，如果一个类中没有包含足够的信息来描绘一个具体的对象，这样的类就是抽象类。

- 抽象类除了不能实例化对象之外，类的其它功能依然存在，成员变量、成员方法和构造方法的访问方式和普通类一样。

  ```java
  public abstract class Employee
  {
      private String name;
      private String address;
      private int number;
    
      public Employee(String name, String address, int number)
      {
          System.out.println("Constructing an Employee");
          this.name = name;
          this.address = address;
          this.number = number;
      }
    
    
      public double computePay()
      {
          System.out.println("Inside Employee computePay");
          return 0.0;
      }
    
    
      public void mailCheck()
      {
          System.out.println("Mailing a check to " + this.name
                  + " " + this.address);
      }
    
    
      public String toString()
      {
          return name + " " + address + " " + number;
      }
    
    
      public String getName()
      {
          return name;
      }
      public String getAddress()
      {
          return address;
      }
      public void setAddress(String newAddress)
      {
          address = newAddress;
      }
      public int getNumber()
      {
          return number;
      }


  }
  注意到该Employee类没有什么不同，尽管该类是抽象类，但是它仍然有3个成员变量，7个成员方法和1个构造方法。
  ```

  ```java
  public class AbstractDemo
  {
     public static void main(String [] args)
     {
        /* 以下是不允许的，会引发错误 */
        Employee e = new Employee("George W.", "Houston, TX", 43);
   
        System.out.println("\n Call mailCheck using Employee reference--");
        e.computePay();
      }
  }
  ```

  ​

- 由于抽象类不能实例化对象，所以抽象类必须被继承，才能被使用。也是因为这个原因，通常在设计阶段决定要不要设计抽象类。

  ​


- 继承抽象类

  ```java
  public class Salary extends Employee
  {
     private double salary; //Annual salary
     public Salary(String name, String address, int number, doublesalary)
     {
         super(name, address, number);
         setSalary(salary);
     }
     
     public double computePay()
     {
        System.out.println("Computing salary pay for " + name);
        return salary/52;
     }
  }
  尽管我们不能实例化一个Employee类的对象，但是如果我们实例化一个Salary类对象，该对象将从 Employee 类继承7个成员方法，且通过该方法可以设置或获取三个成员变量。
  class AbstractDemo
  {
     public static void main(String [] args)
     {
       
        Employee e = new Salary("John Adams", "Boston, MA", 2, 2400.00);

      }
  }
  ```

  ​

- 抽象方法

  - abstract关键字同样可以用来声明抽象方法，抽象方法只包含一个方法名，而没有方法体。

    ```java
    public abstract class Employee
    {
      
      
       public abstract double computePay();
      
       public void get(){
         
       }
       
       //其余代码
    }
    ```

  - 如果一个类包含抽象方法，那么该类必须是抽象类。

    ​

  - 任何子类必须重写父类的抽象方法，或者声明自身为抽象类。

  ​

- 抽象类总结

  -  抽象类不能被实例化(初学者很容易犯的错)，如果被实例化，就会报错，编译无法通过。只有抽象类的非抽象子类可以创建对象。

    ​

  - 抽象类中不一定包含抽象方法，但是有抽象方法的类必定是抽象类。

    ​

  - 抽象类中的抽象方法只是声明，不包含方法体，就是不给出方法的具体实现也就是方法的具体功能。

    ​

  - 构造方法，类方法（用static修饰的方法）不能声明为抽象方法。

    ​

  - 抽象类的子类必须给出抽象类中的抽象方法的具体实现，除非该子类也是抽象类。



---



### 接口

- 定义

  - 接口（英文：Interface），在JAVA编程语言中是一个抽象类型，是抽象方法的集合，接口通常以interface来声明。一个类通过继承接口的方式，从而来继承接口的抽象方法。

    ​

  - 接口并不是类，编写接口的方式和类很相似，但是它们属于不同的概念。

    ​

- 接口和类的相似点


  - 一个接口可以有多个方法。

    ​

  - 接口文件保存在 .java 结尾的文件中，文件名使用接口名。

    ​

- 接口和类的区别

  - 接口不能用于实例化对象。

    ```
    interface Student{
    }

    Student stu = new Student();这种操作是不允许的
    ```

  - 接口没有构造方法。

    ​

  - 接口中所有的方法必须是抽象方法。

    ```
    interface Student {

        public void get();

    }
    即只有函数的声明,没有具体实现,没有用花体括号

    只有返回值 + 函数名的形式

    ```

  - 接口中的成员变量

    ​

    - 默认修饰符只能为：public static final

    ```java
    interface Student {
        //因为接口没有构造方法和具体方法实现
        //所以必须要注意变量在声明的时候必须给初值
        public static final int c = 3;
        public void get();
    }
    ```

    ​


  - 为什么是final

    - 接口中的所有方法都是抽象方法，不会有任何实现方面的代码，而它的具体实现是要靠实现这个接口的具体类来具体实现的。而且，这个接口中的方法是不可更改的。同样的，接口中的变量也是不可更改的。所以，要声明为final。

    ​

  - 为什么是static

    - 至于这个问题，是和Java语言的本身机制有关。我们知道Java不支持多继承，但是一个类可是现实多个接口。我们假设有两个接口A和B，而类C实现了接口A和B。假设，此时，A和B中都有一个变量N，如果N不是static类型的，那么在C中该如何区分N到底是A的还是B的呢？而，如果是static类型的，我们可以通过A.N和B.N来区别调用A或者B中的成员变量N。

      ```java
      interface A{
          final int N = 2;
      }

      interface B{
          final int N = 1;
      }

      class C implements A,B{
          public static void main(String[] args) {
              System.out.println(N);//不知道调用哪个接口的N 所以会报错
              System.out.println(A.N);
              System.out.println(B.N);
          }
      }
      ```

      ​

    ​

    - 接口不是被类继承了，而是要被类实现。

    - 接口支持多继承。

    - 接口的方法声明必须是 public  即便不写默认也是,接口中的方法默认是抽象的

      ​


- 实现接口

    - 当类实现接口的时候，类要实现接口中所有的方法。

      ​

    - 类使用implements关键字实现接口

      ```java
      public interface DataBase {
              public void connect(DataBase dataBase);
              public void log();
          }

          class Mysql implements DataBase{

              @Override
              public void connect(DataBase dataBase) {
                  System.out.println("链接到了mysql");
              }

              @Override
              public void log() {
                  
              }
          }
      ```

      ​

      ​

- 接口的多继承

    - 在Java中，类的多继承是不合法，但接口允许多继承,注意继承的是接口。

    - 类实现一个有多继承存在的接口，那么就要实现多继承接口里面的所有方法

      ```java
      public interface MoreExtends extends DataBase,Student{
      void moreExtends();
      }

      public interface DataBase {
              public void connect(DataBase dataBase);
              public void log();
      }

      public interface Student {
              public void get();
          }

      public interface MoreExtends extends DataBase,Student{
        void moreExtends();
      }

      public class Test implements MoreExtends {
        @Override
        public void moreExtends() {

        }

        @Override
        public void connect(DataBase dataBase) {

        }

        @Override
        public void log() {

        }

        @Override
        public void get() {

        }
      }
      ```

      ​


- 类通过接口实现多继承

    ```java
    public interface A {
        void get();
    }

    interface B{
        void set();
    }

    public class Father {
        void sing(){}
    }

    class Son extends Father implements A,B{

        @Override
        public void get() {

        }

        @Override
        public void set() {

        }
    }
    ```




---



### 异常

- 异常是程序中的一些错误，但并不是所有的错误都是异常，并且错误有时候是可以避免的。

  ​

- 异常发生的原因有很多，通常包含以下几大类：

  - 用户输入了非法数据。
  - 要打开的文件不存在。
  - 网络通信时连接中断，或者JVM内存溢出。

- 捕获异常

  - 使用 try 和 catch 关键字可以捕获异常。try/catch 代码块放在异常可能发生的地方

    ```java
    try
    {
       // 程序代码
    }catch(Exception e)
    {
       //Catch 块
    }
    ```

  - catch 语句包含要捕获异常类型的声明。当保护代码块中发生一个异常时，try 后面的 catch 块就会被检查。

  - 例子

    ```java
    import java.io.*;
    public class ExcepTest{
     
       public static void main(String args[]){
          try{
             int a[] = new int[2];
             System.out.println("Access element three :" + a[3]);
          }catch(ArrayIndexOutOfBoundsException e){
             System.out.println("Exception thrown  :" + e);
          }
          System.out.println("Out of the block");
       }
    }
    ```

    ​


- 多重捕捉块

  ```
  try{
     // 程序代码
  }catch(异常类型1 异常的变量名1){
    // 程序代码
  }catch(异常类型2 异常的变量名2){
    // 程序代码
  }catch(异常类型2 异常的变量名2){
    // 程序代码
  }
  ```

  - 可以在 try 语句后面添加任意数量的 catch 块,如果保护代码中发生异常，异常被抛给第一个 catch 块,如果抛出异常的数据类型与 ExceptionType1 匹配，它在这里就会被捕获。如果不匹配，它会被传递给第二个 catch 块。如此，直到异常被捕获或者通过所有的 catch 块。

    ​

  - catch捕捉按照异常从小到大捕捉,不然的话会报错

    ​

- throws/thows

  - 如果一个方法没有捕获异常，但是方法内的代码可能会出现异常,那么该方法必须使用 throws 关键字来声明。throws 关键字放在方法签名的尾部，多个异常之间用逗号隔开。

  - ​

    ```java
    public class className
    {
       public void withdraw(double amount) throws RemoteException,
                                  InsufficientFundsException
       {
           // Method implementation
       }
       //Remainder of class definition
    }
    ```

    ​

  - 也可以使用 throw 关键字抛出一个异常，无论它是新实例化的还是刚捕获到的。

    ```java
    public class className
    {
      public void deposit(double amount) throws RemoteException
      {
        // Method implementation
        throw new RemoteException();
      }
      //Remainder of class definition
    }
    ```

    ​

- finally

  - finally 关键字用来创建在 try 代码块后面执行的代码块，无论是否发生异常，finally 代码块中的代码总会被执行。

    ```
    try{
      // 程序代码
    }catch(异常类型1 异常的变量名1){
      // 程序代码
    }catch(异常类型2 异常的变量名2){
      // 程序代码
    }finally{
      // 程序代码
    }
    ```

  - 栗子

    ```java
    public class Finally {

        public static void main(String args[]){

            int a[] = new int[2];
            try{
                System.out.println("数组元素 :" + a[3]);
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("捕获异常:" + e);
            }
            finally{
                a[0] = 6;
                System.out.println("finally-------------------");
                System.out.println("元素: " +a[0]);
                System.out.println("end-------------------------");
            }
        }
    }
    ```

    ​




