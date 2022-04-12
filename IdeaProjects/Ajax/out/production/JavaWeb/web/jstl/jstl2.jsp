<%--
  Created by IntelliJ IDEA.
  User: bruce
  Date: 2021/12/9
  Time: 2:21 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>choose标签</title>
</head>
<body>
            <%--
                            完成数字编号对应星期几的案例
                                1.在作用域中存储一个数字
                                2.使用choose标签去除数字  //相当于Switch的声明
                                3.使用when标签做数字判断  //相当于Case
                                4.otherwis标签做其他情况的声明 //相当于default
             --%>
        <%
            request.setAttribute("number",3);
        %>
            <c:choose>
                <c:when test="${number==1}"><h1>星期1</h1></c:when>
                <c:when test="${number==2}"><h1>星期2</h1></c:when>
                <c:when test="${number==3}"><h1>星期3</h1></c:when>
                <c:when test="${number==4}"><h1>星期4</h1></c:when>
                <c:when test="${number==5}"><h1>星期5</h1></c:when>
                <c:when test="${number==6}"><h1>星期6</h1></c:when>
                <c:when test="${number==7}"><h1>星期日</h1></c:when>
                <c:otherwise><h1>输入有误</h1></c:otherwise>
            </c:choose>

</body>
</html>
