package com.cc.oa.view.action;

import java.util.HashSet;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cc.oa.base.BaseAction;
import com.cc.oa.domain.Privilege;
import com.cc.oa.domain.Role;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role>{

	private Long[] privilegeIds;
	
	/**
	 * 列表
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception{
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		return "list";
	}
	
	/**
	 * 添加界面
	 * @return
	 * @throws Exception
	 */
	public String addUI() throws Exception{
		
		return "addUI";
	}
	
	/**
	 * 添加操作
	 * @return toList
	 * @throws Exception
	 */
	public String add() throws Exception{
		roleService.save(model);
		return "toList";
	}
	
	/**
	 * 编辑界面
	 * @return
	 * @throws Exception
	 */
	public String editUI() throws Exception{
		Role role = roleService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(role);
		
		return "editUI";
	}
	
	/**
	 * 编辑操作
	 * @return
	 * @throws Exception
	 */
	public String edit() throws Exception{
		Role role = roleService.getById(model.getId());
		role.setName(model.getName());
		role.setDescription(model.getDescription());
		
		roleService.update(role);
		return "toList";
	}
	
	/**
	 * 删除
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception{
		roleService.delete(model.getId());
		return "toList";
	}

	
	/**
	 * 权限设置画面
	 * @return
	 * @throws Exception
	 */
	public String setPrivilegeUI() throws Exception{
		Role role = roleService.getById(model.getId());
		ActionContext.getContext().put("role", role);
		
		List<Privilege> topPrivilegeList = privliegeService.findTopPrivilege();
		ActionContext.getContext().put("topPrivilegeList", topPrivilegeList);
		
		//回显
		privilegeIds = new Long[role.getPrivileges().size()];
		int index = 0;
		for (Privilege privilege : role.getPrivileges()) {
			privilegeIds[index++] = privilege.getId();
		}
		
		return "setPrivilegeUI";
	}
	
	
	/** 设置权限 */
	public String setPrivilege() throws Exception {
		// 从数据库中取出原对象
		Role role = roleService.getById(model.getId());

		// 设置要修改的属性
		List<Privilege> privilegeList = privliegeService.getByIds(privilegeIds);
		role.setPrivileges(new HashSet<Privilege>(privilegeList));

		// 更新到数据库中
		roleService.update(role);

		return "toList";
	}

	//--------------------------------------------------------------
	public Long[] getPrivilegeIds() {
		return privilegeIds;
	}

	public void setPrivilegeIds(Long[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}
	
	
	
}
