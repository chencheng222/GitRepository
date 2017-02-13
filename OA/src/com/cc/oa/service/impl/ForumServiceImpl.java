package com.cc.oa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cc.oa.base.BaseDaoImpl;
import com.cc.oa.domain.Forum;
import com.cc.oa.service.ForumService;

@Service
@SuppressWarnings("unchecked")
public class ForumServiceImpl extends BaseDaoImpl<Forum> implements ForumService {

	@Override
	public void save(Forum t) {
		getSession().save(t);
		// 设置Position位置为最大
		// Hiberate持久化状态，不需要再次更新，数据会实时同步
		t.setPosition(t.getId().intValue());
	}

	@Override
	public List<Forum> findAll() {
		return getSession().createQuery("From Forum f ORDER BY f.position ASC").list();
	}

	/**
	 * 上移
	 * 
	 * @param id
	 */
	public void moveUp(Long id) {
		// 获取交换位置的两个对象
		Forum forum = getById(id);
		Forum upForum = (Forum) getSession().createQuery("FROM Forum f WHERE f.position<? ORDER BY f.position DESC")
				.setParameter(0, forum.getPosition()).setFirstResult(0).setMaxResults(1).uniqueResult();
		if (upForum == null) {
			return;
		}

		int temp = forum.getPosition();
		forum.setPosition(upForum.getPosition());
		upForum.setPosition(temp);
	}

	/**
	 * 下移
	 * 
	 * @param id
	 */
	public void moveDown(Long id) {
		
		// 获取交换位置的两个对象
		Forum forum = getById(id);
		Forum downForum = (Forum) getSession().createQuery("FROM Forum f WHERE f.position>? ORDER BY f.position ASC")
				.setParameter(0, forum.getPosition()).setFirstResult(0).setMaxResults(1).uniqueResult();
		if (downForum == null) {
			return;
		}

		int temp = forum.getPosition();
		forum.setPosition(downForum.getPosition());
		downForum.setPosition(temp);
	}

}
