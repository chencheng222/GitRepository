package com.cc.oa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cc.oa.base.BaseDaoImpl;
import com.cc.oa.domain.Privilege;
import com.cc.oa.service.PrivilegeService;

@Service
@SuppressWarnings("unchecked")
public class PrivilegeServiceImpl extends BaseDaoImpl<Privilege> implements PrivilegeService{

	@Override
	public List<Privilege> findTopPrivilege() {
		return getSession().createQuery("FROM Privilege p WHERE parent IS NULL").list();
	}

	@Override
	public List<String> getAllPrivilegeUrls() {
		return getSession().createQuery("SELECT DISTINCT p.url FROM Privilege p WHERE p.url IS NOT NULL")
				.list();
	}
	
	

}
