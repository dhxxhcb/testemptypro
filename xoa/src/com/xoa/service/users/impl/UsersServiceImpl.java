package com.xoa.service.users.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.xoa.dao.users.UsersMapper;
import com.xoa.model.users.Users;
import com.xoa.service.users.UsersService;
import com.xoa.util.page.PageParams;
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
	public String getUserNameById(int user_id) {
		String userName=usersMapper.getUsernameByUserId(user_id);
				return userName;
	}
	/**
	 * 用户分页查询
	 * 
	 * @param maps
	 *            相关条件参数传值
	 * @param page
	 *            当前页
	 * @param pageSize
	 *            每页显示条数
	 * @param useFlag
	 *            是否开启分页插件
	 * @return 结果集合
	 * @throws Exception
	 */
	@Override
	public List<Users> getAlluser(Map<String,Object> maps, Integer page,
			Integer pageSize, boolean useFlag) {
		PageParams pageParams = new PageParams();
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		pageParams.setUseFlag(useFlag);
		maps.put("page", pageParams);
		return usersMapper.getAlluser(maps);	
	}

	@Override
	public Users findUserByuid(int uid) {	
		Users users=usersMapper.findUserByuid(uid);
		return users;
	}

	@Override
	public List<Users> getUserByMany(Users user) {
		List<Users> list=usersMapper.getUserByMany(user);
		return list;
	}


}
