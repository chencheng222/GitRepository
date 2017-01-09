package com.cc.oa.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cc.oa.domain.Privilege;
import com.cc.oa.service.PrivilegeService;

public class InitServletContextListener implements ServletContextListener {


	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContext application = sce.getServletContext();
		
		//得到最大的容器对象
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(application);
		//得到service实例对象
		PrivilegeService privilegeService = (PrivilegeService) ac.getBean("privilegeServiceImpl");
		List<Privilege> topPrivilegeList = privilegeService.findTopPrivilege();
		application.setAttribute("topPrivilegeList", topPrivilegeList);
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
