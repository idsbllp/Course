<%--
  Created by IntelliJ IDEA.
  User: jiangtianxing
  Date: 2017/12/15
  Time: 下午4:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="org.redrock.jsp.util.DatabaseUtil" %>
<%@ page import="org.redrock.jsp.util.StringUtil" %>
<%
    //jsp的内置隐式对象
    if (request.getParameter("action") != null && request.getParameter("action").equals("logout") && session.getAttribute("user") != null) session.removeAttribute("user");
    // session 跟 cookie的区别
    if (session.getAttribute("user") != null) {
        //重定向
        response.sendRedirect("./admin/index.jsp");return;
    }
    if (request.getMethod().equalsIgnoreCase("post")) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Connection connection = DatabaseUtil.getConnection();
        Statement statement = connection.createStatement();
        //这里没有防sql注入、xss攻击，有兴趣的可以查下解决方法 和 动态执行语句 PreparedStatement
        ResultSet resultSet = statement.executeQuery("select * from user where username = '" + username + "'");
        if (!resultSet.next()) {
            response.getWriter().println("登陆失败，用户不存在");return;
        }
        if (!resultSet.getString("password").equalsIgnoreCase(StringUtil.md5(password))) {
            response.getWriter().println("登陆失败，密码错误");return;
        }
        session.setAttribute("user", username);
        response.sendRedirect("./admin/index.jsp");return;
    }
%>
<%--不要纠结这么多，bootstrap 上面直接拉下来的垃圾代码，我也不知道写的啥--%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>login</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <h1>
        login
    </h1>
    <form class="form-horizontal" action="./index.jsp" method="POST">
        <div class="form-group">
            <label for="inputUsername" class="col-sm-2 control-label">Username</label>
            <div class="col-sm-10">
                <input class="form-control" id="inputUsername" placeholder="Username" name="username">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword" class="col-sm-2 control-label">Password</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="inputPassword" placeholder="Password" name="password">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <div class="checkbox">
                    <label>
                        <input type="checkbox"> Remember me
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Sign in</button>
            </div>
            <div class="col-sm-offset-2 col-sm-10">
                <button type="button" class="btn btn-default" onclick="window.location.href='./register.jsp'">Register</button>
            </div>
        </div>
    </form>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>