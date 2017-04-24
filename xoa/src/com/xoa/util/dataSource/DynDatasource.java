package com.xoa.util.dataSource;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * 创建作者:   张勇
 * 创建日期:   2017-4-20 上午11:02:32
 * 类介绍  :   数据源自定义注解
 * 构造参数:   
 *
 */
@Target({ElementType.METHOD,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DynDatasource {
	
	/**
	 * 
	 * 创建作者:   张勇
	 * 创建日期:   2017-4-20 上午11:02:42
	 * 方法介绍:   默认连接类型
	 * 参数说明:   @return
	 * @return     String
	 */
	String sourceName() default "mysqlDataSources";
	
}
