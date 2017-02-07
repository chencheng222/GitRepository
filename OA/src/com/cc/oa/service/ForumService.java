package com.cc.oa.service;

import com.cc.oa.base.BaseDao;
import com.cc.oa.domain.Forum;

public interface ForumService extends BaseDao<Forum> {

	/**
	 * 上移
	 * @param id
	 */
	void moveUp(Long id);
	
	/**
	 * 下移
	 * @param id
	 */
	void moveDown(Long id);
}
