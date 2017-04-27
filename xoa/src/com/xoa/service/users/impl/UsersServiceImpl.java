package com.xoa.service.users.impl;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xoa.dao.common.SyslogMapper;
import com.xoa.dao.users.UsersMapper;
import com.xoa.model.common.Syslog;
import com.xoa.model.users.Users;
import com.xoa.service.users.UsersService;
import com.xoa.util.CusAccessObjectUtil;
import com.xoa.util.common.StringUtils;
import com.xoa.util.page.PageParams;

 /**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月18日 下午6:29:38
 * 类介绍  :    用户service接口实现类
 * 构造参数:   
 *
 */
@Service
public class UsersServiceImpl implements UsersService {
	
	@Resource
	private UsersMapper usersMapper;
	@Resource
	private SyslogMapper syslogMapper;

	 /**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午4:44:24
	 * 方法介绍:   添加用户
	 * 参数说明:   @param user  用户信息
	 * @return     void   无
	 */
	@Override
	public void addUser(Users user) {
		usersMapper.addUser(user);
	}
	 /**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午4:44:34
	 * 方法介绍:   修改用户
	 * 参数说明:   @param user  用户信息
	 * @return     void    无
	 */
	@Override
	public void editUser(Users user) {
		usersMapper.editUser(user);
	}


	 /**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午5:44:51
	 * 方法介绍:   删除用户
	 * 参数说明:   @param uid 用户uid
	 * @return     void   无
	 */
	@Override
	public void deleteUser(int uid) {
		usersMapper.deleteUser(uid);
	}
	
	 /**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午4:46:36
	 * 方法介绍:   获取所有用户
	 * 参数说明:   @param maps  集合
	 * 参数说明:   @param page  当前页面
	 * 参数说明:   @param pageSize  页面大小
	 * 参数说明:   @param useFlag  是否开启分页
	 * 参数说明:   @return
	 * @return     List<Users>  返回用户信息集合 
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
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午4:46:52
	 * 方法介绍:   多条件查询
	 * 参数说明:   @param user  用户信息
	 * 参数说明:   @return
	 * @return     List<Users>  返回用户信息
	 */
	@Override
	public List<Users> getUserByMany(Users user) {
		List<Users> list=usersMapper.getUserByMany(user);
		return list;
	}

	 /**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午4:18:08
	 * 方法介绍:   获取用户信息和部门信息
	 * 参数说明:   @param maps  集合
	 * 参数说明:   @param page  当前页面
	 * 参数说明:   @param pageSize  页面大小
	 * 参数说明:   @param useFlag   是否开启分页
	 * 参数说明:   @return
	 * @return     List<Users>   返回用户信息
	 */
	@Override
	public List<Users> getUserAndDept(Map<String,Object> maps, Integer page,
			Integer pageSize, boolean useFlag) {
		PageParams pageParams = new PageParams();
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		pageParams.setUseFlag(useFlag);
		maps.put("page", pageParams);
		return usersMapper.getUserAndDept(maps);
	}
	 /**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午5:01:06
	 * 方法介绍:   格局uid获取用户信息
	 * 参数说明:   @param uid  用户uid
	 * 参数说明:   @return
	 * @return     Users   返回用户信息
	 */
	@Override
	public Users findUserByuid(int uid) {
		Users user=usersMapper.findUserByuid(uid);
		return user;
	}
	 /**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月19日 上午9:48:51
	 * 方法介绍:   根据别名获取用户信息
	 * 参数说明:   @param byname  用户别名
	 * 参数说明:   @return
	 * @return     Users  返回用户
	 */
	@Override
	public Users findUserByName(String byname,HttpServletRequest req) {
		Users user=usersMapper.findUserByName(byname);
		user.setDeptName(user.getDep().getDeptName());
		user.setCompanyName("北京高速波软件有限公司");
		Syslog sysLog=new Syslog();
	    sysLog.setLogId(0);
	    sysLog.setUserId(user.getUserId());
	    sysLog.setTime(new Date());
	    String ip= CusAccessObjectUtil.getIpAddress(req);
	    sysLog.setIp(ip);
	    sysLog.setType(1);
	    sysLog.setRemark("");
	    syslogMapper.save(sysLog);
	    
		return user;
		}
	 /**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月21日 上午10:27:07
	 * 方法介绍:   根据输入条件进行查询
	 * 参数说明:   @param maps 集合
	 * 参数说明:   @param page 当前页面
	 * 参数说明:   @param pageSize  页面大小
	 * 参数说明:   @param useFlag  是否开启分页
	 * 参数说明:   @return
	 * @return     List<Users>   返回用户信息   
	 */
	@Override
	public List<Users> getBySearch(Map<String, Object> maps, Integer page, Integer pageSize, boolean useFlag) {
		PageParams pageParams = new PageParams();
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		pageParams.setUseFlag(useFlag);
		maps.put("page", pageParams);
		return usersMapper.getBySearch(maps);
	}
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月21日 上午11:00:05
	 * 方法介绍:   根据部门id查询用户信息
	 * 参数说明:   @param maps  集合
	 * 参数说明:   @param page  当前页面
	 * 参数说明:   @param pageSize  页面大小
	 * 参数说明:   @param useFlag  是否开启分页
	 * 参数说明:   @return
	 * @return     List<Users>  返回用户信息
	 */
	@Override
	public List<Users> getByDeptId(Map<String, Object> maps, Integer page, Integer pageSize, boolean useFlag) {
		PageParams pageParams = new PageParams();
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		pageParams.setUseFlag(useFlag);
		maps.put("page", pageParams);
		return usersMapper.getByDeptId(maps);
	}
	

	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月21日 上午11:00:05
	 * 方法介绍:   根据uid查询用户姓名、部门、角色信息
	 * 参数说明:   @param uid  用户uid
	 * 参数说明:   @return
	 * @return     Users  返回用户信息
	 */
	@Override
	public Users getByUid(int uid) {
		Users users=usersMapper.getByUid(uid);
		return users;
	}
	
	/**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月26日 下午5:20:05
	 * 方法介绍:   根据userId串获取用户姓名
	 * 参数说明:   @param uids  用户uid串
	 * 参数说明:   @return
	 * @return     List<String>  返回用户姓名串
	 */
	@Override
	public String getUserNameById(String userIds) {
		if(StringUtils.checkNull(userIds)){
			return null;
		}
		//定义用于拼接角色名称的字符串
		StringBuffer sb=new StringBuffer();
		String[] temp = userIds.split(",");  
		for(int i=0;i<temp.length;i++){
			if(!StringUtils.checkNull(temp[i])){
		 String userName=usersMapper.getUsernameByUserId(temp[i]);
		 if(userName!=""){  		
		 if(i<temp.length-1){
	            sb.append(userName).append(",");
	            }else{
	            sb.append(userName);
	            }
			}
		}
		}
		return sb.toString();
	}
}
