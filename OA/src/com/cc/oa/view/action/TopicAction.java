package com.cc.oa.view.action;

import java.util.Date;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cc.oa.base.BaseAction;
import com.cc.oa.domain.Forum;
import com.cc.oa.domain.Topic;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class TopicAction extends BaseAction<Topic> {

	private long forumId;

	/**
	 * 显示单个主题(主贴+回帖列表)
	 * 
	 * @return
	 * @throws Exception
	 */
	public String show() throws Exception {

		// 准备数据：topic
		Topic topic = topicService.getById(model.getId());
		ActionContext.getContext().put("topic", topic);

		// 准备数据：replyList
		//List<Reply> replyList = replyService.findByTopic(topic);
		//ActionContext.getContext().put("replyList", replyList);
		return "show";
	}

	/**
	 * 新的主题
	 * 
	 * @return
	 * @throws Exception
	 */
	public String addUI() throws Exception {

		// 准备数据：forum
		Forum forum = forumService.getById(forumId);
		ActionContext.getContext().put("forum", forum);
		return "addUI";
	}

	public String add() throws Exception {

		model.setForum(forumService.getById(forumId));
		// 当前操作的用户信息
		model.setAuthor(getCurrentUser());
		model.setIpAddr(ServletActionContext.getRequest().getLocalAddr());// ip地址
		model.setPostTime(new Date());

		topicService.save(model);
		return "show";
	}

	// -------------------------------------------------
	public long getForumId() {
		return forumId;
	}

	public void setForumId(long forumId) {
		this.forumId = forumId;
	}

}
