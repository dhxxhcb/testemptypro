package com.xoa.util.dataSource;


import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * 切面
 * 
 * @author zy
 * 
 */
@Component("myInspectDatasource") 
@Aspect
public class MyInspectDatasource {
	private Logger loger = Logger.getLogger(MyInspectDatasource.class);

	/**
	 * @Description:
	 */
	public MyInspectDatasource() {
		loger.info("进入获取数据源信息方法");
	}
	
	@Pointcut("execution(* com.xoa.service..*.*(..))")
	public void point(){
		loger.info("获取切面");
	}
	
	/**
	 * @Title: aspectBefore
	 * @param joinPoint
	 * @author: zy   执行方法之前进行拦截
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
