<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  <body>
	<jsp:include page="include/header.jsp"></jsp:include>
  	你总共有${fn:length(taskList)}条待办任务<br>
 	<c:forEach items="${taskList}" var="task">
		<a href="${task.formResourceName}?id=${task.id}">任务${task.id}</a>
		${task.name}
		<a href="<%=request.getContextPath()%>/jbpm/deleteProcessInstance.do?pi=${processInstance.id}">删除</a>
		<br/>
 	</c:forEach>
  </body>
</html>
