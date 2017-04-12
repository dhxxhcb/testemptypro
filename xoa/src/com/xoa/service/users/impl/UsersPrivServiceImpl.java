package com.xoa.service.users.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.xoa.dao.users.UserPrivMapper;
import com.xoa.service.users.UsersPrivService;
@Service
public class UsersPrivServiceImpl implements UsersPrivService {
	@Resource
	private UserPrivMapper userPrivMapper;
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

}
