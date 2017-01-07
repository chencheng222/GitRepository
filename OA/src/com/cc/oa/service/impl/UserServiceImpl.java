package com.cc.oa.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import com.cc.oa.base.BaseDaoImpl;
import com.cc.oa.domain.User;
import com.cc.oa.service.UserService;

@Service
public class UserServiceImpl extends BaseDaoImpl<User> implements UserService {

	@Override
	public User findByLoginNameAndPwd(String loginName, String password) {
		return (User) getSession().createQuery("FROM User u WHERE u.loginName=? AND u.password=?")
				.setParameter(0, loginName)
				.setParameter(1, DigestUtils.md5Hex(password))
				.uniqueResult();
	}

}
