package com.xoa.service.users.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.xoa.dao.users.UsersMapper;
import com.xoa.model.users.Users;
import com.xoa.service.users.UsersService;
@Service
public class UsersServiceImpl implements UsersService {
	
	@Resource
	private UsersMapper usersMapper;

	@Override
	public Users findUserByName(String byname) {
		// TODO Auto-generated method stub
		return usersMapper.findUserByName(byname);
	}
 
	@Override
	//将查询到的数据缓存到myCache中,并使用方法名称加上参数中的userNo作为缓存的key  
    //通常更新操作只需刷新缓存中的某个值,所以为了准确的清除特定的缓存,故定义了这个唯一的key,从而不会影响其它缓存值  
    @Cacheable(value="myCache", key="#uid") 
	public String getUsernameById(int uid) {
		System.out.println("数据库中查到此用户号[" + uid + "]对应的用户名为[" + usersMapper.getUsernameById(uid) + "]");
		return usersMapper.getUsernameById(uid);
	}

	@Override
	public List<Users> getDatagrid() {
		// TODO Auto-generated method stub
		return usersMapper.getDatagrid();
	}

	@Override
	public void addUser(Users user) {
		// TODO Auto-generated method stub
		usersMapper.addUser(user);
	}

	@Override
	public void editUser(Users user) {
		// TODO Auto-generated method stub
		usersMapper.editUser(user);
	}

	@Override
	public void deleteUser(int uid) {
		// TODO Auto-generated method stub
		usersMapper.deleteUser(uid);
	}

	@Override
	public JSONObject getUserNameById(int... user_id_str) {
		//定义返回的json字符串
				JSONObject json=new JSONObject();
				//定义用于拼接用户姓名的字符串
				StringBuffer sb=new StringBuffer();
				  for (int i = 0; i < user_id_str.length; i++) {  
			            if(user_id_str.length==1){
			            String userName=usersMapper.getUsernameByUserId(user_id_str[i]);
			            json.put("userName", userName);	 
			            return json;
			            }else{
			            String userName=usersMapper.getUsernameByUserId(user_id_str[i]);
			            if(i<user_id_str.length-1){
			            sb.append(userName).append("-");
			            }else{
			            sb.append(userName);
			            }
				        json.put("userName", sb.toString());	 
			            } 
			        }  
				return json;
	}
	
	
	

}
