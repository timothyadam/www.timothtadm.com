<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page language="java" import="com.yc.entity.*" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body> 

<%
SessionUser sessionUser = new SessionUser();
System.out.println(sessionUser.getAccount()); 
%>
<center>
          <h1>  </h1></center>
          登陆测试
          
          
</body>
</html>