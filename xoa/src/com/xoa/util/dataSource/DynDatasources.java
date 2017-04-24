package com.xoa.util.dataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 
 * 创建作者:   张勇
 * 创建日期:   2017-4-20 上午11:02:53
 * 类介绍  :   获取数据源类型
 * 构造参数:   
 *
 */
public class DynDatasources extends AbstractRoutingDataSource{
	private Logger loger = Logger.getLogger(DynDatasources.class);
	
	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-20 上午11:02:53
	 * 类介绍  :   获取数据类型
	 * 构造参数:   
	 *
	 */
	@Override
	public Object determineCurrentLookupKey() {
		String type = DatasourcesUtils.getDataSourceType();
		loger.info("连接池获取数据源类型："+type);
		System.err.println(type);
		return	type;
	}

}
