<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  <body>
  <jsp:include page="include/header.jsp"></jsp:include>
  <a href="<%=request.getContextPath()%>/jbpm/startDeployment.do">发起一个流程定义</a><br><br><br>
 	<c:forEach items="${definitionList}" var="definition">
		流程定义：${definition.id} 
		<a href="<%=request.getContextPath()%>/jbpm/processInstanceList.do?pd=${definition.id}">查看流程实例列表</a>
		<a href="<%=request.getContextPath()%>/jbpm/startProcessInstance.do?pd=${definition.id}">发起新流程实例</a>
		<a href="<%=request.getContextPath()%>/jbpm/deleteProcessDeployment.do?pd=${definition.deploymentId}">删除</a>
		<br/>
 	</c:forEach>
  </body>
</html>
