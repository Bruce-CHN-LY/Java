<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: bruce
  Date: 2021/12/10
  Time: 2:52 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL的For循环</title>
</head>
<body>
    <%--
            foreach: 相当于java代码中的for语句
                1. 完成重复的操作
                    for(int i=0;i<10;i++)
                    {
                        }
                   *属性：
                        Begin:开始值
                        End:结束值
                        var:临时变量
                        Step:步长
                        varStatus:循环状态对象
                            index: 容器中元素的索引，从0开始
                            Count: 循环次数，从1开始
                2. 遍历容器
                        list<user> list
                        for(User user:list)
                        {
                        }
                        *属性：
                            items: 容器对象
                            var: 容器中元素的临时变量

    --%>
    <c:forEach begin="1" end="10" var="i" step="1">
        ${i}<br>
    </c:forEach>
    <hr>
    <%
        List list=new ArrayList();
        list.add("aaa");list.add("bbb");list.add("ccc");
        request.setAttribute("list",list);
    %>
    <c:forEach items="${list}" var="i" varStatus="s">${s.index} ${s.count} ${i}<br></c:forEach>
</body>
</html>
