package com.xoa.controller.work;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xoa.util.dataSource.ContextHolder;

/**
 * 创建作者:   张龙飞
 * 创建日期:   2017年5月22日 上午11:43:13
 * 类介绍  :    新建工作
 * 构造参数:   
 *
 */
@Controller
@Scope(value = "prototype")
@RequestMapping("/work")
public class WorkController {
	
	@RequestMapping("/addwork")
	    public String work(HttpServletRequest request) {
	        ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
	                "loginDateSouse"));
	        return "app/workflow/work/add_work";
	    }


}
