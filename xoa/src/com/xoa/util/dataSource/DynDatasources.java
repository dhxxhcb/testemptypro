package com.xoa.util.dataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 
 * @ClassName (类名):  DynDatasources
 * @Description(简述): 获取数据源类型
 * @author(作者):      zy
 * @date(日期):        2017-4-17 下午2:38:23
 *
 */
public class DynDatasources extends AbstractRoutingDataSource{
	private Logger loger = Logger.getLogger(DynDatasources.class);
	
	/**
	 * 
	 * <p>Title: determineCurrentLookupKey</p>
	 * <p>Description: </p>
	 * @return  获取数据类型
	 * @author(作者):  zy
	 * @see org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource#determineCurrentLookupKey()
	 */
	@Override
	public Object determineCurrentLookupKey() {
		String type = DatasourcesUtils.getDataSourceType();
		loger.info("连接池获取数据源类型："+type);
		System.err.println(type);
		return	type;
	}

}
