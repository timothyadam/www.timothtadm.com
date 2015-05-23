<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../../includes/importer.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<ht:head title="修改密码"></ht:head>
</head>
<body>
<div class="container">
   <h2 class="form-signin-heading">修改密码</h2>
       <form:form id="fm" action="" commandName="member"  acceptCharset="utf-8" method="post" htmlEscape="true"  cssClass="required-validate" >
       <div>
        <label for="oldPassword" class="sr-only">原密码</label>
       
        <form:password  id="oldPassword" path="password" placeholder="原密码"  cssStyle="form-control"  />
       </div>
   
       <div>
        <label for="inputPassword" class="sr-only">新密码</label>
        <form:password  id="inputPassword" path="newPass"  placeholder="新密码"  cssStyle="form-control" /> 
         <!-- placeholder="Password" -->
      </div>   
       <div>
       
       <label for="confirmPass" class="sr-only">确认密码</label>
       <form:password  id="confirmPass" path="confirmPass" placeholder="确认密码"    cssStyle="form-control" />
       </div>
       
       
       <input type="submit" value="确认"   class="btn btn-lg btn-primary " style="width:150px;height: 39px" /> 
      </form:form>

    </div> 
</body>
</html>