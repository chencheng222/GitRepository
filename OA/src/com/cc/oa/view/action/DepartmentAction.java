package com.cc.oa.view.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cc.oa.base.BaseAction;
import com.cc.oa.domain.Department;
import com.cc.oa.service.DepartmentService;
import com.cc.oa.util.DepartmentUtil;
import com.mysql.jdbc.StringUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import freemarker.template.utility.StringUtil;

@Controller
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department> {
	// 上级部门id
	private long parentId;

	/**
	 * 部门列表
	 * 
	 * @return list
	 * @throws Exception
	 */
	public String list() throws Exception {
		List<Department> departmentList = null;

		if (parentId == 0) {
			departmentList = departmentService.findTopList();
		} else {
			departmentList = departmentService.findChildren(parentId);
			Department parent = departmentService.getById(parentId);
			ActionContext.getContext().put("parent", parent);
		}

		ActionContext.getContext().put("departmentList", departmentList);

		return "list";
	}

	/**
	 * 删除
	 * 
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {
		departmentService.delete(model.getId());

		return "toList";
	}

	/**
	 * 添加页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String addUI() throws Exception {
		List<Department> topList = departmentService.findTopList();
		List<Department> departmentList = DepartmentUtil.getAllDepartment(topList);
		
		ActionContext.getContext().put("departmentList", departmentList);

		return "addUI";
	}

	/**
	 * 添加操作
	 * 
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		model.setParent(departmentService.getById(parentId));
		departmentService.save(model);

		return "toList";
	}

	/**
	 * 编辑页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String editUI() throws Exception {
		// 绑定上级部门下拉框
		List<Department> departmentList = departmentService.findAll();
		ActionContext.getContext().put("departmentList", departmentList);
		// 绑定其他参数
		Department department = departmentService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(department);

		if (department.getParent() != null) {
			parentId = department.getParent().getId();
		}

		return "editUI";
	}

	/**
	 * 编辑操作
	 * 
	 * @return
	 * @throws Exception
	 */
	public String edit() throws Exception {
		Department department = departmentService.getById(model.getId());

		department.setParent(departmentService.getById(parentId));
		department.setName(model.getName());
		department.setDescription(model.getDescription());
		departmentService.update(department);

		return "toList";
	}

	// ----------------------------------------------------------------------------
	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

}
