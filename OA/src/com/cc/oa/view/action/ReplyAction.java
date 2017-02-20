package com.cc.oa.view.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cc.oa.base.BaseAction;
import com.cc.oa.domain.Reply;

@Controller
@Scope("prototype")
public class ReplyAction extends BaseAction<Reply> {

	/**
	 * 新的主题
	 * @return
	 * @throws Exception
	 */
	public String addUI() throws Exception {
		
		return "addUI";
	}
	
	/**
	 * 添加回复
	 * @return 所在主题列表
	 * @throws Exception
	 */
	public String add() throws Exception {
		
		return "toTopicShow";
	}
}
