package com.cc.oa.view.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cc.oa.base.BaseAction;
import com.cc.oa.domain.Topic;

@Controller
@Scope("prototype")
public class TopicAction extends BaseAction<Topic> {

	/**
	 * 显示单个主题(主贴+回帖列表)
	 * @return
	 * @throws Exception
	 */
	public String show() throws Exception {

		return "show";
	}
	
	/**
	 * 新的主题
	 * @return
	 * @throws Exception
	 */
	public String addUI() throws Exception {
		
		return "addUI";
	}
	
	public String add() throws Exception {
		
		return "show";
	}
}
