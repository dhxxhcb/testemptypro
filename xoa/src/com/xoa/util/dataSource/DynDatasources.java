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
	protected Object determineCurrentLookupKey() {
		String type = DatasourcesUtils.getDataSourceType();
		loger.debug("类型：s"+type);
		System.err.println(type);
		return	type;
	}

}
