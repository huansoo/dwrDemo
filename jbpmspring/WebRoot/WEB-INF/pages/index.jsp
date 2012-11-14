<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  <body>
   请先登录：
   <form action="<%=request.getContextPath()%>/login.do" method="POST">
   		<input name="username" type="text"/><br/>
   		<input name="password" type="text"/><br/>
   		<input type="submit" value="登录"/><br/>
   </form>
  </body>
</html>
