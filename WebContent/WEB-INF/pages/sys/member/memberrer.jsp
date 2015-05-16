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
 $(document).ready(function () {
	 $( "#menu" ).ajaxFormSubmit();
	 })
 
 
 </script>
 <div class="container">
 <div class="panel" >
 <div class="panel-title"><h1 >用户注册</h1></div>

<fieldset > 

<form:form action="" method="post" commandName="member" htmlEscape="true" acceptCharset="utf-8"  cssStyle="required-validate">
<div class="labe">
<label>用户名：</label>
<form:input path="account" cssClass="small required" maxlength="100"/>
</div>
<div>
<label>pass ：</label>
 <form:input path="password"/>
</div>
<div>
<label>昵称　：</label>
 <form:input path="nic"/>
</div>
<div>

<label>手机号码：</label>
 <form:input path="phone"/>
</div>

<div>
<label>地址：</label>
 <form:input path="adress"/>
</div>
<div>
<label>邮箱：</label>
 <form:input path="email"/>
</div>

<div class="button">
<input type="submit" value="确定"  name="submit.highlight" /> 
</div>
</form:form>
 
 </fieldset>

  </div>
 </div>
</body>
</html>