package com.cc.oa.service;

import java.util.List;

import com.cc.oa.base.BaseDao;
import com.cc.oa.domain.Forum;
import com.cc.oa.domain.Topic;

public interface TopicService extends BaseDao<Topic> {

	/**
	 * 查询当前版块下的主题列表。
	 * @param forum
	 * @return
	 */
	List<Topic> findByForum(Forum forum);

}
