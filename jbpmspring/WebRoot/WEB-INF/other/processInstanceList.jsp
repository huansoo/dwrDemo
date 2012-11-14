<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  <body>
  <jsp:include page="include/header.jsp"></jsp:include>
 	<c:forEach items="${instanceList}" var="processInstance">
		流程实例：
		<a href="<%=request.getContextPath()%>/jbpm/viewProcessInstance.do?pi=${processInstance.id}">${processInstance.id}</a>
		${processInstance.state}
		<a href="<%=request.getContextPath()%>/jbpm/deleteProcessInstance.do?pi=${processInstance.id}">删除</a>
		<a href="<%=request.getContextPath()%>/jbpm/taskList.do?pi=${processInstance.id}">查看任务列表</a>
		<br/>
 	</c:forEach>
  </body>
</html>
