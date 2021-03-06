<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
	<title>导航菜单</title>
	<%@ include file="/public/head.jspf"%>
	<link type="text/css" rel="stylesheet" href="style/blue/menu.css" />
	
	<script type="text/javascript">
		function menuClick( menuDiv ){
			// $(".MenuLevel2").not( $(menuDiv).next() ).hide();
			$(menuDiv).next().toggle(); // show(), hide(), toggle()
		}
	</script>
	
</head>
<body style="margin: 0">
<div id="Menu"> 
    <ul id="MenuUl">
		<%-- 顶级菜单 --%>
		<s:iterator value="#application.topPrivilegeList">
		<s:if test="#session.user.hasPrivilegeByName(name)">
	        <li class="level1">
	            <div onClick="menuClick(this);" class="level1Style">
	            	<img src="style/images/MenuIcon/${icon}" class="Icon" /> 
	            	${name}
	            </div>
	            <%-- 二级菜单 display: none; --%>
	            <ul style="" class="MenuLevel2">
	            	<s:iterator value="children">
		                <li class="level2">
		                <s:if test="#session.user.hasPrivilegeByName(name)">
		                    <div class="level2Style">
			                    <img src="style/images/MenuIcon/menu_arrow_single.gif" /> 
			                    <a target="right" href="${oa}/${url}.action"> ${name}</a>
		                 	</div>
		                </s:if>
		                </li>
	            	</s:iterator>
	            </ul>
	        </li>
	        </s:if>
		</s:iterator>       
    </ul>
</div>
</body>
</html>