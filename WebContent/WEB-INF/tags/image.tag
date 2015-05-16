<%-- <%@tag import="com.chengh.util.PathUtil,com.chengh.util.AppConfig"%>
 --%>
<%@tag import="org.springframework.web.context.WebApplicationContext"%>
<%@tag import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ tag pageEncoding="UTF-8" %>
<%--attribute for input --%>
<%@ attribute name="key" required="false"  type="java.lang.String" %>
<%@ attribute name="webpath" required="false" %>
<%@ attribute name="id" required="false"  type="java.lang.Long"%><%--商品id --%>
<%--attribute for input --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	  WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(application);
	/*   AppConfig appConfig =  ctx.getBean(AppConfig.class); */
 %>
	<%
/* 	 	String path = PathUtil.getItemPic(key,id,4);
 */	 %>
	<%-- <img  src="<%=appConfig.getUploadFilePath()%><%=path %>${webpath}"/>
 --%>