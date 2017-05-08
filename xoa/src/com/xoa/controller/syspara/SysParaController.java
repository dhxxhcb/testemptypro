package com.xoa.controller.syspara;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xoa.model.common.SysPara;
import com.xoa.service.syspara.SysParaService;
import com.xoa.util.ToJson;
import com.xoa.util.dataSource.ContextHolder;

/**
 * 
 * @ClassName (类名):  SysParaController
 * @Description(简述): 逻辑层
 * @author(作者):      张丽军
 * @date(日期):        2017-5-5 下午4:22:51
 *
 */
@Controller
@RequestMapping(value="/syspara")
public class SysParaController {
	
	private Logger loger=Logger.getLogger(SysParaController.class);
	
	@Resource
	private SysParaService sysParaService;
	
	/**
	 * 
	 * @Title: selectSysPara
	 * @Description: 查询状态栏信息
	 * @author(作者): 张丽军
	 * @param: @param request
	 * @param: @return   
	 * @return: ToJson<SysPara>   
	 * @throws
	 */
	@ResponseBody
	@RequestMapping(value="/selectSysPara",produces = {"application/json;charset=UTF-8"})
	public ToJson<SysPara> selectSysPara(HttpServletRequest request){
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		ToJson<SysPara> tojson=new ToJson<SysPara>(0,"");
		try {
			List<SysPara> list=sysParaService.getIeTitle();
			//list=sysParaService.getIeTitle1();
			tojson.setObject(list);
			tojson.setMsg("ok");
			tojson.setFlag(0);
		} catch (Exception e) {
			tojson.setMsg(e.getMessage());
		}
		return tojson;
	}
	
	/**
	 * 
	 * @Title: updateSysPara
	 * @Description: 修改状态栏信息
	 * @author(作者): 张丽军
	 * @param: @param sysPara
	 * @param: @param request
	 * @param: @param surface
	 * @param: @return   
	 * @return: ToJson<SysPara>   
	 * @throws
	 */
	@RequestMapping(value="/updateSysPara",method=RequestMethod.POST)
	@ResponseBody
	public ToJson<SysPara> updateSysPara(SysPara sysPara,HttpServletRequest request, SysParaService surface){
		ContextHolder.setConsumerType("xoa" + (String) request.getSession().getAttribute(
				"loginDateSouse"));
		ToJson<SysPara> tojson = new ToJson<SysPara>(0,"");
		loger.debug("ID"+surface.getIeTitle());
		try {
			sysParaService.updateSysPara(sysPara);
			sysParaService.updateSysPara1(sysPara);
			tojson.setObject(sysPara);
			tojson.setMsg("ok");
			tojson.setFlag(0);
		} catch (Exception e) {
			tojson.setMsg(e.getMessage());
		}
		return tojson;
	}
}
