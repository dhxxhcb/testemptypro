package com.xoa.service.users.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xoa.dao.department.DepartmentMapper;
import com.xoa.dao.menu.SysFunctionMapper;
import com.xoa.dao.users.UserFunctionMapper;
import com.xoa.model.department.Department;
import com.xoa.model.menu.SysFunction;
import com.xoa.model.users.UserFunction;
import com.xoa.model.users.Users;
import com.xoa.service.users.UserFunctionService;
import com.xoa.util.ToJson;
@Service
public class UserFunctionServiceImpl implements UserFunctionService {
	@Resource
	private UserFunctionMapper userFunctionMapper;
	@Resource
	private SysFunctionMapper sysFunctionMapper;
	@Resource
	private DepartmentMapper departmentMapper;
	@Override
	public ToJson<SysFunction> getMenu(int uid) {
		ToJson<SysFunction> toJson=new ToJson<SysFunction>(0,"显示结果");
		String[] strArray = null;
		List<SysFunction> sFunList=sysFunctionMapper.getAll();
		UserFunction uFun=userFunctionMapper.getMenuByUserId(uid);
		strArray=uFun.getUserFunCidStr().split(",");
		List<SysFunction> list1 = new ArrayList<SysFunction>();
		System.out.println(strArray.length);
		for (int j = 0; j < strArray.length; j++) {
			for (int i=j; i<sFunList.size(); i++) {  
				System.out.println(sFunList.get(j).getId());
				if (sFunList.get(i).getId().toString().equals(strArray[j])) {
					System.out.println("相等"+sFunList.get(i).getId());
					list1.add(sFunList.get(i));
					break; 
				}
			}
			
		}
		toJson.setObj(list1);
		return toJson;
	}
}
	/*@Override
	public ToJson<Department> getDep() {
		ToJson<Department> toJson=new ToJson<Department>(0,"显示结果");
		List<Department> dep=departmentMapper.getDatagrid();
		toJson.setObj(dep);
		return toJson;
	}*/
	/*@Override
	public ToJson<Users> getUser(int uid) {
		ToJson<Users> toJson=new ToJson<Users>(0,"显示结果");
		List<Users> userList=departmentMapper.getUserAll(uid);
		toJson.setObj(userList);
		return toJson;
	}}*/