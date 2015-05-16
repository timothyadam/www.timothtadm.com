<%@ tag pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ attribute name="title" required="false" %>
    <meta charset="UTF-8" />
    <meta content="width=device-width, minimum-scale=1.0, maximum-scale=2.0" name="viewport">
    <title>${empty title ? '' : title}</title>
    
    <link href="<spring:url value="/static/bootstrap/css/bootstrap-theme.css"/>" rel="stylesheet" type="text/css" />
    <link href="<spring:url value="/static/bootstrap/css/bootstrap-theme.css.map"/>" rel="stylesheet" type="text/css" />
    <link href="<spring:url value="/static/bootstrap/css/bootstrap-theme.min.css"/>" rel="stylesheet" type="text/css" />
    <link href="<spring:url value="/static/bootstrap/css/bootstrap.css"/>" rel="stylesheet" type="text/css" />
    <link href="<spring:url value="/static/bootstrap/css/bootstrap.css.map"/>" rel="stylesheet" type="text/css" />
    <link href="<spring:url value="/static/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css" />
    <link href="<spring:url value="/static/css/signin.css"/>" rel="stylesheet" type="text/css" />
    <link href="<spring:url value="/static/jquery-ui/jquery-ui.min.css"/>" rel="stylesheet" type="text/css" />
    <link href="<spring:url value="/static/jquery-ui/jquery-ui.theme.min.css"/>" rel="stylesheet" type="text/css" />
    <link href="<spring:url value="/static/jquery-ui/jquery-ui.structure.min.css"/>" rel="stylesheet" type="text/css" /> 
    <!-- link base js  -->
     <script src="<spring:url value="/static/jquery-ui/external/jquery/jquery.js"/>" type="text/javascript" charset="utf-8"></script>
    <script src="<spring:url value="/static/jquery-ui/jquery-ui.js"/>" type="text/javascript" charset="utf-8"></script>
    <script src="<spring:url value="/static/bootstrap/js/bootstrap.js"/>" type="text/javascript" charset="utf-8"></script>
    <script src="<spring:url value="/static/bootstrap/js/bootstrap.min.js"/>" type="text/javascript" charset="utf-8"></script>
    <script src="<spring:url value="/static/bootstrap/js/npm.js"/>" type="text/javascript" charset="utf-8"></script>
    <!-- it form  me -->
    <script src="<spring:url value="/static/js/jquery.form.js"/>" type="text/javascript" charset="utf-8"></script>
    <script src="<spring:url value="/static/js/login.js"/>" type="text/javascript" charset="utf-8"></script>
    <script src="<spring:url value="/static/js/main.js"/>" type="text/javascript" charset="utf-8"></script>
   
    <!--表单验证  -->
    <script src="<spring:url value="/static/js/validation/validation_cn.js"/>" type="text/javascript" charset="utf-8"></script>
    <script src="<spring:url value="/static/js/main.js"/>" type="text/javascript" charset="utf-8"></script>
    
         
