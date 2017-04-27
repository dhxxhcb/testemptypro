package com.xoa.util.common.session;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.shiro.web.session.HttpServletSession;

import com.xoa.util.common.StringUtils;

/**
 * 
 * @作者 韩东堂
 * @创建日期 2017-4-27 上午11:19:22
 * @类介绍 session工具类
 * @构造参数 无
 * 
 */
public class SessionUtils {
    
	/**
	 * 
	 * @作者 韩东堂
	 * @创建日期 2017-4-27 下午1:09:33 
	 * @方法介绍 session 配置类 Map型
	 * @参数说明 @param session
	 * @参数说明 @param params
	 * @return
	 */
	public static void putSession(HttpServletSession session,
			Map<String, Object> params) {
		if (session == null)
			throw new SessionException("session is null");
		if (params == null || params.size() == 0)
			return;
		for (Entry<String, Object> entry : params.entrySet()) {
			session.setAttribute(entry.getKey(), entry.getValue());
		}
	}
    /**
     * 
     * @作者 韩东堂
     * @创建日期 2017-4-27 下午1:10:19 
     * @方法介绍 session 配置类 Model型
     * @参数说明 @param session
     * @参数说明 @param obj
     * @return
     */
	
	public static void putSession(HttpServletSession session, Object obj) {
		if (session == null)
			throw new SessionException("session is null");
		if (obj == null)
			return;
		try {
			Field[] fields = Class.forName(obj.getClass().getName())
					.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				fields[i].setAccessible(true);
				session.setAttribute(fields[i].getName(), fields[i].get(obj));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new SessionException("session is null");
		}
	}
	
   /**
    * 
    * @作者 韩东堂
    * @创建日期 2017-4-27 下午1:12:47 
    * @方法介绍 session 配置类 单个型
    * @参数说明 @param session
    * @参数说明 @param key
    * @参数说明 @param value
    * @return
    */
	public static void putSession(HttpServletSession session,String key ,Object value){
		if (session == null)
			throw new SessionException("session is null");
		if(StringUtils.checkNull(key)) throw new SessionException("key is null");
		session.setAttribute(key, value);
	}
//	public static <T> getSessionInfo(HttpServletSession session,){
//		
//	}
	
	
	

}
