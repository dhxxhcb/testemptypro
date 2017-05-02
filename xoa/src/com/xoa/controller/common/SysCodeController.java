package com.xoa.controller.common;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xoa.model.common.SysCode;
import com.xoa.service.common.SysCodeService;
import com.xoa.util.ToJson;
import com.xoa.util.dataSource.ContextHolder;

@Controller
@Scope(value = "prototype")
@RequestMapping("/code")
/**
 * 
 * 创建作者:   王曰岐
 * 创建日期:   2017-5-2 下午4:59:25
 * 类介绍  :    系统代码表控制器
 * 构造参数:   
 *
 */
public class SysCodeController {
	@Resource
	private SysCodeService sysCodeService;
	
	/**
	 * 
	 * 创建作者:   王曰岐
	 * 创建日期:   2017-5-2 下午4:59:42
	 * 方法介绍:   得到系统代码
	 * 参数说明:   @param parentNo
	 * 参数说明:   @return
	 * @return     ToJson<SysCode>
	 */
	@RequestMapping("/getCode")
	public  @ResponseBody
	ToJson<SysCode> getCode(String parentNo,HttpServletRequest request,HttpServletResponse response){
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		return sysCodeService.getSysCode(parentNo);
	}
	
}
