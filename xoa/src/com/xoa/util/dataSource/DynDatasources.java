package com.xoa.util.dataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 获取数据源类型
 * @author zy
 *
 */
public class DynDatasources extends AbstractRoutingDataSource{
	private Logger loger = Logger.getLogger(DynDatasources.class);
	
	@Override
	public Object determineCurrentLookupKey() {
		String type = DatasourcesUtils.getDataSourceType();
		loger.info("连接池获取数据源类型："+type);
		System.err.println(type);
		return	type;
	}

}
