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
 /**
 * @ClassName (类名):  UsersServiceImpl
 * @Description(简述): TODO
 * @author(作者):      zlf
 * @date(日期):        2017年4月17日 下午3:42:20
 *
 */
@Service
public class UsersServiceImpl implements UsersService {
	
	@Resource
	private UsersMapper usersMapper;

	 /**
	 * <p>Title: findUserByName</p>
	 * <p>Description: </p>
	 * @param byname
	 * @return
	 * @author(作者):  zlf
	 * @see com.xoa.service.users.UsersService#findUserByName(java.lang.String)
	 */
	@Override
	public Users findUserByName(String byname) {
		// TODO Auto-generated method stub
		return usersMapper.findUserByName(byname);
	}
 
	 /**
	 * <p>Title: getUsernameById</p>
	 * <p>Description: </p>
	 * @param uid
	 * @return
	 * @author(作者):  zlf
	 * @see com.xoa.service.users.UsersService#getUsernameById(int)
	 */
	@Override
	//将查询到的数据缓存到myCache中,并使用方法名称加上参数中的userNo作为缓存的key  
    //通常更新操作只需刷新缓存中的某个值,所以为了准确的清除特定的缓存,故定义了这个唯一的key,从而不会影响其它缓存值  
    @Cacheable(value="myCache", key="#uid") 
	public String getUsernameById(int uid) {
		System.out.println("数据库中查到此用户号[" + uid + "]对应的用户名为[" + usersMapper.getUsernameById(uid) + "]");
		return usersMapper.getUsernameById(uid);
	}

	 /**
	 * <p>Title: getDatagrid</p>
	 * <p>Description: </p>
	 * @return
	 * @author(作者):  zlf
	 * @see com.xoa.service.users.UsersService#getDatagrid()
	 */
	@Override
	public List<Users> getDatagrid() {
		// TODO Auto-generated method stub
		return usersMapper.getDatagrid();
	}

	 /**
	 * <p>Title: addUser</p>
	 * <p>Description: </p>
	 * @param user
	 * @author(作者):  zlf
	 * @see com.xoa.service.users.UsersService#addUser(com.xoa.model.users.Users)
	 */
	@Override
	public void addUser(Users user) {
		// TODO Auto-generated method stub
		usersMapper.addUser(user);
	}

	 /**
	 * <p>Title: editUser</p>
	 * <p>Description: </p>
	 * @param user
	 * @author(作者):  zlf
	 * @see com.xoa.service.users.UsersService#editUser(com.xoa.model.users.Users)
	 */
	@Override
	public void editUser(Users user) {
		// TODO Auto-generated method stub
		usersMapper.editUser(user);
	}

	 /**
	 * <p>Title: deleteUser</p>
	 * <p>Description: </p>
	 * @param uid
	 * @author(作者):  zlf
	 * @see com.xoa.service.users.UsersService#deleteUser(int)
	 */
	@Override
	public void deleteUser(int uid) {
		// TODO Auto-generated method stub
		usersMapper.deleteUser(uid);
	}
	 /**
	 * <p>Title: getUserNameById</p>
	 * <p>Description: </p>
	 * @param user_id
	 * @return
	 * @author(作者):  zlf
	 * @see com.xoa.service.users.UsersService#getUserNameById(int)
	 */
	@Override
	public String getUserNameById(int user_id) {
		String userName=usersMapper.getUsernameByUserId(user_id);
				return userName;
	}
	
	 /**
	 * <p>Title: getAlluser</p>
	 * <p>Description: </p>
	 * @param maps
	 * @param page
	 * @param pageSize
	 * @param useFlag
	 * @return
	 * @author(作者):  zlf
	 * @see com.xoa.service.users.UsersService#getAlluser(java.util.Map, java.lang.Integer, java.lang.Integer, boolean)
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

	 /**
	 * <p>Title: findUserByuid</p>
	 * <p>Description: </p>
	 * @param uid
	 * @return
	 * @author(作者):  zlf
	 * @see com.xoa.service.users.UsersService#findUserByuid(int)
	 */
	@Override
	public Users findUserByuid(int uid) {	
		Users users=usersMapper.findUserByuid(uid);
		return users;
	}

	 /**
	 * <p>Title: getUserByMany</p>
	 * <p>Description: </p>
	 * @param user
	 * @return
	 * @author(作者):  zlf
	 * @see com.xoa.service.users.UsersService#getUserByMany(com.xoa.model.users.Users)
	 */
	@Override
	public List<Users> getUserByMany(Users user) {
		List<Users> list=usersMapper.getUserByMany(user);
		return list;
	}


}
