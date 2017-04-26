package com.xoa.util.dataSource;

/**
 * 
 * 创建作者:   张勇
 * 创建日期:   2017-4-20 上午11:01:40
 * 类介绍  :   数据源获取
 * 构造参数:   
 *
 */
public class DatasourcesUtils {
	/**
	 * mysqls
	 */
	public final static String MYSQL_DATA_SOURCES = "mysqlDataSources";
	/** 
	 * oracle
	 */
	public final static String ORACLE_DATA_SOURCES = "oracleDataSources";
	
	private static final ThreadLocal<String> contextHolder= new ThreadLocal<String>();
	
	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-20 上午11:01:53
	 * 方法介绍:   设置数据源名称
	 * 参数说明:   @param datasourceName
	 * @return     void
	 */
	public static void setDataSources (String datasourceName) {
		contextHolder.set(datasourceName);
	}
	
	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-20 上午11:02:07
	 * 方法介绍:   获取连接类型
	 * 参数说明:   @return
	 * @return     String
	 */
	public static String getDataSourceType () {
		return contextHolder.get();
	}
	
	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-20 上午11:02:17
	 * 方法介绍:   初始化
	 * 参数说明:   
	 * @return     void
	 */
	public static void clear(){
		contextHolder.remove();
	}


}
