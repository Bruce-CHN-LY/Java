<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: bruce
  Date: 2021/12/9
  Time: 1:52 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>if标签</title>
</head>
<body>
<%--
        c:if标签
            1.属性：
                Test:必须属性，接受boolean表达式
                    如果表达式为true,则显示if标签体内容。如果表达式为false,则不显示标签体内容。
                    一般情况下，test属性值会给el表达式一起使用
            2.注意：
                c:if没有else的情况，如果需要else,则可以再次定义一个c:if标签。
--%>
    <c:if test="true">
        <h1>我是真</h1>
    </c:if>
    <br>

    <%
        //盘对岸request域中的一个list集合是否为空，如果不为空则遍历集合。
        List list=new ArrayList();
        list.add("aaa");list.add("bbb");
        request.setAttribute("us",list);
    %>
        <c:if test="${not empty us}">
            遍历集合。
        </c:if>
</body>
</html>
