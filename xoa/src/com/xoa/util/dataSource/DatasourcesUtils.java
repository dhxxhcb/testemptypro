package com.xoa.util.dataSource;

/**
 * 
 * @author zy
 * @version 1.0
 *
 */
public class DatasourcesUtils {
	/**
	 * mysql
	 */
	public final static String MYSQL_DATA_SOURCES = "mysqlDataSources";
	/** 
	 * oracle
	 */
	public final static String ORACLE_DATA_SOURCES = "oracleDataSources";
	
	private static final ThreadLocal<String> contextHolder= new ThreadLocal<String>();
	
	/**
	 * 设置数据源名称
	 * @Title: setDataSources 
	 * @param datasourceName
	 */
	public static void setDataSources (String datasourceName) {
		contextHolder.set(datasourceName);
	}
	
	/**
	 * 获取连接类型
	 * @Title: getDataSourceType 
	 * @return
	 */
	public static String getDataSourceType () {
		return contextHolder.get();
	}
	
	/**
	 * 清除
	 * @Title: clear
	 */
	public static void clear(){
		contextHolder.remove();
	}


}
