<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<%@ include file="/public/head.jspf" %>  
  </head>
  
  <body>
  	<s:iterator value="#roleList">
			${id},
			${name},
			${description},
			<s:a action="roleAction_delete?id=%{id}" onclick="return confirm('确定要删除吗？')">删除</s:a>
			<s:a action="roleAction_editUI?id=%{id}">修改</s:a>
			<br/>
		</s:iterator>  

		<s:a action="roleAction_addUI">添加</s:a>
  </body>
</html>
