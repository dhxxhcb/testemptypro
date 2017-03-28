package com.xoa.service.users.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xoa.dao.users.UserFunctionMapper;
import com.xoa.model.menu.SysFunction;
import com.xoa.model.users.UserFunction;
import com.xoa.service.users.UserFunctionService;
@Service
public class UserFunctionServiceImpl implements UserFunctionService {
    @Resource
	private UserFunctionMapper userFunctionMapper;
	@Override
	public List<SysFunction> getMenu(int uid) {
	UserFunction uFun=userFunctionMapper.getMenuByUserId(uid);
			uFun.getUserFunCidStr();
		
		
		return null;
	}

}
