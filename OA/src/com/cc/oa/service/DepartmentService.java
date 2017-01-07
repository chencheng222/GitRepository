package com.cc.oa.service;

import java.util.List;

import com.cc.oa.domain.Department;

public interface DepartmentService {

	List<Department> findAll();

	void delete(Long id);

	void save(Department model);

	Department getById(Long id);

	void update(Department department);

	/**
	 * 获得所有顶层部门
	 * @return
	 */
	List<Department> findTopList();

	/**
	 * 获得当前部门下的所有子部门
	 * @param parentId
	 * @return
	 */
	List<Department> findChildren(long parentId);

}
