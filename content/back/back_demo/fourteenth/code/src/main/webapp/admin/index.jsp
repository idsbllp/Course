<%--
  Created by IntelliJ IDEA.
  User: jiangtianxing
  Date: 2017/12/15
  Time: 下午4:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%
    if (session.getAttribute("user") == null) {
        response.sendRedirect("../index.jsp");
        return;
    }
    String username = (String) session.getAttribute("user");
    out.print(username + " ! 欢迎登陆");
%>
<a href="../index.jsp?action=logout">退出登陆</a>