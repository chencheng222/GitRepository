package com.cc.oa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cc.oa.base.BaseDaoImpl;
import com.cc.oa.domain.Privilege;
import com.cc.oa.service.PrivilegeService;

@Service
public class PrivilegeServiceImpl extends BaseDaoImpl<Privilege> implements PrivilegeService{

	@SuppressWarnings("unchecked")
	@Override
	public List<Privilege> findTopPrivilege() {
		return getSession().createQuery("FROM Privilege p WHERE parent IS NULL").list();
	}

}
