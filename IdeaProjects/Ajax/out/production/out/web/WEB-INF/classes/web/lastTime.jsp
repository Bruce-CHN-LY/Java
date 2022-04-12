<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.net.SocketImpl" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%--
  Created by IntelliJ IDEA.
  User: bruce
  Date: 2021/12/2
  Time: 10:55 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LastTime</title>
</head>
<body>
    <%
        boolean flag=false;
        //1.获取所有的cookies
        Cookie[] cookies = request.getCookies();
        //2.便利cookies数组
        if(cookies!=null&&cookies.length>0) {
            for (Cookie cookie : cookies) {
                //获取cookie的名称
                String cookieName = cookie.getName();
                if(cookieName.equals("lastTime"))
                {
                    flag=true;
                    //响应数据
                    String value=cookie.getValue();
                    //URL解码
                    String decodeValue = URLDecoder.decode(value, "UTF-8");
                    //写出
%>
                   <h1>欢迎回来，您上次访问的时间为<%=decodeValue%></h1>
    <%
                    //获取当前的时间字符串，给Value更新赋值。
                    Date date=new Date();
                    SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String str_date = sdf.format(date);
                    //给时间进行编码
                    String encodeValue = URLEncoder.encode(str_date, "utf-8");
                    //更新时间
                    cookie.setValue(encodeValue);
                    //cookie持久化存储
                    cookie.setMaxAge(60*60*24*30);
                    response.addCookie(cookie);
                    break;//跳出循环
                }
            }
        }
    %>
    <%
        if(cookies==null||cookies.length==0||flag==false)
        {
            Date date=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String str_date = sdf.format(date);
            //URL 编码
            String encodeValue = URLEncoder.encode(str_date, "utf-8");
            Cookie cookie = new Cookie("lastTime", encodeValue);
            //设置cookie的持久化存储
            cookie.setMaxAge(60*60*24*30);
            response.addCookie(cookie);
            //响应数据
            out.write("<h1>您好，欢迎您首次访问</h1>");
        }
    %>
</body>
</html>
