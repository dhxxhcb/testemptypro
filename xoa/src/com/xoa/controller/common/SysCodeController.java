package com.xoa.controller.common;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xoa.model.common.SysCode;
import com.xoa.service.common.SysCodeService;
import com.xoa.util.ToJson;

@Controller
@Scope(value = "prototype")
@RequestMapping("/code")
public class SysCodeController {
	@Resource
	private SysCodeService sysCodeService;
	
	
	@RequestMapping("/getCode")
	public  @ResponseBody
	ToJson<SysCode> getCode(String parentNo){
		return sysCodeService.getSysCode(parentNo);
	}
	
}
