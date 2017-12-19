<%--
  Created by IntelliJ IDEA.
  User: jiangtianxing
  Date: 2017/12/15
  Time: 下午4:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="org.redrock.jsp.util.StringUtil" %>
<%@ page import="org.redrock.jsp.util.DatabaseUtil" %>
<%--这个都看不懂 退群了吧--%>
<%
    if (request.getMethod().equalsIgnoreCase("post")) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String passwordConfirm = request.getParameter("passwordConfirm");
        if (StringUtil.hasBlank(username, password, passwordConfirm)) {
            response.getWriter().println("注册失败，表单未填写完整");
            return;
        }
        if (!passwordConfirm.equals(password)) {
            response.getWriter().println("注册失败，两次输入密码不一致");
            return;
        }
        Connection connection = DatabaseUtil.getConnection();
        Statement statement = connection.createStatement();
        //这里没有防sql注入、xss攻击，有兴趣的可以查下解决方法 和 动态执行语句 PreparedStatement
        ResultSet resultSet = statement.executeQuery("select * from user where username = '" + username + "'");
        if (resultSet.next()) {
            response.getWriter().println("注册失败，用户已存在");
            return;
        }
        String sql = "insert into user(username, password) values('" + username + "', '" + StringUtil.md5(password) + "')";
        statement.execute(sql);
        // session 跟 cookie的区别
        session.setAttribute("user", username);
        response.getWriter().println("注册成功");
        response.sendRedirect("./admin/index.jsp");
        return;
    }
%>
<%--bootstrap 上面直接拉下来的垃圾代码--%>
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
        register
    </h1>
    <form class="form-horizontal" action="./register.jsp" method="POST">
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
            <label for="inputPasswordForConfirm" class="col-sm-2 control-label">PasswordConfirm</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="inputPasswordForConfirm" placeholder="PasswordConfirm" name="passwordConfirm">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">register</button>
            </div>
        </div>
    </form>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</div>
</body>
</html>