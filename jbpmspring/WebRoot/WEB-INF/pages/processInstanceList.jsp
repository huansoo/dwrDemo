<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  <body>
    <a href="<%=request.getContextPath()%>/jbpm/startProcessInstance.do">发起一个新流程实例</a>
 	<c:forEach items="${processInstanceList}" var="processInstance">
		流程实例：${processInstance.id} 	<br/>
 	</c:forEach>
  </body>
</html>
