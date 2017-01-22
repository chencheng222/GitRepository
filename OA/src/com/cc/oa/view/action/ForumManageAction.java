package com.cc.oa.view.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cc.oa.base.BaseAction;
import com.cc.oa.domain.Forum;

@Controller
@Scope("prototype")
public class ForumManageAction extends BaseAction<Forum> {

	public String list() throws Exception{
		
		return "list";
	}
	
	/**
	 * 添加界面
	 * @return
	 * @throws Exception
	 */
	public String addUI() throws Exception{
		
		return "addUI";
	}
	
	/**
	 * 添加操作
	 * @return toList
	 * @throws Exception
	 */
	public String add() throws Exception{
		return "toList";
	}
	
	/**
	 * 编辑界面
	 * @return
	 * @throws Exception
	 */
	public String editUI() throws Exception{
		
		return "editUI";
	}
	
	/**
	 * 编辑操作
	 * @return
	 * @throws Exception
	 */
	public String edit() throws Exception{
		return "toList";
	}
	
	/**
	 * 删除
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception{
		return "toList";
	}
}
