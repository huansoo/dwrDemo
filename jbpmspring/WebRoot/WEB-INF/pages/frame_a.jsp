<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="include/check.jsp"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'frame_a.jsp' starting page</title>
  </head>
  <body>
当前用户【${user.username}】,<a href="<%=request.getContextPath()%>/logout.do">登出</a><br/>
<hr/>
<b>请假申请</b><br/>
<a href="<%=request.getContextPath()%>/jbpm/sendLeave.do">我要请假</a><br/>
<a href="<%=request.getContextPath()%>/jbpm/signalLeave.do">送审请假条</a><br/>
<hr/>
<b>流程列表</b><br/>
<a href="<%=request.getContextPath()%>/jbpm/sendLeave.do">我发起的所有任务</a><br/>
<a href="<%=request.getContextPath()%>/jbpm/sendLeave.do">我的待办任务</a><br/>
<a href="<%=request.getContextPath()%>/jbpm/sendLeave.do">我的经办任务</a><br/>
<hr/>
<b>系统设置</b><br/>
<a href="<%=request.getContextPath()%>/jbpm/sendLeave.do">职务列表</a><br/>
<a href="<%=request.getContextPath()%>/jbpm/sendLeave.do">注册用户</a><br/>
<a href="<%=request.getContextPath()%>/jbpm/sendLeave.do">用户列表</a><br/>
<a href="<%=request.getContextPath()%>/jbpm/sendLeave.do">请假条审批设置</a><br/>
<a href="<%=request.getContextPath()%>/jbpm/sendLeave.do">请假条审批设置列表</a><br/>

  </body>
</html>
