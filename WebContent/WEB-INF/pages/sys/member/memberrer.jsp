<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../../includes/importer.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<ht:head title="用户注册"></ht:head>
</head>
 <body>
 <script type="text/javascript">
 
 
 </script>
 <div class="container">
 <div class="panel" >
 <div class="panel-title"><h1 >用户注册</h1></div>
<fieldset > 
<form:form id="fm"  method="post" commandName="member" htmlEscape="true" acceptCharset="utf-8" cssClass="required-validate">
<div class="labe">
<label>用户名：</label>
<form:input id="account" path="account"  cssClass="small required" maxlength="100" />
</div>
<div>
<label>pass ：</label>
<form:input id="password" path="password"  Class="small required  maxlength=100"/>
</div>
<div>
<label>昵称　：</label>
 <form:input path="nic" />
</div>
<div>

<label>手机号码：</label>
 <form:input path="phone" id="phone" />
</div>

<div>
<label>地址：</label>
 <form:input path="adress"/>
</div>
<div>
<label>邮箱：</label>
 <form:input path="email" id="email" Class="small required  maxlength=100"/>
</div>

<div class="button">
<input type="submit" name="submit.highlight" value="提交" />
<input type="reset" name="reset" value="重置" />
</div>
</form:form>
 
 </fieldset>

  </div>
 </div>
</body>
</html>