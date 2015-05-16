<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../includes/importer.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<ht:head />
<title>后台管理管理系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

<div class="container">

      <form class="form-signin">
        <h2 class="form-signin-heading">登　陆</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> 记住我
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登陆</button>
      </form>

    </div> 


</body>
</html>