package com.xoa.util.dataSource;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @ClassName (类名):  DynDatasource
 * @Description(简述): 数据源自定义注解
 * @author(作者):      zy
 * @date(日期):        2017-4-17 下午2:37:18
 *
 */
@Target({ElementType.METHOD,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DynDatasource {
	
	/**
	 * 
	 * @Title: sourceName
	 * @Description: 默认连接类型
	 * @author(作者):      zy
	 * @param: @return   
	 * @return: String   
	 * @throws
	 */
	String sourceName() default "mysqlDataSources";
	
}
