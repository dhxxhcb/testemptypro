package com.xoa.service.users.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.xoa.dao.users.UserPrivMapper;
import com.xoa.model.users.UserPriv;
import com.xoa.service.users.UsersPrivService;
import com.xoa.util.page.PageParams;
 /**
 * 创建作者:   张龙飞
 * 创建日期:   2017年4月18日 下午6:32:17
 * 类介绍  :    角色权限
 * 构造参数:   
 *
 */
@Service
public class UsersPrivServiceImpl implements UsersPrivService {
	@Resource
	private UserPrivMapper userPrivMapper;
	 /**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午6:32:42
	 * 方法介绍:   格局privid串获取privName
	 * 参数说明:   @param priv_id_str
	 * 参数说明:   @return
	 * @return     JSONObject   
	 */
	@Override
	public JSONObject getPrivNameById(int... priv_id_str) {
		//定义返回的json字符串
				JSONObject json=new JSONObject();
				//定义用于拼接角色名称的字符串
				StringBuffer sb=new StringBuffer();
				  for (int i = 0; i < priv_id_str.length; i++) { 			  
					     if(priv_id_str.length==1){
					            String privName=userPrivMapper.getPrivNameById(priv_id_str[i]);
					            json.put("privName", privName);	 
					            return json;
					            }else{
					            String privName=userPrivMapper.getPrivNameById(priv_id_str[i]);
					            if(i<priv_id_str.length-1){
					            sb.append(privName).append("-");
					            }else{
					            sb.append(privName);
					            }
						        json.put("privName", sb.toString());	 
					            } 
					        }  
						return json;		
			}
	 /**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午6:32:47
	 * 方法介绍:   格局userpriv获取用户权限
	 * 参数说明:   @param up
	 * 参数说明:   @return
	 * @return     UserPriv   
	 */
	@Override
	public UserPriv selectByPrimaryKey(int up) {
		UserPriv userPriv=userPrivMapper.selectByPrimaryKey(up);
		return userPriv;
	}
	 /**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午6:32:51
	 * 方法介绍:   格局userpriv删除用户
	 * 参数说明:   @param userPriv
	 * @return     void   
	 */
	@Override
	public void deleteByPrimaryKey(int userPriv) {
		userPrivMapper.deleteByPrimaryKey(userPriv);
		
	}
	 /**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午6:32:58
	 * 方法介绍:   userpriv保存
	 * 参数说明:   @param record
	 * @return     void   
	 */
	@Override
	public void insertSelective(UserPriv record) {
		userPrivMapper.insertSelective(record);
		
	}
	 /**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午6:33:03
	 * 方法介绍:   获取所有userPriv
	 * 参数说明:   @param maps
	 * 参数说明:   @param page
	 * 参数说明:   @param pageSize
	 * 参数说明:   @param useFlag
	 * 参数说明:   @return
	 * @return     List<UserPriv>   
	 */
	@Override
	public List<UserPriv> getAllPriv(Map<String,Object> maps, Integer page,
			Integer pageSize, boolean useFlag) {
		PageParams pageParams = new PageParams();
		pageParams.setPage(page);
		pageParams.setPageSize(pageSize);
		pageParams.setUseFlag(useFlag);
		maps.put("page", pageParams);
		List<UserPriv> list=userPrivMapper.getAlluserPriv(maps);
		return list;
	}
	 /**
	 * 创建作者:   张龙飞
	 * 创建日期:   2017年4月18日 下午6:33:07
	 * 方法介绍:   多条件查询userPriv
	 * 参数说明:   @param priv
	 * 参数说明:   @return
	 * @return     List<UserPriv>   
	 */
	@Override
	public List<UserPriv> getPrivByMany(UserPriv priv) {
		List<UserPriv> list=userPrivMapper.getPrivByMany(priv);
		return list;
	}

}
