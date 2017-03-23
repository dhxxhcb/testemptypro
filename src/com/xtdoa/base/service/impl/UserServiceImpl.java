package com.xtdoa.base.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xtdoa.base.dao.BaseDao;
import com.xtdoa.base.model.User;
import com.xtdoa.base.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private BaseDao<User> userDao;
	
	@Override
	public boolean isUserLogin(String userName, String passWord) {
		System.out.println("返回结果集：" + userDao.userLogin(userName, passWord));
		boolean flag = false;
		int i = userDao.userLogin(userName, passWord);
		if (i == 1) {
			flag = true;
		}
		return flag;
	}

}
