package com.cc.oa.service;

import com.cc.oa.base.BaseDao;
import com.cc.oa.domain.User;

public interface UserService extends BaseDao<User> {

	User findByLoginNameAndPwd(String loginName, String password);

}
