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
	 * @param t 需要保存对象
	 */
	public void save(T t);
	
	/**
	 * 修改对象
	 * @param t 需修改对象
	 * @return  修改条数
	 */
	public Integer update(T t);
	
	/**
	 * 删除对象
	 * @param t 需删除对象
	 * @return 删除数据条数
	 */
	public Integer delete(T t);
	
	/**
	 * 查询结果返回
	 * @param maps 需传入map条件
	 * @return list集合  查询结果以list集合显示
	 */
	public List<T> selectObjcet(Map<String,T> maps);
}
