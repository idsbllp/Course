# 第三次上课作业

## 前端

### 作业要求

- 参考以下示例代码，页面加载后，将提供的空气质量数据数组，按照空气质量大于60进行过滤筛选，最后将符合条件的数据按照一定的格式要求显示在网页上

  ```javascript
  <!DOCTYPE html>
  <html>
    <head>
      <meta charset="utf-8">
      <title>IFE JavaScript Task 01</title>
    </head>
  <body>

    <h3>污染城市列表</h3>
    <ul id="aqi-list">
  <!--   
      <li>第一名：福州（样例），10</li>
        <li>第二名：福州（样例），10</li> -->
    </ul>

  <script type="text/javascript">

  var aqiData = [
    ["北京", 90],
    ["上海", 50],
    ["福州", 10],
    ["广州", 50],
    ["成都", 90],
    ["西安", 100]
  ];

  (function () {

    /*
    在注释下方编写代码
    遍历读取aqiData中各个城市的数据
    将空气质量指数大于60的城市显示到aqi-list的列表中
    */

  })();

  </script>
  </body>
  </html>
  ```


- 提示
  - 学习JavaScript中的if判断语法，for循环语法
  - 学习JavaScript中的数组对象
  - 学习如何读取、处理数据，并动态创建、修改DOM中的内容
  - 图中ul下面的注释部分为示例，你需要做的是把下面script标签中的那个数组进行筛选，将大于60的选择出来然后利用dom插入到上面的ul中。
- 进阶
  - 把Git地址发到pengshixia@redrock.team


- 进阶实在不行也可以直接发作业到上面的邮箱 git有什么问题也可以问我



## 后端

