package com.xoa.service.users;

import java.io.IOException;

import com.alibaba.fastjson.JSONObject;
import com.xoa.util.dataSource.DynDatasource;

public interface UsersPrivService {
	  /**
     * 根据用户priv_id获取用户姓名
     * 
     * @param  priv_id_str
     *            priv_id串
     * @return JSONObject
     *  		  用户姓名串
     * @throws IOException
     */
	@DynDatasource
	public JSONObject getPrivNameById(int... priv_id_str);
	
}
