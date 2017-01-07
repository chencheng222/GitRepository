package com.cc.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cc.oa.base.BaseDaoImpl;
import com.cc.oa.dao.RoleDao;
import com.cc.oa.domain.Department;
import com.cc.oa.domain.Role;
import com.cc.oa.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl extends BaseDaoImpl<Role> implements RoleService {

	@Resource
	private RoleDao roleDao;
	
	@Override
	public List<Role> findAll() {
		return roleDao.findAll();
	}

	@Override
	public void delete(Long id) {
		roleDao.delete(id);
	}

	@Override
	public Role getById(Long id) {
		return roleDao.getById(id);
	}

	@Override
	public void update(Role role) {
		roleDao.update(role);
	}

	@Override
	public void save(Role role) {
		roleDao.save(role);
	}

}
