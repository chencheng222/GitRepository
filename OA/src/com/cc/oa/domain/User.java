package com.cc.oa.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;

/**
 * 用户
 * @author tyg
 * 
 */
public class User {
	private Long id;
	private Department department;
	private Set<Role> roles = new HashSet<Role>();

	private String loginName; // 登录名
	private String password; // 密码
	private String name; // 真实姓名
	private String gender; // 性别
	private String phoneNumber; // 电话号码
	private String email; // 电子邮件
	private String description; // 说明

	/**
	 * 根据登录名判断用户权限(登录名唯一)
	 * @param privilegeName
	 * @return
	 */
	public boolean hasPrivilegeByName(String privilegeName) {
		
		//超级管理员
		if (isAdmin()) {
			return true;
		}
		
		//非超级管理员用户权限判断
		for (Role role : roles) {
			for (Privilege privilege : role.getPrivileges()) {
				if (privilegeName.equals(privilege.getName())){
					return true;
				}
			}
				
		}
		return false;
	}
	
	/**
	 * 根据Action地址设置权限
	 * @param privilegeUrl
	 * @return
	 */
	public boolean hasPrivilegeByUrl(String privilegeUrl) {
		
		//超级管理员
		if (isAdmin()) {
			return true;
		}
		
		//以UI后缀的也拥有权限  例如：addUI.action = add.action权限相同
		if (privilegeUrl.endsWith("UI")) {
			privilegeUrl = privilegeUrl.substring(0, privilegeUrl.length()-2);
		}
		
		List<String> allPrivilegeUrls = (List<String>) ActionContext.getContext().getApplication().get("allPrivilegeUrls");
		
		//如果权限列表中没有对应的Url，则该Url作为公共资源访问
		if (!allPrivilegeUrls.contains(privilegeUrl)) {
			
			return true;
			
		} else {
			
			//非超级管理员用户权限判断
			for (Role role : roles) {
				for (Privilege privilege : role.getPrivileges()) {
					if (privilegeUrl.equals(privilege.getUrl())){
						return true;
					}
				}
				
			}
			return false;
		}
		
	}
	
	public boolean isAdmin() {
		
		return "admin".equals(loginName);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
