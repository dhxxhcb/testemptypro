package com.xoa.global.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.xoa.service.im.ImDataException;
import com.xoa.util.common.wrapper.BaseWrapper;
/**
 * 
 * @作者 韩东堂
 * @创建日期 2017-4-26 下午6:30:26 
 * @类介绍  全局异常处理类
 * @构造参数 无
 *
 */
public class GlobalException implements HandlerExceptionResolver {
   
	
	@Override
	public ModelAndView resolveException(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3) {
		// TODO Auto-generated method stub
		FastJsonJsonView view = new FastJsonJsonView();
		ModelAndView modelAndView =new ModelAndView();
		//Im异常处理 其他类型异常参照着写
		if(arg3 instanceof ImDataException){
			Map<String, Object> ex =new HashMap<String, Object>();
			ex.put("status", false);
			ex.put("flag", false);
			ex.put("message", "操作失败");
			view.setAttributesMap(ex);
			modelAndView.setView(view);
		}
	
		return modelAndView;
	}

}
