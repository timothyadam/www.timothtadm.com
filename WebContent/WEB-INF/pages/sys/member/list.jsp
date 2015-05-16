<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../../includes/importer.jsp"%>
<%@page language="java" import="com.yc.entity.*" %>	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>


</head>
<body>

<div class="w1000 mblock">
    <form id="frm_login" action="${ctx}/sys/login" method="POST" style="float:center; width:620px;">
    <div class="logbg">
        <div class="w50">
            <h1>用户登录</h1>
            <div class="form_dev">
                <dl>
                    <dt>用户名：</dt>
                    <dd><input name="account" id="f_username" class="ipt_w300" type="text" maxlength="20" tabindex="1" /></dd>
                </dl>
                <dl>
                    <dt>密码：</dt>
                    <dd><input name="password" id="f_password" class="ipt_w300" value="" type="password" maxlength="20" tabindex="2" />
                        <div class="tips">
                            <span>
                                <input type="checkbox" name="savelogin" id="f_savelogin" value="true" checked="checked" tabindex="3"/>
                                <label for="f_savelogin">记住我的登录信息</label>
                            </span>
                            <a href="${ctx}/retake-pwd/sendemail">忘记密码？</a>
                        </div>
                    </dd>
                </dl>
                <dl class="p_btn">
                    <dd>
                      <input type="submit" value="登陆"/>
                    </dd>
                </dl>
                <div id='error_msg' class='error_msg' style='display:none;'></div>
                <style>.error_msg { color: red; }</style>
            </div>
        </div>
        <div class="w50"><div class="newer"><a href="${ctx}/profile/create"><img src="${res}/images/btn_newuser.png"/></a></div></div>
    </div>
    </form>
</div>
<script type='text/javascript'>
    <!--

    $("#frm_login").keydown(function(e) {
        if (e.which == 13) {
            $('#frm_login').submit();
            return false;
        }
    });
    

   // $('#f_username').focus();
    $('#frm_login').ajaxForm({
        beforeSubmit: function(a,f,o) {
            if($('#f_username').val().length == 0){
                $('#f_username').focus();
                $('#error_msg').html("请输入登录用户名");
                $('#error_msg').show();
                return false;
            }
            if($('#f_password').val().length == 0){
                $('#f_password').focus();
                $('#error_msg').html("请输入登录密码");
                $('#error_msg').show();
                return false;
            }
        },
        success: function(html) {
            if(html.length > 0){
                $('#error_msg').hide();
                $('#error_msg').html(html);
                $('#error_msg').show();
            }else{
            <c:if test="${not empty param.p}">location.href="${param.p}";</c:if>
                <c:if test="${empty param.p}">location.href="${ctx}/";</c:if>
            }
        }
    });
  //-->
</script>

</body>

</html>