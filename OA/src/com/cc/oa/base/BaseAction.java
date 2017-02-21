package com.cc.oa.base;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import com.cc.oa.domain.User;
import com.cc.oa.service.DepartmentService;
import com.cc.oa.service.ForumService;
import com.cc.oa.service.PrivilegeService;
import com.cc.oa.service.ReplyService;
import com.cc.oa.service.RoleService;
import com.cc.oa.service.TopicService;
import com.cc.oa.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	@Resource
	protected DepartmentService departmentService;
	
	@Resource
	protected RoleService roleService;
	
	@Resource
	protected UserService userService;
	
	@Resource
	protected PrivilegeService privliegeService;
	
	@Resource
	protected ForumService forumService;
	
	@Resource
	protected TopicService topicService;
	
	@Resource
	protected ReplyService replyService;
	
	protected T model;
	
	public BaseAction(){
		
		try {
			// 得到model的类型信息
			ParameterizedType pt =  (ParameterizedType) this.getClass().getGenericSuperclass();
			Class clazz = (Class) pt.getActualTypeArguments()[0];
			
			//获得model实例
			model = (T) clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public T getModel() {
		// TODO Auto-generated method stub
		return model;
	}

	/**
	 * 获取当前登陆的用户
	 * @return 当前登陆的用户
	 */
	protected User getCurrentUser() {
		return (User) ActionContext.getContext().getSession().get("user");
	}
}
