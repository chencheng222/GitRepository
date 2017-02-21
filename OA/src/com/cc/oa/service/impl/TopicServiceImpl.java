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
		return getSession().createQuery("FROM Topic t where t.forum=? ORDER BY t.type DESC,t.lastUpdateTime DESC")
				.setParameter(0, forum).list();
	}

	@Override
	public void save(Topic t) {

		//t.setReplyCount(0);// 默认
		//t.setLastReply(null);// 默认
		t.setLastUpdateTime(t.getPostTime());
		getSession().save(t);

		Forum forum = t.getForum();
		forum.setTopicCount(forum.getTopicCount() + 1);
		forum.setArticleCount(forum.getArticleCount() + 1);
		forum.setLastTopic(t);
		
		getSession().update(forum);
	}

}
