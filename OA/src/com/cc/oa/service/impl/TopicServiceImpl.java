package com.cc.oa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cc.oa.base.BaseDaoImpl;
import com.cc.oa.domain.Forum;
import com.cc.oa.domain.Topic;
import com.cc.oa.service.TopicService;

@Service
@SuppressWarnings("unchecked")
public class TopicServiceImpl extends BaseDaoImpl<Topic> implements TopicService {

	@Override
	public List<Topic> findByForum(Forum forum) {
		return getSession().createQuery("FROM Topic t where t.Forum=? ORDER BY t.type,t.lastUpdateTime DESC")
				.setParameter(0, forum)
				.list();
	}

}
