<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
 	<script type='text/javascript' src='/dwrmessage/dwr/engine.js'></script>
	<script type='text/javascript' src='/dwrmessage/dwr/interface/ChatManager.js'></script>
  	<script type='text/javascript' src='/dwrmessage/dwr/util.js'></script>
    <script type="text/javascript" src="../js/chat.js"></script>
  </head>
  <body>
	<input type="hidden" name="userId" id="userId"/>
	<br>
	昵称:
	<input type="text" name="username" id="username"/>
	<input type="button" value="注册" onclick="register(this);" />
	<br />
	<br />
	我要对
	<select name="receiver" id="receiver" disabled="disabled" ></select>
	说:
	<input type="text" name="message" id="message" disabled="disabled" />
	<input type="button" value="发送" id="send" name="send" disabled="disabled"	onclick="send();" />
	<br />
	<br />
	在线用户列表:
	<ul id="users"></ul>
	
	<div id="showMessage" style="display: none">
		<span id="sender"></span>对你说:
		<span id="msg"></span>
	</div>

  </body>
</html>
