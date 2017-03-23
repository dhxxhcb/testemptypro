package com.xoa.dao;

import java.io.Serializable;
import java.util.List;




/**
  * @author 作者:  张勇 
  * @version 版本： 1.0 
  * @parameter 
  * @since 
  * @return 
  */
@SuppressWarnings("all") 
public interface BaseDao<T> {
	
	/**
	 * 登录
	 */
	public Integer userLogin(String userName, String passWord);
	
	/**
	 * 条件查询或全部查询共有多少条数据
	 * @return
	 */
	public Integer queryForInt(Class clzz);

	/**
	 * 条件查询或全部查询返回结果集
	 * @param currentPage 页码
	 * @param pageSize 显示条数
	 * @return
	 */
	public List<T> queryForList(Class clzz, Integer currentPage, Integer pageSize);

	/**
	 * 保存信息
	 * @param user
	 */
	public void saveUser(T t);
	
	/**
	 * 获取所有信息
	 * @return
	 */
	public List<T> showDept(Class clzz);
	
	
	/**
	 * shiro验证
	 * @param hql
	 * @param param
	 * @return
	 */
	public T get(String hql, List<Object> param);
	
	/**
	 * 根据参数返回对象集合
	 * @param hql
	 * @param params
	 * @return
	 */
	public List<T> find(String hql, List<Object> params);
	
	/**
	 * 条件查询或全部查询返回结果集
	 * currentPage 页码
	 * pageSize 显示条数
	 */
	public List<T> queryForLists(Class clzz,Integer currentPage, Integer pageSize);
	
	
	/**
	 * 条件查询或全部查询共有多少条数据
	 */
	public Integer queryForInts(Class clzz) ;

    /**
     * 根据ID查询所有信息
     * @param id
     * @return
     */
    public T findById(Class clzz,Serializable id);
	

}
