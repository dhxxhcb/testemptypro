package com.xoa.util.dataSource;

/**
 * 
 * @ClassName (类名):  DatasourcesUtils
 * @Description(简述): 数据源获取
 * @author(作者):      zy
 * @date(日期):        2017-4-17 下午2:35:03
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
	 * 
	 * @Title: setDataSources
	 * @Description: 设置数据源名称
	 * @author(作者):      zy
	 * @param: @param datasourceName   数据源名称
	 * @return: void   
	 * @throws
	 */
	public static void setDataSources (String datasourceName) {
		contextHolder.set(datasourceName);
	}
	
	/**
	 * 
	 * @Title: getDataSourceType
	 * @Description: 获取连接类型
	 * @author(作者):      zy
	 * @param: @return   
	 * @return: String   字符串
	 * @throws
	 */
	public static String getDataSourceType () {
		return contextHolder.get();
	}
	
	/**
	 * 
	 * @Title: clear
	 * @Description: 清除
	 * @author(作者):      zy
	 * @param:    
	 * @return: void   
	 * @throws
	 */
	public static void clear(){
		contextHolder.remove();
	}


}
