<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'request.jsp' starting page</title>
  </head>
  
  <body>
  <jsp:include page="include/header.jsp"></jsp:include>
   <fieldset>
    <legend>申请</legend>
    <form action="<%=request.getContextPath()%>/jbpm/submitRequest.do" method="post">
      	<input type="hidden" name="taskId" value="${param.id}">
	   	申请人：<input type="text" name="owner" value="${sessionScope['username']}"/><br/>
	 	请假时间：<input type="text" name="day" value=""/><br/>
	   	请假原因：<textarea name="reason"></textarea><br/>
	   <input type="submit" value="提交"/>
    </form>
  </fieldset>
  </body>
</html>
