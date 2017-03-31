package com.xoa.util.dataSource;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;


/**
 * 切面
 * @author zy
 *
 */
public class MyInspectDatasource {
	private Logger loger = Logger.getLogger(MyInspectDatasource.class);
	/**
	 * @Description: 
	 */
	public MyInspectDatasource() {
		loger.info("进入拦截器方法");
//		System.out.println("进入拦截器方法");
	}
	
	/**
	 * 执行方法之前进行拦截
	 * @Title: aspectBefore 
	 * @param joinPoint
	 * @author: zy
	 */
	public void aspectBefore(JoinPoint joinPoint){
		loger.info("终于进来了！");
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		DynDatasource datasource = methodSignature.getMethod().getAnnotation(DynDatasource.class);
		if(datasource == null) {
			return ;
		}
		String dataSourceName = datasource.sourceName();
		loger.info("动态切换数据源["+dataSourceName+"] 成功");
		System.out.println("动态切换数据源["+dataSourceName+"] 成功");
		DatasourcesUtils.setDataSources(dataSourceName);
	}

}
