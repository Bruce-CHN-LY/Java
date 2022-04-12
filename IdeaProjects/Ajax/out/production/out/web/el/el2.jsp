<%--
  Created by IntelliJ IDEA.
  User: bruce
  Date: 2021/12/9
  Time: 10:12 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el获取域中的数据</title>
</head>
<body>
    <%
        //在域中存储数据
        request.setAttribute("name","bruce");
        session.setAttribute("age","33");
    %>
    <h3>el来获取值</h3>
    ${requestScope.name}
    ${sessionScope.age}
</body>
</html>
