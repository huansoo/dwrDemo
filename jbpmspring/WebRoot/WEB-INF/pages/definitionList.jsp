<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  <body>
    <a href="<%=request.getContextPath()%>/jbpm/startProcessInstance.do">发起一个新流程实例</a><br>
 	<c:forEach items="${definitionList}" var="definition">
		流程定义：${definition.id} 	<br/>
 	</c:forEach>
  </body>
</html>
