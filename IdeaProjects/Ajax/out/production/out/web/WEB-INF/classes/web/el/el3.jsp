<%@ page import="session.sessionProject.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: bruce
  Date: 2021/12/9
  Time: 10:34 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el获取对象数据</title>
</head>
<body>
    <%
        //创建一个对象
        User user=new User();
        user.setUserName("bruce");
        user.setPassWord("yuc46938");
        request.setAttribute("u",user);

        List list=new ArrayList();
        list.add("aaa");  list.add("bbb");  list.add("ccc");
        request.setAttribute("l",list);

    %>
    <h3>获取对象中的值</h3>
    ${requestScope.u}
<%--
    通过的是对象属性来获取
        *setter或getter方法，去掉set或get,将剩余部分，首字母变小写。
        *setName-->Name-->name
--%>
    ${requestScope.u.userName}

    <h3>获取List集合的值</h3>
    ${l}
    ${l[0]}
    ${l[1]}<br>
    ${empty l}

</body>
</html>
