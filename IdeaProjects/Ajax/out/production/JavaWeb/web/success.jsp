<%--
  Created by IntelliJ IDEA.
  User: bruce
  Date: 2021/12/8
  Time: 9:21 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<h1><%=request.getSession().getAttribute("username")==null?"":request.getSession().getAttribute("username")%>,欢迎登陆</h1>

</body>
</html>
