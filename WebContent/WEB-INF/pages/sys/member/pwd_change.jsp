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

      <form:form class="table-show" id="fn" action="" method="post" commandName="member"  acceptCharset="utf-8">
         <h2 class="table-show-heading">修该密码</h2>
         <label for="inputEmail" class="sr-only">原密码</label>
         <input type="password"  id="inputPassword" class="form-control"    />
        <label for="inputPassword" class="sr-only">新密码</label>
        <input type="password" id="inputPassword"  class="form-control"  />
        <button class="btn btn-lg btn-primary btn-block"  type="submit">确认</button>
      </form:form>

    </div> 
</body>
</html>