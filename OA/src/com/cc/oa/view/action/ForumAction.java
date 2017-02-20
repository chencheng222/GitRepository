package com.cc.oa.view.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cc.oa.base.BaseAction;
import com.cc.oa.domain.Forum;
import com.cc.oa.domain.Topic;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class ForumAction extends BaseAction<Forum> {

	public String list() throws Exception {
		List<Forum> forumList = forumService.findAll();
		ActionContext.getContext().put("forumList", forumList);
		
		return "list";
	}
	
	/**
	 * 显示单个版块(即主题列表)
	 * @return
	 * @throws Exception
	 */
	public String show() throws Exception {
		//当前版块数据
		Forum forum = forumService.getById(model.getId());
		ActionContext.getContext().put("forum", forum);
		
		//主题列表(当前版块)
		List<Topic> topicList = topicService.findByForum(forum);
		ActionContext.getContext().put("topicList", topicList);
		
		return "show";
	}
}
