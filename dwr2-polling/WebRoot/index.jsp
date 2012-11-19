<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
	<script type='text/javascript' src='/dwrpush/dwr/interface/infoPush.js'></script>
  	<script type='text/javascript' src='/dwrpush/dwr/engine.js'></script>
	<script type='text/javascript' src='/dwrpush/dwr/util.js'></script>
	<script type="text/javascript">
		function beginInfo(){
			infoPush.beginShow();
			infoPush.sendInfo();
		}
		function endInfo(){
			infoPush.endShow();
		}
	</script>
  </head>
  
  <body onload="dwr.engine.setActiveReverseAjax(true);">
   
<div id="timezone">wait...</div>

<button onclick="beginInfo()" value="开始">开始</button>
<button onclick="endInfo()" value="结束">结束</button>

  </body>
</html>
