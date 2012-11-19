<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
	<script type='text/javascript' src='/dwr-test/dwr/engine.js'></script>
  	<script type='text/javascript' src='/dwr-test/dwr/interface/userAction.js'></script>
	<script type='text/javascript' src='/dwr-test/dwr/util.js'></script>
	<script type="text/javascript">
		function getResponse(){
			var name = dwr.util.getValue("name");
			userAction.sayHello(name,callBack);
		}
		var callBack=function(data){
			dwr.util.setValue("qq",data);
		}
	</script>
  </head>
  
  <body>
  <input type="text" name="name" onchange="getResponse()">
  <input type="text" name="qq"/>
  
  </body>
</html>
