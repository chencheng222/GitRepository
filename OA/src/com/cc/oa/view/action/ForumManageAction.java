package com.cc.oa.view.action;

import java.util.List;

import javax.swing.text.html.FormSubmitEvent;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cc.oa.base.BaseAction;
import com.cc.oa.domain.Forum;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class ForumManageAction extends BaseAction<Forum> {

	public String list() throws Exception{
		List<Forum> forumList =  forumService.findAll();
		ActionContext.getContext().put("forumList", forumList);
		
		return "list";
	}
	
	/**
	 * 添加界面
	 * @return
	 * @throws Exception
	 */
	public String addUI() throws Exception{
		
		return "saveUI";
	}
	
	/**
	 * 添加操作
	 * @return toList
	 * @throws Exception
	 */
	public String add() throws Exception{
		forumService.save(model);
		
		return "toList";
	}
	
	/**
	 * 编辑界面
	 * @return
	 * @throws Exception
	 */
	public String editUI() throws Exception{
		Forum forum = forumService.getById(model.getId());
		ActionContext.getContext().getValueStack().push(forum);
		
		return "saveUI";
	}
	
	/**
	 * 编辑操作
	 * @return
	 * @throws Exception
	 */
	public String edit() throws Exception{
		Forum forum = forumService.getById(model.getId());
		forum.setName(model.getName());
		forum.setDescription(model.getDescription());
		forumService.update(forum);
		
		return "toList";
	}
	
	/**
	 * 删除
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception{
		forumService.delete(model.getId());
		
		return "toList";
	}
	
	/**
	 * 上移
	 * @return
	 * @throws Exception
	 */
	public String moveUp() throws Exception {
		forumService.moveUp(model.getId());
		
		return "toList";
	}

	/**
	 * 下移
	 * @return
	 * @throws Exception
	 */
	public String moveDown() throws Exception {
		forumService.moveDown(model.getId());
		
		return "toList";
	}
}
