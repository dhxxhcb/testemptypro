package com.xoa.dao.base;

import java.util.List;
import java.util.Map;

/**
 * DAO父类
 * @author gaosubo
 *
 * @param <T>
 */
public interface BaseMapper<T> {

	
	/**
	 * 保存对象
	 * @param t
	 */
	public void save(T t);
	
	/**
	 * 修改对象
	 * @param t
	 * @return
	 */
	public Integer update(T t);
	
	/**
	 * 删除对象
	 * @param t
	 * @return
	 */
	public Integer delete(T t);
	
	/**
	 * 查询结果返回
	 * @param maps 需传入maps条件
	 * @return list集合
	 */
	public List<T> selectObjcet(Map<String,T> maps);
}
