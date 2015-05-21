<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../includes/importer.jsp"%>
<!doctype html>
<html>
<head>
    <head>
    <ht:head/>
</head>
<body>


<div id="content">
<!-- forms -->
<div class="box">
    <!-- box / title -->
    <div class="title">
        <h5>添加项目</h5>
    </div>
   <script type="text/javascript">
   
   alert("tets");
   
   alert("look  at there "+G_CTX_ROOT);
   
   
   </script>
    <!-- end box / title -->
    <form:form method="post" id="fm" commandName="member" htmlEscape="true" acceptCharset="utf-8" cssClass="required-validate" >
        <div class="form">
            <div class="fields">
             
     <div class="fields">
                <div class="field">
                    <div class="label noinput">ID：</div>
                    <div class="input">自动生成</div>
                </div>

           
                        <form:input path="account" cssClass="small required" maxlength="100"/>
                        
                        <form:input path="password" Class="small required  maxlength=100" />
                        
               
                <div class="buttons">
                        <input type="submit" name="submit.highlight" value="提交" />
                    <input type="reset" name="reset" value="重置" />
                </div>
            </div>
        </div>
    </form:form>
</div>
<!-- end forms -->
</div>


</body>
</html>