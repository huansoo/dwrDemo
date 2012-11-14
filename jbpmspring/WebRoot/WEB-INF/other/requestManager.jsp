<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'request.jsp' starting page</title>
  </head>
  
  <body>
  <jsp:include page="include/header.jsp"></jsp:include>
   <fieldset>
    <legend>经理审核</legend>
    <form action="<%=request.getContextPath()%>/jbpm/submitRequest.do" method="post">
      	<input type="hidden" name="taskId" value="${taskId}">
	   	申请人：<input type="text" name="owner" value="${owner}"/><br/>
	 	请假时间：<input type="text" name="day" value="${day}"/><br/>
	   	请假原因：<textarea name="reason">${reason}</textarea><br/>
	   <input name="result" type="submit" value="批准"/><input name="result" type="submit" value="驳回"/>
    </form>
  </fieldset>
  </body>
</html>
