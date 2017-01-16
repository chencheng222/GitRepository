package com.cc.oa.service;

import java.util.List;

import com.cc.oa.base.BaseDao;
import com.cc.oa.domain.Privilege;

public interface PrivilegeService extends BaseDao<Privilege>{


	/**
	 * 获取顶层权限菜单
	 * @return
	 */
	List<Privilege> findTopPrivilege();

	/**
	 * 取得所有权限Url（不含Null，不重复）
	 * @return
	 */
	List<String> getAllPrivilegeUrls();
	
}
