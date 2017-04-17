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
 * @ClassName (类名):  MyInspectDatasource
 * @Description(简述): 切面
 * @author(作者):      zy
 * @date(日期):        2017-4-17 下午2:40:43
 *
 */
@Component("myInspectDatasource") 
@Aspect
public class MyInspectDatasource {
	private Logger loger = Logger.getLogger(MyInspectDatasource.class);

	/**
	 * 无参构造
	 * @Title:        MyInspectDatasource
	 * @author(作者):   zy
	 * @Description:    TODO(这里用一句话描述这个方法的作用)
	 * @param:    
	 * @throws
	 */
	public MyInspectDatasource() {
		loger.info("进入获取数据源信息方法");
	}
	
	/**
	 * 
	 * @Title: point
	 * @Description: 切点
	 * @author(作者):      zy
	 * @param:    
	 * @return: void   
	 * @throws
	 */
	@Pointcut("execution(* com.xoa.service..*.*(..))")
	public void point(){
		loger.info("获取切面");
	}
	
	/**
	 * 
	 * @Title: aspectBefore
	 * @Description: 执行方法之前进行拦截
	 * @author(作者):      zy
	 * @param: @param joinPoint   切点
	 * @return: void   
	 * @throws
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
