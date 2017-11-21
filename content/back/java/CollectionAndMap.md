# 容器

**Collection和Map**

**Collection:Collection是最基本的集合接口.一个Collection即代表一组对象的集合.而Collection也有一些不同的子接口,他们各有特性,有些是有序的,而有些不是,有些可以排序,而有些不行,这些不同特性的Collection被广泛运用于实践中**

- **List(列表):Arraylist & Linkedlist** 
  - **用户可以直接通过索引(元素在该集合中的位置,可以将索引认为是数组的下标)来访问List中的元素,类似于数组,不过用来存放的是对象.**
  - **Arraylist可视为用来存放对象的array,并且array的长度是可以改变的,不需要提前声明以及注意容器的长度是否会超出限制  ArrayList的顺序查询和随机查询的性能更加优秀->底层实现有关**
  - **LinkedList 可视为用来存储对象的顺序链表,它的属性和ArrayList相似,也可视为用来存放对象的一个顺序表.LinkedList在执行插入删除以及替换等对元素进行值的操作时,性能更加优秀.**
- **Set(集):一个无重复元素的集合.也就是一个Set集合中的任意两个元素都不相同.**
  - **Set集合中可以有值为null的元素,但是只能有一个.**
  - **Set具有和Collection完全一样的接口,没有任何额外功能**
  - **HashSet:Set接口的一种实现,它的底层由哈希表实现,由于散列算法的缘故,hashset并不能保证元素的排列顺序,顺序是有可能变化的.**
  - **由于Set的特性是集合内没有重复元素,所以对Set最经常做的操作是查询.而HashSet使用了散列算法来保证查询速度,所以HashSet的使用是最为广泛而频繁的.**
  - **TreeSet:Set接口的另外一种实现,底层由红黑树实现.TreeSet的特性是可以保证集合内的元素按照其大小升序排列.**
  - **LinkedHashSet:和HashSet相同,LinkedHashSet是由哈希值来决定元素的存储位置的,但是同时又使用链表来实现元素按照他们的插入顺序的排列,所以该接口的特性可以维持元素的插入顺序不变,同时通过散列算法保证了查询速度**

**Iterator迭代器(游标):公共操作接口,用来遍历底层容器中的数据(Iterator类)**

//这里有一个地方上课的时候讲错了,Iterator并不能被称为指针,因为实际上它永远指向的是每个元素的前一位,也就是说当你调用迭代器的时候,迭代器的指向并非是像C里面的指针一般指向元素,而是对迭代器调用next方法,此时才会返回一个容器内元素.这里我的理解出现了偏差,深感抱歉

**Map(映射):  一组成对的键值对对象,允许你使用键来查找值(类比Arraylist和数组可以使用数字下标来查找值),可以理解为是数学中的映射,或是可以理解为用对象类型作为下标的数组,即关联数组.**

- **Map的键值是唯一的,在一个Map中,不会有重复的键,即Map的键值组成的集合,即为一个Set.在Map中,如果后面添加的键值对,键在Map中已经存在,那么之前该键所对应的值,会被之后添加的值所覆盖.**
- **Map由于同时拥有Set和List的一些特性,是使用最为广泛的容器之一.**
- **Map自身是一维的,但是可以通过嵌套的方式来实现多维,来实现一张数据表的效果,但是在细微之处也有所不同.**
- **Map的遍历方法:迭代器,lambda表达式,entrySet方法遍历**




示例代码:https://github.com/RedrockTeam/Course/tree/master/content/back/back_demo/tenth_demo



以下为课堂上提到问题的解答,对于作业的补充说明,和一些其他的资料



##对于课堂上提到的俩问题:

###增强型循环:

增强型循环是在java5推出的一个新特性(这个版本同时也推出了泛型),增强型循环主要的目的就是为了让容器的遍历变得更加简洁,更加方便.同时,增强型循环的缺点是不能直接访问容器的索引或者是数组的下标,所以对于不同情况下的操作还需要自行选用比较合适的办法来进行操作.

增强型循环其实并不是很难理解..这里先上一段例子

```java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ForeachTest
{
  public static void main(String[] args)
  {
    int[] arr = {1, 2, 3, 4, 5};
    
    System.out.println("----------旧方式遍历------------");
    //旧式方式    
    for(int i=0; i<arr.length; i++)
    {
      System.out.println(arr[i]);
    }
    
    System.out.println("---------新方式遍历-------------");
    
    //新式写法,增强的for循环
    for(int element:arr)
    {
      System.out.println(element);
    }
    
    System.out.println("---------遍历二维数组-------------");
    
    //遍历二维数组
    
    int[][] arr2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}} ;
    
    for(int[] row : arr2)
    {
      for(int element : row)
      {
        System.out.println(element);
      }
    }
    
    //以三种方式遍历集合List
    
    List<String> list = new ArrayList<String>();
    
    list.add("a");
    list.add("b");
    list.add("c");
    
    System.out.println("----------方式1-----------");
    //第一种方式，普通for循环
    for(int i = 0; i < list.size(); i++)
    {
      System.out.println(list.get(i));
      
    }
    
    System.out.println("----------方式2-----------");
    //第二种方式，使用迭代器
    for(Iterator<String> iter = list.iterator(); iter.hasNext();)
    {
      System.out.println(iter.next());
    }
    System.out.println("----------方式3-----------");
    //第三种方式，使用增强型的for循环
    for(String str: list)
    {
      System.out.println(str);
      
    }
  }

}
```

从上面的例子里,我们可以看到,增强型循环最重要的操作就是不需要再考虑所遍历容器的索引或者说下标是否超限等等问题,直接取值进行使用就好.所以带来的增益其实也是显而易见的...



###对于lambda表达式:

lambda表达式是在java8中新增的一个特性(与上面的java五并称是java发展史上最重要的两个版本),lambda表达式主要是提供了一种新的方法使得开发者可以轻易的调用一个新的匿名方法.我们知道在之前,如果你想调用一个方法,就必须先在某个类里面将这个方法写出来,但是这样做的话,有些只使用一次的方法如果也要被声明在上面,那么最终的代码可读性就会大大降低.在lambda表达式出现之前这时一般采用的方法是使用一个匿名内部类来解决这个问题,但是匿名内部类还需要对于使用的方法进行抽象,而lambda表达式则是对此作了一道简化,通过使用一个()->{}即可解决大部分的原匿名内部类解决的问题

- lambda表达式的两个主要使用方向
  - 首先是用在原来匿名内部类的领域,lambda表达式能够简化大部分的代码
  - 二是用在容器的遍历上面,对于容器元素的复杂操作,完全可以使用lambda表达式做大部分的简化操作

lambda表达式我用的其实不是非常多...所以只讲了一些我自己的理解,具体内容还是请参照一些书目,这里推荐一篇博客:https://www.cnblogs.com/WJ5888/p/4618465.html

//其实是我太菜确实没怎么用lambda表达式..不好意思



##关于作业的一些叙述:

作业里面已经给出了大部分的数据以及返回格式,鉴于很多同学还是说没有看懂题目,这里再给一下解释吧,工具类tools里面给出了4个静态方法,他们分别会返回的数据是学院列表(getCollageList),学院到专业的映射表(getCollageToMajorMap),专业到班级的映射表(getMajorToClassList),和单个班级的所有学生数据(getClassList),前三个方法并没有参数,可以直接拿到全校的数据,第四个方法也就是单个班级的学生数据,需要你传入班级号,然后拿到班级内所有学生的List.而你需要做的事,就是将上面四个方法返回的数据,放到一个容器里面,并形成一个层级关系(学院->专业->班级->学生).最后需要实现的效果是,你能通过你的容器,来输出一个学生的数据或一个班/专业的学生数据.//基础要求

**更新:抱歉之前忘记了网络请求的耗时很长,所以最后的效果只需要给出一个全院的容器,这里对不起大家,不好意思!**

提高要求即是能够通过上面你构造的这个容器,然后输入学号就能够查询到这个同学的数据,并打印在屏幕上面

//优化那个的话,可以考虑通过建索引等方法...

大家作业加油~



##ps:

//我在备课的时候看到的一个腾讯AI方向研究员写的一系列java博客,感觉写的挺不错的,但是由于是他整理的学习笔记所以如果没有基础可能会稍难看懂,有兴趣可以去看看

java博客:http://www.cnblogs.com/xltcjylove/p/3776674.html

​		http://www.cnblogs.com/xlturing/p/3790064.html

​		http://www.cnblogs.com/xlturing/p/3852404.html