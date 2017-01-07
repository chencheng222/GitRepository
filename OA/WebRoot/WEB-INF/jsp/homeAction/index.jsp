<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<title>OA</title>
<%@ include file="/public/head.jspf"%>
<script type="text/javascript"
	src="${oa}/script/jquery_treeview/jquery.cookie.js"></script>
</head>

<frameset rows="100,*,25" framespacing=0 border=0 frameborder="0">
	<frame noresize name="TopMenu" scrolling="no"
		src="${oa}/homeAction_top.action">
	<frameset cols="180,*" id="resize">
		<frame noresize name="menu" scrolling="yes"
			src="${oa}/homeAction_left.action">
		<frame noresize name="right" scrolling="yes"
			src="${oa}/homeAction_right.action">
	</frameset>
	<frame noresize name="status_bar" scrolling="no"
		src="${oa}/homeAction_bottom.action">
</frameset>

<noframes>
	<body>
	</body>
</noframes>
</html>



