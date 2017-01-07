package com.cc.oa.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.cc.oa.domain.Department;

public class DepartmentUtil {

	/**
	 * 以某种方式获取全部部门
	 * @param departmentTopList
	 * @return
	 */
	public static List<Department> getAllDepartment(List<Department> departmentTopList) {
		List<Department> departmentList = new ArrayList<Department>();
		String prefix = "┣";
		setDepartmentTree(departmentTopList, prefix, departmentList);
		return departmentList;
	}

	/**
	 * 递归调用设置树形菜单结构
	 * @param departmentTopList 树根
	 * @param prefix 连接符
	 * @param departmentList 返回
	 */
	private static void setDepartmentTree(Collection<Department> departmentTopList, String prefix,
			List<Department> departmentList) {
		for (Department top : departmentTopList) {
			Department department = new Department();
			department.setId(top.getId());
			department.setName(prefix + top.getName());
			departmentList.add(department);
			
			setDepartmentTree(top.getChildren(), "　" + prefix, departmentList);
		}
	}
}
