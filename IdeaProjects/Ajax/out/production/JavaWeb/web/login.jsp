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
    <script>
        window.onload=function (){
            let elementById = document.getElementById("img");
            elementById.onclick=function ()
            {
                let date = new Date().getTime();
                img.src="/checkcodeServlet?"+date;
            }
        }
    </script>
    <style>
        div{
            color: red;
        }
    </style>
</head>
<body>
    <form action="/loginServlet2" method="post">
       <table>
           <tr>
               <td>用户名</td>
               <td><input type="text" name="username"></td>
           </tr>
           <tr>
               <td>密码</td>
               <td><input type="password" name="password"></td>
           </tr>
           <tr>
               <td>验证码</td>
               <td><input type="text" name="checkCode"></td>
           </tr>
           <tr>
               <td colspan="2"><img src="/checkcodeServlet" id="img"></td>
           </tr>
           <tr>
               <td colspan="2"><input type="submit" value="登陆"></td>
           </tr>
       </table>

    </form>
<%--    <div><%=request.getAttribute("cc_error")==null?"":request.getAttribute("cc_error")%></div>--%>
<%--    <div><%=request.getAttribute("login_error")==null?"":request.getAttribute("login_error")%></div>--%>
<%--    学习完EL回来修改代码，简化书写--%>
    <div>${requestScope.cc_error}</div>
    <div>${requestScope.login_error}</div>

</body>
</html>
