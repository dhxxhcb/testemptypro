package com.xoa.util.dataSource;


import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * 
 * 创建作者:   张勇
 * 创建日期:   2017-4-20 上午11:03:35
 * 类介绍  :   切面
 * 构造参数:   
 *
 */
@Component("myInspectDatasource") 
@Aspect
public class MyInspectDatasource {
	private Logger loger = Logger.getLogger(MyInspectDatasource.class);

	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-20 上午11:03:35
	 * 类介绍  :   无参构造
	 * 构造参数:   MyInspectDatasource() 
	 *
	 */
	public MyInspectDatasource() {
		loger.info("进入获取数据源信息方法");
	}
	
	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-20 上午11:04:31
	 * 方法介绍:   切点
	 * 参数说明:   
	 * @return     void
	 */
	@Pointcut("execution(* com.xoa.service..*.*(..))")
	public void point(){
		loger.info("获取切面");
	}
	
	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-20 上午11:04:42
	 * 方法介绍:   切面拦截
	 * 参数说明:   @param joinPoint
	 * @return     void
	 */
	@Before("point()")
	public void aspectBefore(JoinPoint joinPoint) {
		loger.info("执行 @Before 方法");
		MethodSignature methodSignature = (MethodSignature) joinPoint
				.getSignature();
		DynDatasource datasource = methodSignature.getMethod().getAnnotation(
				DynDatasource.class);
		if (datasource == null) {
			return;
		}
		String dataSourceName = datasource.sourceName();
		loger.info("动态切换数据源[" + dataSourceName + "] 成功");
		DatasourcesUtils.setDataSources(dataSourceName);
	}
}
