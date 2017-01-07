package com.cc.oa.service;

import java.util.List;

import com.cc.oa.base.BaseDao;
import com.cc.oa.domain.Role;

public interface RoleService extends BaseDao<Role>{

	/**
	 * 查詢所有
	 * @return
	 */
	List<Role> findAll();
	
	/**
	 * 根据id刪除
	 * @param id
	 */
	void delete(Long id);
	
	Role getById(Long id);
	
	void update(Role role);
	
	void save(Role role);
}
