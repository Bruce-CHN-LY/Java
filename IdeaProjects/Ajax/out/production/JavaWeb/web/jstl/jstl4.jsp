<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="web.jstl.Student" %><%--
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
    <title>JSTL案例</title>
</head>
<body>
<%--需求：在request域中有一个存有User对象的List集合，需要使用JSTL+EL将LIST集合数据展示到JSP页面的表格Table中。--%>
    <%
        Student s1=new Student("0001","snake","23");
        Student s2=new Student("0002","bruce","33");
        Student s3=new Student("0003","lzl0379","34");


        List student=new ArrayList();
        student.add(s1);student.add(s2);student.add(s3);
        request.setAttribute("st",student);
    %>
    <table class="t1" border="1" width="500" align="center">
        <tr>
            <th>序号</th>
            <th>姓名</th>
            <th>年龄</th>
        </tr>
<%--        动态的数据行--%>
        <c:forEach items="${st}" var="user" varStatus="s">
            <c:if test="${s.count%2==0}">
            <tr bgcolor="#ff7f50">
                <td>
                    ${user.id}
                </td>
                <td>
                        ${user.sname}
                </td>
                <td>
                        ${user.sage}
                </td>
            </tr>
            </c:if>
            <c:if test="${s.count%2!=0}">
                <tr bgcolor="#7fff00">
                    <td>
                            ${user.id}
                    </td>
                    <td>
                            ${user.sname}
                    </td>
                    <td>
                            ${user.sage}
                    </td>
                </tr>
            </c:if>
        </c:forEach>
    </table>
</body>
</html>
