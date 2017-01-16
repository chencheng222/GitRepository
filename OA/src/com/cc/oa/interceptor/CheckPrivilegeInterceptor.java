package com.cc.oa.interceptor;

import javax.script.Invocable;

import org.aopalliance.intercept.Invocation;

import com.cc.oa.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CheckPrivilegeInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		//获取User实例
		User user =  (User) ActionContext.getContext().getSession().get("user");
		String namespace = invocation.getProxy().getNamespace();
		String actionName = invocation.getProxy().getActionName();
		
		String privilegeUrl = null;
		if (namespace.endsWith("/")) {
			privilegeUrl = namespace + actionName;
		} else {
			privilegeUrl = namespace + "/" + actionName;
		}
		
		//除去开头'/'
		if (privilegeUrl.startsWith("/")) {
			privilegeUrl = privilegeUrl.substring(1);
		}
		
		//未登录
		if (user == null) {
			//准备登陆
			if (privilegeUrl.startsWith("userAction_login")) {
				return invocation.invoke();
			} else {
				//转登录页面
				return "loginUI";
			}
			//已经登录
		} else {
			//权限判断
			if (user.hasPrivilegeByUrl(privilegeUrl)) {
				//有权限,放行
				return invocation.invoke();
			} else {
				return "noPrivilegeError";
			}
		}
		
	}

}
